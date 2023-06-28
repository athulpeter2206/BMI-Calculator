package com.example.bmicalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SeekBar s1,s2;
    int seekBarValueW,seekBarValueH;
    TextView weight,Height,Result;
    int Gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s1=(SeekBar) findViewById(R.id.sb1);
        weight = (TextView) findViewById(R.id.txt3);
        Height = (TextView) findViewById(R.id.txt5);
        Result =(TextView) findViewById(R.id.Result);
        s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                seekBarValueW = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                weight.setText(String.valueOf(seekBarValueW));
            }
        });
        s2 = (SeekBar) findViewById(R.id.sb2);
        s2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                seekBarValueH = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Height.setText(String.valueOf(seekBarValueH));
            }
        });
    }
    public void onWomen(View view){
        Gender = 1;
        System.out.println(Gender);
    }
    public void onMen(View view){
        Gender=0;
        System.out.println(Gender);
    }
    public void onCalc(View view){
        if(weight == null && Height == null){
            Toast.makeText(this,"Please enter the Weight & Height",Toast.LENGTH_LONG);
        }else if(Height == null){
            Toast.makeText(this,"Please enter the Height",Toast.LENGTH_LONG);
        }else if (weight == null){
            Toast.makeText(this,"Please enter the Weight",Toast.LENGTH_LONG);
        }else{
            System.out.println("SBH value"+seekBarValueH);

            float htMeter = (float)seekBarValueH/100;
            System.out.println(htMeter);
            float htSquare = htMeter * htMeter;
            System.out.println(htSquare);
            System.out.println(seekBarValueW);
            float BMIIndex = seekBarValueW/htSquare;
            System.out.println(BMIIndex);
            if(BMIIndex < 18.4 && BMIIndex <=18.5){
                Toast.makeText(this,"UnderWeight",Toast.LENGTH_LONG).show();
                Result.setText("UnderWeight : BMI Value ="+BMIIndex);
            }else if(BMIIndex > 18.6 && BMIIndex <=24.9){
                Toast.makeText(this,"Normal",Toast.LENGTH_LONG).show();
                Result.setText("Normal : BMI Value ="+BMIIndex);
            }else if(BMIIndex > 25.0 && BMIIndex <=39.9){
                Toast.makeText(this,"OverWeight",Toast.LENGTH_LONG).show();
                Result.setText("Overweight : BMI Value ="+BMIIndex);
            }else if (BMIIndex >=40.0){
                Toast.makeText(this,"Obese",Toast.LENGTH_LONG).show();
                Result.setText("Obese : BMI Value ="+BMIIndex);
            }
        }
    }

    public void onClear(View view){
        Height.setText("");
        weight.setText("");
        Result.setText("");
        s1.setProgress(0);
        s2.setProgress(0);
    }

}
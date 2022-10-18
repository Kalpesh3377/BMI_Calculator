package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText Weight,heightFt,HeightInch;
        Button btn;
        TextView textView;
        ImageView img;
        Weight=findViewById(R.id.editWeight);
        heightFt=findViewById(R.id.editHeightFt);
        HeightInch=findViewById(R.id.editHeightInch);
        btn=findViewById(R.id.btn);
        textView=findViewById(R.id.result);
        img=findViewById(R.id.img);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt=Integer.parseInt(Weight.getText().toString());
                int ft=Integer.parseInt(heightFt.getText().toString());
                int in=Integer.parseInt(HeightInch.getText().toString());

                int totalIn=ft*12+in;
                double totalCm=totalIn*2.53;
                double totalM=totalCm/100;
                double BMI=wt/Math.pow(totalM,2);

                if(BMI>25){
                    textView.setText("You're OverWeight!");
                    img.setImageResource(R.drawable.obesity);
                }
                else if(BMI<18){
                    textView.setText("You're UnderWeight!");
                    img.setImageResource(R.drawable.slim);
                }
                else{
                    textView.setText("You're Healthy!");
                    img.setImageResource(R.drawable.bodybuilder);
                }
            }
        });
    }
}
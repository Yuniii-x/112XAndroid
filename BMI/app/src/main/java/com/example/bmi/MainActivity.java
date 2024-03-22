package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView txvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txvShow = (TextView) findViewById(R.id.txvShow);
        txvShow.setTextSize(36);
        Button btnCalc = (Button) findViewById(R.id.btnCalc);
        Button btnClear = (Button) findViewById(R.id.btnClear);
        btnCalc.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }



    @Override
    public  void onClick(View V){
        EditText edtHight = (EditText) findViewById(R.id.edtHeight);
        EditText edtWeight = (EditText) findViewById(R.id.edtWeight);

        if(V.getId() == R.id.btnCalc){
            double height = Double.parseDouble((edtHight.getText().toString()));
            double wight = Double.parseDouble((edtWeight.getText().toString()));
            double bmi = wight / Math.pow(height/100.0,2);
            if(bmi >= 24)
                txvShow.setTextColor(Color.RED);
            else if (bmi < 18.5)
                txvShow.setTextColor(Color.BLUE);
            else
                txvShow.setTextColor((Color.GREEN));

            txvShow.setText(String.format("%.2f",bmi));

        }
        else{
            edtHight.setText("");
            edtWeight.setText("");
            txvShow.setText("");
        }
    }

}
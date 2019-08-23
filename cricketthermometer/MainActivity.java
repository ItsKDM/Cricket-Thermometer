package com.example.cricketthermometer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText etChirps;
    Button btnCalculate;
    TextView tvResult;
    DecimalFormat formatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etChirps = findViewById(R.id.etChirps);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);

        tvResult.setVisibility(View.GONE);

        formatter = new DecimalFormat("#0.0");

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (etChirps.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this,"Please enter all fields",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    int chirps = Integer.parseInt(etChirps.getText().toString().trim());

                    double temp = (chirps / 3.0) + 4;

                    String result = "The approximate Temperature outside is " + formatter.format(temp) + "degrees Celsius.";

                    tvResult.setText(result);

                    tvResult.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}

package com.example.lab2_quanmx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Random extends AppCompatActivity {
    private Button btnGenerate;
    private EditText txtMinValue;
    private EditText txtMaxValue;

    private TextView txtResult;
    private TextView txtMessage;

    private FloatingActionButton btnNextScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
        btnGenerate = (Button) findViewById(R.id.btnGenerate);
        btnNextScreen = (FloatingActionButton) findViewById(R.id.btnNextScreen);
        txtMinValue = (EditText) findViewById(R.id.txtMinValue);
        txtMaxValue = (EditText) findViewById(R.id.txtMaxValue);
        txtResult = (TextView) findViewById(R.id.txtRandomResult);
        txtMessage = (TextView) findViewById(R.id.txtMessage);

        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int min = Integer.parseInt(txtMinValue.getText().toString());
                    int max = Integer.parseInt(txtMaxValue.getText().toString());
                    if (min > max) {
                        txtMessage.setText("Wrong input data, min must smaller than max");
                        txtResult.setText("");
                    } else if (min < 0 || max < 0) {
                        txtMessage.setText("Wrong input data, min and max must be greater than or equal to 0");
                        txtResult.setText("");
                    } else {
                        txtMessage.setText("");
                        txtResult.setText(Integer.toString(generateNumber(min, max)));

                    }
                } catch (Exception exception) {
                    txtResult.setText("");
                    txtMessage.setText("Wrong input data, check again!");
                }
            }
        });
        btnNextScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent changeScreen = new Intent(v.getContext(), Calculator.class);
                startActivity(changeScreen);
            }
        });
    }

    private int generateNumber(int min, int max) {
        int result;
        result = min + (int) (Math.random() * (max - min));
        return result;
    }
}
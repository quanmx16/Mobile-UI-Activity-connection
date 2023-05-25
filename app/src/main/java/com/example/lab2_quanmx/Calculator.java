package com.example.lab2_quanmx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Calculator extends AppCompatActivity {

    private EditText txtFirstNumber;
    private EditText txtSecondNumber;
    private TextView txtMessage;
    private TextView txtResult;
    private Button btnSum;
    private Button btnSubtract;
    private Button btnMultiply;
    private Button btnDevide;
    private FloatingActionButton btnNextScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        txtFirstNumber = (EditText) findViewById(R.id.txtFirstNumber);
        txtSecondNumber = (EditText) findViewById(R.id.txtSecondNumber);

        btnSum = (Button) findViewById(R.id.btnSum);
        btnSubtract = (Button) findViewById(R.id.btnSubtract);
        btnMultiply = (Button) findViewById(R.id.btnMultiply);
        btnDevide = (Button) findViewById(R.id.btnDevide);

        txtMessage = (TextView) findViewById(R.id.txtMessage);
        txtResult = (TextView) findViewById(R.id.txtResult);
        btnNextScreen = (FloatingActionButton) findViewById(R.id.btnNextScreen);
        btnNextScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent changeScreen = new Intent(v.getContext(), SignIn.class);
                startActivity(changeScreen);
                finish();
            }
        });

        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstNumber = txtFirstNumber.getText().toString();
                String secondNumber = txtSecondNumber.getText().toString();
                if (isValidNumberFormat(firstNumber, secondNumber)) {
                    int n1 = Integer.parseInt(firstNumber);
                    int n2 = Integer.parseInt(secondNumber);
                    txtResult.setText(Integer.toString(sum(n1, n2)));
                }
            }
        });

        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstNumber = txtFirstNumber.getText().toString();
                String secondNumber = txtSecondNumber.getText().toString();
                if (isValidNumberFormat(firstNumber, secondNumber)) {
                    int n1 = Integer.parseInt(firstNumber);
                    int n2 = Integer.parseInt(secondNumber);
                    txtResult.setText(Integer.toString(subtract(n1, n2)));
                }
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstNumber = txtFirstNumber.getText().toString();
                String secondNumber = txtSecondNumber.getText().toString();
                if (isValidNumberFormat(firstNumber, secondNumber)) {
                    int n1 = Integer.parseInt(firstNumber);
                    int n2 = Integer.parseInt(secondNumber);
                    txtResult.setText(Integer.toString(multiply(n1, n2)));
                }
            }
        });

        btnDevide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstNumber = txtFirstNumber.getText().toString();
                String secondNumber = txtSecondNumber.getText().toString();
                if (isValidNumberFormat(firstNumber, secondNumber)) {
                    int n1 = Integer.parseInt(firstNumber);
                    int n2 = Integer.parseInt(secondNumber);
                    if (n2 != 0) {
                        txtResult.setText(Double.toString(devide(n1, n2)));
                    } else {
                        txtMessage.setText("Số thứ hai không thể bằng 0");
                    }
                }
            }
        });
    }

    private boolean isValidNumberFormat(String firstNumber, String secondNumber) {
        txtResult.setText("");
        boolean isValid = true;
        if (firstNumber.isEmpty()) {
            isValid = false;
            txtMessage.setText("Số thứ nhất không được để trống");
        } else if (secondNumber.isEmpty()) {
            isValid = false;
            txtMessage.setText("Số thứ hai không được để trống");
        } else {
            try {
                Integer.parseInt(firstNumber);
                Integer.parseInt(secondNumber);
                txtMessage.setText("");
            } catch (Exception ex) {
                isValid = false;
                txtMessage.setText("Giá trị truyền vào không đúng");
            }
        }
        return isValid;
    }

    private int sum(int n1, int n2) {
        return n1 + n2;
    }

    private int subtract(int n1, int n2) {
        return n1 - n2;
    }

    private int multiply(int n1, int n2) {
        return n1 * n2;
    }

    private double devide(int n1, int n2) {
        return (double) n1 / n2;
    }
}
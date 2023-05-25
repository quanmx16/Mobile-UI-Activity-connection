package com.example.lab2_quanmx;

import androidx.appcompat.app.AppCompatActivity;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SignIn extends AppCompatActivity implements View.OnClickListener {

    private EditText etUsername;
    private EditText etPassword;
    private TextView tvSignUpForm;
    private Button btnSigIn;
    private String REQUIRE = "Required";

    private FloatingActionButton btnNextScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        etUsername = (EditText) findViewById(R.id.txtUsername);
        etPassword = (EditText) findViewById(R.id.txtPassword);
        tvSignUpForm = (TextView) findViewById(R.id.tvSignUpForm);
        btnSigIn = (Button) findViewById(R.id.btnSignIn);
        btnSigIn.setOnClickListener(this);
        tvSignUpForm.setOnClickListener(this);
        btnNextScreen = (FloatingActionButton) findViewById(R.id.btnNextScreen);
        btnNextScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent changeScreen = new Intent(v.getContext(), SignUp.class);
                startActivity(changeScreen);
                finish();
            }
        });

    }

    private boolean isValidInput() {

        if (TextUtils.isEmpty(etUsername.getText().toString())) {
            etUsername.setError(REQUIRE);
            return false;
        }
        if (TextUtils.isEmpty(etPassword.getText().toString())) {
            etPassword.setError(REQUIRE);
            return false;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tvSignUpForm) {
            signUpForm();
        } else if (v.getId() == R.id.btnSignIn) {
            signIn();
        }
    }

    private void signIn() {
        if (!isValidInput()) {
            return;
        }
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void signUpForm() {
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
        finish();
    }
}
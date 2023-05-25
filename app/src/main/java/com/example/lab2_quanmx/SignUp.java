package com.example.lab2_quanmx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SignUp extends AppCompatActivity implements View.OnClickListener {

    private EditText etUsername;
    private EditText etPassword;
    private EditText etConfirmPassword;

    private TextView tvSignInForm;
    private Button btnSignUp;
    private String REQUIRE = "Required";
    private FloatingActionButton btnNextScreen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        etUsername = (EditText) findViewById(R.id.txtUsername);
        etPassword = (EditText) findViewById(R.id.txtPassword);
        etConfirmPassword = (EditText) findViewById(R.id.txtConfirmPassword);
        tvSignInForm = (TextView) findViewById(R.id.tvSignIn);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(this);
        tvSignInForm.setOnClickListener(this);
        btnNextScreen = (FloatingActionButton) findViewById(R.id.btnNextScreen);
        btnNextScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent changeScreen = new Intent(v.getContext(), Random.class);
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
        if (TextUtils.isEmpty(etConfirmPassword.getText().toString())) {
            etConfirmPassword.setError(REQUIRE);
            return false;
        }
        if (!TextUtils.equals(etPassword.getText().toString(), etConfirmPassword.getText().toString())) {
            Toast.makeText(this, "Password is not match", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tvSignIn) {
            signInForm();
        } else if (v.getId() == R.id.btnSignUp) {
            signUp();
        }
    }

    private void signUp() {
        if (!isValidInput()) {
        }
    }

    private void signInForm() {
        Intent intent = new Intent(this, SignIn.class);
        startActivity(intent);
        finish();
    }
}
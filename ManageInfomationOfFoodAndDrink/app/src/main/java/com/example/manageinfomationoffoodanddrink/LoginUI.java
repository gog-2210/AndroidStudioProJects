package com.example.manageinfomationoffoodanddrink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import org.w3c.dom.Text;


public class LoginUI extends AppCompatActivity {

    Button btnLogin;
    EditText edtEmail,edtPassword;
    TextView tvSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_ui);

        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        tvSignup = (TextView) findViewById(R.id.tvSignup);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtEmail.getText().toString().equals("a") && edtPassword.getText().toString().equals("a")){
                    Toast.makeText(LoginUI.this, "Sucessful!", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(LoginUI.this,MainActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginUI.this, "Failed !!!", Toast.LENGTH_SHORT).show();
                }

                if(edtEmail.getText().toString().isEmpty() || edtPassword.getText().toString().isEmpty()){
                    Toast.makeText(LoginUI.this, "Please check again Usename or Password !!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        tvSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginUI.this,RegisterUI.class);
                startActivity(intent);
            }
        });
    }
}
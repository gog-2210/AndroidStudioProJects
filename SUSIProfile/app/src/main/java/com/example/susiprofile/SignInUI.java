package com.example.susiprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignInUI extends AppCompatActivity {

    Button btnSI;
    EditText editU,editP;
    TextView txtSU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_ui);

        btnSI = (Button) findViewById(R.id.btnSI);
        editU = (EditText) findViewById(R.id.editU);
        editP = (EditText) findViewById(R.id.editP);
        txtSU = (TextView) findViewById(R.id.txtSU);

        btnSI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignInUI.this, ProFileUI.class);
                if(editU.getText().toString().equals("a") && editP.getText().toString().equals("a")){
                    Toast.makeText(SignInUI.this, "Sucessful!", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
                if(editU.getText().toString().isEmpty() || editP.getText().toString().isEmpty()){
                    Toast.makeText(SignInUI.this, "Please check again Usename or Password !!!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SignInUI.this, "Failed !!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        txtSU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignInUI.this, SignUpUI.class);
                startActivity(intent);
            }
        });
    }
}
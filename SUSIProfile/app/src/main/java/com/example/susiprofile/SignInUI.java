package com.example.susiprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
    }
}
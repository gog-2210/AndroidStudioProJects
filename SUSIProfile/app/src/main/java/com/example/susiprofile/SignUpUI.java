package com.example.susiprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SignUpUI extends AppCompatActivity {

    TextView txtSI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_ui);

        txtSI = (TextView) findViewById(R.id.txtSI);

        txtSI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(SignUpUI.this,SignInUI.class);
                startActivity(intent);
            }
        });
    }
}
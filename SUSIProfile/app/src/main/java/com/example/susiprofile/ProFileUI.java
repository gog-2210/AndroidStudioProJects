package com.example.susiprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProFileUI extends AppCompatActivity {
    Button btnBTSI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_ui);

        btnBTSI = (Button) findViewById(R.id.btnBTSI);
        btnBTSI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProFileUI.this, SignInUI.class);
                startActivity(intent);
            }
        });

    }
}
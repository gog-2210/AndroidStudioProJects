package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class activity2 extends AppCompatActivity {

    Button btnback;
    TextView txtcontent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        btnback = (Button) findViewById(R.id.btnBack);
        txtcontent = (TextView) findViewById(R.id.txtContent);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Intent intent= getIntent();
        String string = intent.getStringExtra("ConvertContent");
        txtcontent.setText(string);
    }
}
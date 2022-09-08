package com.example.cuocduakythu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView txtDiem;
    CheckBox cb1,cb2,cb3;
    SeekBar sb1,sb2,sb3;
    ImageButton ibtPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        CountDownTimer countDownTimer = new CountDownTimer(60000,300) {
            @Override
            public void onTick(long l) {
                int number = 5;
                Random random = new Random();
                int n1 = random.nextInt(number);
                int n2 = random.nextInt(number);
                int n3 = random.nextInt(number);
                sb1.setProgress(sb1.getProgress() + n1);
                sb2.setProgress(sb2.getProgress() + n2);
                sb3.setProgress(sb3.getProgress() + n3);
            }

            @Override
            public void onFinish() {

            }
        };
        ibtPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ibtPlay.setVisibility(View.INVISIBLE);
                countDownTimer.start();
            }
        });
    }

    private void AnhXa(){
        txtDiem     = (TextView)    findViewById(R.id.txtDiem);
        ibtPlay     = (ImageButton) findViewById(R.id.ibtPlay);
        cb1         = (CheckBox)    findViewById(R.id.cb1);
        cb2         = (CheckBox)    findViewById(R.id.cb2);
        cb3         = (CheckBox)    findViewById(R.id.cb3);
        sb1         = (SeekBar)     findViewById(R.id.sb1);
        sb2         = (SeekBar)     findViewById(R.id.sb2);
        sb3         = (SeekBar)     findViewById(R.id.sb3);
    }

}
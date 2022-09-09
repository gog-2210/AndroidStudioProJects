package com.example.cuocduakythu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView txtDiem;
    CheckBox cb1,cb2,cb3;
    SeekBar sb1,sb2,sb3;
    ImageButton ibtPlay;
    int soDiem = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mapping();

        CountDownTimer countDownTimer = new CountDownTimer(20000,150) {
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

                if(sb1.getProgress() >= sb1.getMax()) {
                    this.cancel();
                    ibtPlay.setVisibility(View.VISIBLE);
                    if(cb1.isChecked()){
                        soDiem +=10;
                        Toast.makeText(MainActivity.this, "You WON !!!", Toast.LENGTH_SHORT).show();
                    }else{
                        soDiem -=10;
                        Toast.makeText(MainActivity.this, "You LOST !!!", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(soDiem + "");
                    EnableTrue();
                }
                if(sb2.getProgress() >= sb2.getMax()) {
                    this.cancel();
                    ibtPlay.setVisibility(View.VISIBLE);
                    if(cb2.isChecked()){
                        soDiem +=10;
                        Toast.makeText(MainActivity.this, "You WON !!!", Toast.LENGTH_SHORT).show();
                    }else{
                        soDiem -=10;
                        Toast.makeText(MainActivity.this, "You LOST !!!", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(soDiem + "");
                    EnableTrue();
                }
                if(sb3.getProgress() >= sb3.getMax()) {
                    this.cancel();
                    ibtPlay.setVisibility(View.VISIBLE);
                    if(cb3.isChecked()){
                        soDiem +=10;
                        Toast.makeText(MainActivity.this, "You WON !!!", Toast.LENGTH_SHORT).show();
                    }else{
                        soDiem -=10;
                        Toast.makeText(MainActivity.this, "You LOST !!!", Toast.LENGTH_SHORT).show();
                    }
                    txtDiem.setText(soDiem + "");
                    EnableTrue();
                }
            }
            @Override
            public void onFinish() {

            }
        };
        ibtPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cb1.isChecked() || cb2.isChecked() ||cb3.isChecked()){
                    ibtPlay.setVisibility(View.INVISIBLE);
                    sb1.setProgress(0);
                    sb2.setProgress(0);
                    sb3.setProgress(0);
                    cb1.setEnabled(false);
                    cb2.setEnabled(false);
                    cb3.setEnabled(false);
                    sb1.setEnabled(false);
                    sb2.setEnabled(false);
                    sb3.setEnabled(false);
                    countDownTimer.start();
                }else {
                    Toast.makeText(MainActivity.this, "Please choose animal do you want to bet before start!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cb2.setChecked(false);
                    cb3.setChecked(false);
                }
            }
        });
        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cb1.setChecked(false);
                    cb3.setChecked(false);
                }
            }
        });
        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    cb2.setChecked(false);
                    cb1.setChecked(false);
                }
            }
        });
    }
    private  void  EnableTrue(){
        cb1.setEnabled(true);
        cb2.setEnabled(true);
        cb3.setEnabled(true);
        sb1.setEnabled(true);
        sb2.setEnabled(true);
        sb3.setEnabled(true);
    }
    private void Mapping(){
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
package com.example.baitap1;

import java.text.DecimalFormat;

import android.annotation.SuppressLint;

import android.os.Bundle;

import android.app.Activity;

import android.view.View;

import android.view.View.OnClickListener;

import android.widget.Button;

import android.widget.EditText;

import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
    Button btnTinhBMI;
    EditText editchieucao;
    EditText editcannang;
    TextView txtchuandoan, txtbaocao;
    TextView txtbmi;
    String NULL = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getControl();

        addEvent();
    }

    public void addEvent() {

        btnTinhBMI.setOnClickListener(new MyEvent());
    }

    public void getControl() {

        btnTinhBMI = (Button) findViewById(R.id.btnTinhBMI);

        editcannang = (EditText) findViewById(R.id.editcannang);

        editchieucao = (EditText) findViewById(R.id.editchieucao);

        txtbmi = (TextView) findViewById(R.id.txtbmi);

        txtchuandoan = (TextView) findViewById(R.id.txtchuandoan);

        txtbaocao = (TextView) findViewById(R.id.txtbaocao);
    }

    @Override
    public void onClick(View v) {

    }

    private class MyEvent implements OnClickListener {
        @Override
        public void onClick(View arg0) {
            if (arg0 == btnTinhBMI) {
                if (KiemTraDL() == true)
                    mtdTinhBMI();
            }
        }

        public void mtdTinhBMI() {

            double H = Double.parseDouble(editchieucao.getText() + "");

            double W = Double.parseDouble(editcannang.getText() + "");

            double BMI = W / (Math.pow(H, 2));

            String chuandoan = "";

            if (BMI < 18) {

                chuandoan = "Chuẩn đoán: Bạn gầy";

            } else if (BMI <= 24.9) {

                chuandoan = "Chuẩn đoán: Bạn bình thường";

            } else if (BMI <= 29.9) {

                chuandoan = "Chuẩn đoán: Bạn béo phì cấp độ 1";

            } else if (BMI <= 34.9) {

                chuandoan = "Chuẩn đoán: Bạn béo phì cấp độ 2";

            } else {

                chuandoan = "Chuẩn đoán: Bạn béo phì cấp độ 3";

            }
            DecimalFormat dcf = new DecimalFormat("#.0");

            txtbmi.setText("BMI:"+dcf.format(BMI));

            txtchuandoan.setText(chuandoan);

        }

        @SuppressLint("ResourceAsColor")
        public boolean KiemTraDL() {


            String strChieucao = editchieucao.getText() + "";

            String strCannang = editcannang.getText() + "";


            if ((strCannang == NULL) && (strChieucao == NULL)) {

                txtbaocao.setText("*Thiếu dữ liệu ở cả 2 ô chiều cao và cân nặng*");

                editchieucao.requestFocus();

                return false;

            }

            if (strChieucao == NULL) {


                txtbaocao.setText("*Bạn chưa nhập chiều cao*");

                editchieucao.requestFocus();

                return false;

            } else if (strCannang == NULL) {

                txtbaocao.setText("*Bạn chưa nhập cân nặng*");

                editcannang.requestFocus();

                return false;

            }
            txtbaocao.setText("");
            return true;

        }
    }
}
package com.example.productlist;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvFood;
    ArrayList<Food> arrayfood;
    FoodAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mapping();
        adapter = new FoodAdapter(this,R.layout.item_food,arrayfood);
        lvFood.setAdapter(adapter);


        lvFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,detail.class);
                startActivity(intent);
            }
        });
        lvFood.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
                b.setTitle("!!!");
                b.setMessage("Do you want remove it?");
                b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int j) {
                        arrayfood.remove(i);
                        adapter.notifyDataSetChanged();
                    }
                });
                b.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int j) {
                    }
                });
                b.create().show();
                return true;
            }
        });
    }
    public void Mapping(){
        lvFood =(ListView) findViewById(R.id.lvFood);
        arrayfood = new ArrayList<>();

        arrayfood.add(new Food("Beef steak","2050531200134",R.drawable.bittet));
        arrayfood.add(new Food("Hamburger","2050531200134",R.drawable.hambergur));
        arrayfood.add(new Food("SuSi","2050531200134",R.drawable.susi));
        arrayfood.add(new Food("Salad tr???n","2050531200134",R.drawable.saladtron));
        arrayfood.add(new Food("Xi??n th???t n?????ng","2050531200134",R.drawable.thitnuong));
        arrayfood.add(new Food("Khoai t??y chi??n","2050531200134",R.drawable.khoaitaychien));
        arrayfood.add(new Food("Tacos","2050531200134",R.drawable.tacos));
    }
}
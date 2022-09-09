package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvMonHoc;
    ArrayList<String> arrayCourse;
    Button btnThem, btnSua, btnXoa;
    EditText editName;
    int vitri = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvMonHoc= (ListView) findViewById(R.id.listviewA);
        btnThem =(Button) findViewById(R.id.buttonThem);
        btnSua =(Button) findViewById(R.id.buttonSua);
        btnXoa =(Button) findViewById(R.id.buttonXoa);
        editName=(EditText) findViewById(R.id.editName);
        arrayCourse=new ArrayList<>();
        arrayCourse.add("A");
        arrayCourse.add("B");
        arrayCourse.add("C");
        arrayCourse.add("D");
        arrayCourse.add("E");

        ArrayAdapter adapter= new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arrayCourse);
        lvMonHoc.setAdapter(adapter);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String monhoc=editName.getText().toString();
                arrayCourse.add(monhoc);
                adapter.notifyDataSetChanged();
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayCourse.set(vitri,editName.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayCourse.remove(vitri);
                editName.setText("");
                adapter.notifyDataSetChanged();
            }
        });

        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                editName.setText(arrayCourse.get(i));
                vitri = i;
            }
        });

        lvMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, activity2.class);
                intent.putExtra("ConvertContent","Màn hình chi tiết " + arrayCourse.get(i));
                startActivity(intent);
                Toast.makeText(MainActivity.this, "Màn hình chi tiết " + arrayCourse.get(i), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}
package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class howtojava extends AppCompatActivity implements View.OnClickListener {
    Button btnBackh,btnhome;
    ListView edit_Upid,edit_UpName,edit_UpTel;
    String tag_id = "namefood",tag_name="mash",tag_tel="howto";
    ArrayList<HashMap<String, String>> FoodList;
    ListView listfood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.howto);
        btnBackh = (Button) findViewById(R.id.btnbackh);
        btnBackh.setOnClickListener(this);

        btnhome = (Button) findViewById(R.id.btnhome);
        btnhome.setOnClickListener(this);

        edit_UpName = (ListView) findViewById(R.id.namef);
        edit_Upid = (ListView) findViewById(R.id.mf);
        edit_UpTel = (ListView) findViewById(R.id.hf);


//        MyDatabase myDB = new MyDatabase(this);
//        myDB.getWritableDatabase();
//        FoodList = myDB.SelectAllData();
//        listfood = (ListView) findViewById(R.id.listfoodcus);
//
//        SimpleAdapter simAdap;
//        simAdap = new SimpleAdapter(getApplicationContext(), FoodList, R.layout.layout_row,
//                new String[]{"mash"}, new int[]{R.id.col_id});
//        listfood.setAdapter(simAdap);

            }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnbackh:
                Intent intent = new Intent(getApplicationContext(), menucus.class);
                startActivity(intent);
                howtojava.this.finish();
                break;
            case R.id.btnhome:
                Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent1);
                howtojava.this.finish();
                break;
        }
    }
}


package com.example.project;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class menucus extends Activity implements View.OnClickListener {
    Button btnback,btntest;
    ListView listfood;
    ArrayList<HashMap<String, String>> FoodList;

    String tag_id = "namefood",tag_name="mash",tag_tel="howto",tag_edit="Edit",tag_delete="Delete";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menucus);

        btnback = (Button) findViewById(R.id.btnbackcus);
        btnback.setOnClickListener(this);

        btntest = (Button) findViewById(R.id.test);
        btntest.setOnClickListener(this);

        MyDatabase myDB = new MyDatabase(this);
        myDB.getWritableDatabase();
        FoodList = myDB.SelectAllData();
        listfood = (ListView) findViewById(R.id.listfoodcus);

        SimpleAdapter simAdap;
        simAdap = new SimpleAdapter(getApplicationContext(),FoodList,R.layout.layout_row,
                new String[]{"namefood"},new int[]{R.id.col_id});
        listfood.setAdapter(simAdap);



        listfood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(menucus.this,howtojava.class);
                i.putExtra(tag_id,id);
                startActivity(i);
            }
        });
    }

    @Override
    public void onClick(View v){
        Intent intent = null;
        switch (v.getId()){
            case R.id.btnbackcus:
                Intent intent1 = new Intent(getApplicationContext(), Selectitem.class);
                startActivity(intent1);
                menucus.this.finish();
                break;
            case R.id.test:
                Intent intent2 = new Intent(getApplicationContext(), howtojava.class);
                startActivity(intent2);
                menucus.this.finish();
                break;
        }
    }
}


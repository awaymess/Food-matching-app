package com.example.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class insertjava  extends Activity implements View.OnClickListener {
    Button btn_insert,back_insert;
    EditText step1, step2 , step3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insertinfo);
        init();
        btn_insert.setOnClickListener(this);
        back_insert.setOnClickListener(this);
    }
    private void init(){
        btn_insert=(Button)findViewById(R.id.insertbtn);
        back_insert=(Button)findViewById(R.id.backinse);
        step1=(EditText)findViewById(R.id.namefood);
        step2 = (EditText)findViewById(R.id.step2);
        step3 = (EditText)findViewById(R.id.step3);
    }
    public void onClick(View v){
        String namefood=step1.getText().toString();
        String mash=step2.getText().toString();
        String howto=step3.getText().toString();
        final  MyDatabase myDB = new MyDatabase(this);
        long flag = myDB.insertData(namefood,mash,howto);
        if(flag>0){
            Toast.makeText(getApplicationContext(),"Insert data Successfully.",Toast.LENGTH_LONG).show();
            Log.d("Insert Data","insert successfully");
            Intent i = new Intent(getApplication(),menujava.class);
            startActivity(i);
            finish();
        }else {
            Toast.makeText(getApplicationContext(),"Insert Data Failed",Toast.LENGTH_LONG).show();
            Log.d("Insert data","Insert Failed");
        }
        switch (v.getId()) {
            case R.id.backinse:
                Intent intent = new Intent(getApplicationContext(), menujava.class);
                startActivity(intent);
                insertjava.this.finish();
                break;
        }
    }
}

package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btncon,btnad,btnstr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btncon = (Button) findViewById(R.id.btn_con);
        btncon.setOnClickListener(this);

        btnad = (Button) findViewById(R.id.btn_ab);
        btnad.setOnClickListener(this);

        btnstr = (Button) findViewById(R.id.btn_st);
        btnstr.setOnClickListener(this);

    }

    public  void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_con:
                Intent intent = new Intent(getApplicationContext(), Contectjava.class);
                startActivity(intent);
                MainActivity.this.finish();
                break;
            case R.id.btn_ab:
                Intent intent1 = new Intent(getApplicationContext(), Aboutjava.class);
                startActivity(intent1);
                MainActivity.this.finish();
                break;
            case R.id.btn_st:
                Intent intent2 = new Intent(getApplicationContext(), Selectitem.class);
                startActivity(intent2);
                MainActivity.this.finish();
                break;
        }
    }
}

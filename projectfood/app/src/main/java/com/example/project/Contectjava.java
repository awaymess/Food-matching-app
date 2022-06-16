package com.example.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Contectjava  extends Activity implements View.OnClickListener {
    Button btnBackC,btndev;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);
        btnBackC = (Button) findViewById(R.id.cbtnBack);
        btnBackC.setOnClickListener(this);

        btndev = (Button) findViewById(R.id.dev);
        btndev.setOnClickListener(this);
    }

    public  void onClick(View v) {
        switch (v.getId()) {
            case R.id.cbtnBack:
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                Contectjava.this.finish();
                break;
            case R.id.dev:
                Intent intent1 = new Intent(getApplicationContext(), menujava.class);
                startActivity(intent1);
                Contectjava.this.finish();
                break;
        }
    }


}

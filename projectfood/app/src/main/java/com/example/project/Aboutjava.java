package com.example.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Aboutjava  extends Activity implements View.OnClickListener {
    Button btnBackA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        btnBackA = (Button) findViewById(R.id.abtnBack);
        btnBackA.setOnClickListener(this);
    }

    public  void onClick(View v) {
        switch (v.getId()) {
            case R.id.abtnBack:
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                Aboutjava.this.finish();
                break;
        }
    }


}

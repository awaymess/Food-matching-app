package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Selectitem extends AppCompatActivity implements View.OnClickListener {
    Intent intentData;
    CheckBox pizza,coffe,burger;
    Button buttonOrder,btnbacks,btnnext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectitem);

        btnbacks = (Button) findViewById(R.id.btnbacks);
        btnbacks.setOnClickListener(this);

        btnnext = (Button) findViewById(R.id.process);
        btnnext.setOnClickListener(this);

//        intentData = new Intent(Selectitem.this, menucus.class);
//        btnnext = (Button) findViewById(R.id.process);
//        btnnext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(intentData);
//            }
//        });

//        btnnext = (Button) findViewById(R.id.process);
//        btnnext.setOnClickListener(this);
//        addListenerOnButtonClick();
    }
//    public void onCheckedBox(View view){
//
//        boolean checked = ((CheckBox)view).isChecked();
//
//        switch (view.getId()){
//
//            case R.id.checkBox:if (checked){
//                intentData.putExtra("checkBox","checkBox");
//            }else {
//                intentData.removeExtra("checkBox");
//            }break;
//
//            case R.id.checkBox1:if (checked){
//                intentData.putExtra("TUE","Tuesday");
//            }else {
//                intentData.removeExtra("TUE");
//            }break;
//
//            case R.id.checkBox2:if (checked){
//                intentData.putExtra("WED","Wednesday");
//            }else {
//                intentData.removeExtra("WED");
//            }break;
//
//            case R.id.checkBox3:if (checked){
//                intentData.putExtra("THU","Thursday");
//            }else {
//                intentData.removeExtra("THU");
//            }break;
//
//            default:break;
//        }
//    }

    public  void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnbacks:
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                Selectitem.this.finish();
                break;
            case R.id.process:
                Intent intent1 = new Intent(getApplicationContext(), menucus.class);
                startActivity(intent1);
                Selectitem.this.finish();
                break;
        }
    }

}
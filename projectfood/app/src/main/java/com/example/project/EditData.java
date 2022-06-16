package com.example.project;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditData extends Activity implements View.OnClickListener {
    Button btn_save,btn_cancel;
    EditText edit_Upid,edit_UpName,edit_UpTel;
    String tag_id = "namefood",tag_name="mash",tag_tel="howto";
    String stdId,name,tel;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity);
        init();
    }
    private void init(){
        edit_UpName = (EditText)findViewById(R.id.edit_Upname);
        edit_Upid = (EditText)findViewById(R.id.edit_Upid);
        edit_UpTel = (EditText)findViewById(R.id.edit_UpMobile);
        btn_save = (Button)findViewById(R.id.btn_save);
        btn_cancel = (Button)findViewById(R.id.btn_cancel);
        btn_save.setOnClickListener(this);
        btn_cancel.setOnClickListener(this);

        Bundle bundle = getIntent().getExtras();
        stdId=bundle.getString(tag_id);
        name=bundle.getString(tag_name);
        tel=bundle.getString(tag_tel);

        edit_Upid.setText(stdId);
        edit_UpName.setText(name);
        edit_UpTel.setText(tel);
    }

    @Override
    public void onClick(View v){
        Intent i = null;
        switch (v.getId()){
            case R.id.btn_cancel:
                i=new Intent(getApplicationContext(),menujava.class);
                break;
            case R.id.btn_save:
                MyDatabase myDB = new MyDatabase(this);
                myDB.getWritableDatabase();
                String newName = edit_UpName.getText().toString();
                String newTel = edit_UpTel.getText().toString();
                long flag = myDB.UpdateData(stdId,newName,newTel);
                if(flag>0){
                    i=new Intent(getApplication(),menujava.class);
                    Toast.makeText(getApplicationContext(),"Update successfully",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Update failed",Toast.LENGTH_LONG).show();
                }

        }
        if (i !=null){
            startActivity(i);
            finish();
        }
    }
}

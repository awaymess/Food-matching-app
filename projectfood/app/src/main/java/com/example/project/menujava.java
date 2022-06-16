package com.example.project;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class menujava extends AppCompatActivity implements View.OnClickListener {
    Button btnBackm,test,btnAdd;
    TextView showResult;
    ListView listfood;
    ArrayList<HashMap<String, String>> FoodList;

    String tag_id = "namefood",tag_name="mash",tag_tel="howto",tag_edit="Edit",tag_delete="Delete";
    String[] strCmd = {tag_edit,tag_delete};
    EditText edit_search;
    public static String id_delete;


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.menu);
//        btnBackm = (Button) findViewById(R.id.btnbackm);
//        btnBackm.setOnClickListener(this);
//        init();
//        test = (Button) findViewById(R.id.test);
//        test.setOnClickListener(this);

//        showResult = (TextView) findViewById(R.id.textView13);
//        Intent intentResult = this.getIntent();
//        String checkBox = intentResult.getStringExtra("checkBox");
//        String tuesday = intentResult.getStringExtra("TUE");
//        String wednesday = intentResult.getStringExtra("WED");
//        String thursday = intentResult.getStringExtra("THU");
//
//
//        showResult.setText(checkBox+" , "+tuesday+" , "+wednesday+" , "+thursday);
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        btnBackm = (Button) findViewById(R.id.btnbackm);
        btnBackm.setOnClickListener(this);
        init();
        test = (Button) findViewById(R.id.add);
        test.setOnClickListener(this);

        init();
//        btnSearch.setOnClickListener(this);
    }
    private void  init(){
        MyDatabase myDB = new MyDatabase(this);
        myDB.getWritableDatabase();

        FoodList = myDB.SelectAllData();
        listfood = (ListView) findViewById(R.id.listfood);

        SimpleAdapter simAdap;
        simAdap = new SimpleAdapter(getApplicationContext(),FoodList,R.layout.layout_row,
                new String[]{"namefood"},new int[]{R.id.col_id});
        listfood.setAdapter(simAdap);

        registerForContextMenu(listfood);
//        edit_search=(EditText)findViewById(R.id.edit_search);
//        btnSearch = (Button)findViewById(R.id.btn_search);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v , ContextMenu.ContextMenuInfo menuInfo){
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;
        menu.setHeaderIcon(android.R.drawable.ic_menu_edit);
        menu.setHeaderTitle("[ "+ FoodList.get(info.position).get(tag_name).toString()+ "]");
        String[] menuItems = strCmd;
        for(int i=0;i<menuItems.length;i++){
            menu.add(Menu.NONE,i,i,menuItems[i]);
        }
        Log.d("Test 1","pass 1");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        int menuItemIndex= item.getItemId();
        String[]menuItem=strCmd;
        String CmdName=menuItem[menuItemIndex];
        Log.d("Test 2","pass 2");
        Toast.makeText(getApplicationContext(),"Deling",Toast.LENGTH_LONG).show();
        String id = FoodList.get(info.position).get(tag_id).toString();
        String name = FoodList.get(info.position).get(tag_name).toString();
        String tel = FoodList.get(info.position).get(tag_tel).toString();
        menujava.id_delete= id;

        if (tag_edit.equals(CmdName)){
            Intent i = new Intent(getApplicationContext(),EditData.class);
            i.putExtra(tag_id,id);
            i.putExtra(tag_name,name);
            i.putExtra(tag_tel,tel);
            Toast.makeText(getApplicationContext(),"Edit (Foodname = "+id+" )",Toast.LENGTH_LONG).show();
            startActivity(i);
        }else if(tag_delete.equals(CmdName)){
            final AlertDialog.Builder viewDetail = new AlertDialog.Builder(this);
            viewDetail.setIcon(android.R.drawable.ic_delete);
            viewDetail.setTitle("Confrim Delete ? ");
            viewDetail.setPositiveButton("Delete",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            MyDatabase db = new MyDatabase(getApplicationContext());
                            db.getWritableDatabase();
                            long flag = db.DeleteData(menujava.id_delete);
                            if (flag>0){
                                Toast.makeText(getApplicationContext(),"Delete (Foodname "
                                        +menujava.id_delete+ ") Sucessfully",Toast.LENGTH_LONG).show();
                                Intent i = new Intent(getApplicationContext(),menujava.class);
                                startActivity(i);
                                finish();
                                menujava.id_delete ="";
                            }else {
                                Toast.makeText(getApplicationContext(),"Delete failed",Toast.LENGTH_LONG).show();
                            }
                        }
                    });
            viewDetail.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            viewDetail.show();
        }
        return super.onContextItemSelected(item);

    }
    @Override
    public void onClick(View v){
        Intent intent = null;
        switch (v.getId()){
            case R.id.btnbackm:
                Intent intent1 = new Intent(getApplicationContext(), Contectjava.class);
                startActivity(intent1);
                menujava.this.finish();
                break;
            case R.id.add:
                Intent intent2 = new Intent(getApplicationContext(), insertjava.class);
                startActivity(intent2);
                menujava.this.finish();
                break;

//            case R.id.btn_search:
//                String strSearch = edit_search.getText().toString();
//                MyDatabase myDB = new MyDatabase(this);
//                myDB.getWritableDatabase();
//                StudentList = myDB.SearchData(strSearch);
//                SimpleAdapter simAdap;
//                simAdap = new SimpleAdapter(getApplicationContext(),
//                        StudentList,R.layout.layout_row,
//                        new  String[]{"StudentId","Name","Tel"},
//                        new int[]{R.id.col_id,R.id.col_name,R.id.col_mobile});
//                listView1.setAdapter(simAdap);
//                break;
        }
        if (intent !=null) {
            startActivity(intent);
        }
    }
}

//
//    public  void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.btnbackm:
//                Intent intent = new Intent(getApplicationContext(), Selectitem.class);
//                startActivity(intent);
//                menujava.this.finish();
//                break;
//            case R.id.test:
//                Intent intent1 = new Intent(getApplicationContext(), howtojava.class);
//                startActivity(intent1);
//                menujava.this.finish();
//                break;
//        }
//    }
//
//
//}

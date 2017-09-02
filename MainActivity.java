package com.example.iis5.contextmenuexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.iis5.contextmenuexample.Adaptor.Adaptor;
import com.example.iis5.contextmenuexample.Adaptor.Student;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
//creating listview and in xml file
    String Phone;
    ListView lv;
    String name1, name2, name3, name4, name5, name6, name7,
            phone1, phone2, phone3, phone4, phone5, phone6, phone7;
//taking arraylist to view the list items
    ArrayList<Student>mArrayList;
    Adaptor mStudentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.listview);

        mArrayList = new ArrayList<>();
//creating array list object
        mArrayList.add(new Student("Asha", "9778485689"));
        mArrayList.add(new Student("Rekha", "9956287987"));
        mArrayList.add(new Student("Disha", "9765487987"));
        mArrayList.add(new Student("Misha", "9778987987"));
        mArrayList.add(new Student("Trisha", "9578987997"));
        mArrayList.add(new Student("Mina", "9783876987"));
        mArrayList.add(new Student("Geetha", "9778987987"));
//fetching studentadapter to the adapter
        mStudentAdapter = new Adaptor(this, mArrayList);
        lv.setAdapter(mStudentAdapter);
        lv.setOnItemClickListener(this);
//register the context menu
        registerForContextMenu(lv);
    }
//creating oncreatecontextmenu and menu inflator
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
    }
//on creating we use this method to select the specific item
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.call:
                Toast.makeText(getApplicationContext(), "CALL " , Toast.LENGTH_SHORT).show();

                return true;
            case R.id.sms:
                Toast.makeText(getApplicationContext(), "SMS " , Toast.LENGTH_SHORT).show();

                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}









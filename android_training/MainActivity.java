package com.squareapp.android_training;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {



    private RecyclerView myRecyclerView;

    private MyAdapter myAdapter;
    private CustomAdapter customAdapter;

    private ArrayList<MyObject> myObjectList;
    private ArrayList<String> tasksList;
    private ArrayList<String> descriptionList;
    private ArrayList<String> urlImageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        myRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        myObjectList = new ArrayList<>();
        tasksList = new ArrayList<>();
        Collections.addAll(tasksList, "Arizona, USA", "Bolivia", "Russia", "Luang Prabang, Laos", "Wyoming, USA", "Peru");
        descriptionList = new ArrayList<>();
        Collections.addAll(descriptionList, "Antelope Canyon", "Salar de Uyuni", "Northern Lake Baikal", "Kuang Si Falls", "Grand Prismatic Spring", "Huacachina");
        urlImageList = new ArrayList<>();
        Collections.addAll(urlImageList, "https://content.skyscnr.com/2e49ce40b8541cf1ce13721676454e2a/GettyImages-486114691.jpg?resize=800px:99999px&quality=75"
        ,"https://content.skyscnr.com/e39998f504f924a7cb3dd64b5562bf62/GettyImages-484022402.jpg?resize=800px:99999px&quality=75"
                ,"https://content.skyscnr.com/895a30d6e9ed1778aab140f6ba56692f/GettyImages-478393436.jpg?resize=800px:99999px&quality=75"
                ,"https://content.skyscnr.com/09e159a7949caa55ffcc3183a15ab10a/GettyImages-533310705.jpg?resize=800px:99999px&quality=75"
                , "https://content.skyscnr.com/3b45a8035ff4819132314a4916c1e4fd/GettyImages-186133502.jpg?resize=800px:99999px&quality=75"
                ,"https://content.skyscnr.com/109a073b7c038e37b3f5c4990541ba2e/GettyImages-523790235.jpg?resize=800px:99999px&quality=75");

        //fill my object list with example data
        for(int i = 0; i < tasksList.size(); i++)
        {
            MyObject myObj = new MyObject(tasksList.get(i), descriptionList.get(i), urlImageList.get(i));
            myObjectList.add(myObj);
        }

        //myAdapter = new MyAdapter(this, myObjectList);
        customAdapter = new CustomAdapter(this, myObjectList);
        myRecyclerView.setAdapter(customAdapter);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));







        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }












    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

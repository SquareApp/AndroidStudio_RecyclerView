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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        myRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        myObjectList = new ArrayList<>();
        tasksList = new ArrayList<>();
        Collections.addAll(tasksList, "Mathe Hausaufgaben", "Physik Hausaufgaben", "Geschi-Referat", "Deutsch Lernen", "Englisch Text schreiben", "Deutsch Hausaufgaben");
        descriptionList = new ArrayList<>();
        Collections.addAll(descriptionList, "Seite 344", "Seite 144/145", "WK2","Die Verwandlung", "Evolution", "Gregor charakterisieren");

        //fill my object list with example data
        for(int i = 0; i < tasksList.size(); i++)
        {
            MyObject myObj = new MyObject(tasksList.get(i), descriptionList.get(i), "23.06.17");
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

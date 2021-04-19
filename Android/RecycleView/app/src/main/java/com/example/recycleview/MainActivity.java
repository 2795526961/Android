package com.example.recycleview;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Person> list;
    private PersonAdaper personAdaper;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initdata();
        initRecycleView();
        setListener();
        ActionBar supportActionBar = getSupportActionBar();
        if(supportActionBar!=null)
            supportActionBar.hide();
    }

    private void setListener() {
        personAdaper.setMyOnItemClickListener(new PersonAdaper.MyOnItemClickListener() {
            @Override
            public void onClick(View view, int i) {
                Toast.makeText(MainActivity.this,"点击了第"+(i+1)+"条数据",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initRecycleView() {

        recyclerView = findViewById(R.id.mrecycle);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        personAdaper = new PersonAdaper(list);
//        recyclerView.addItemDecoration(new divide());
        recyclerView.setAdapter(personAdaper);

    }

    private void initdata() {
        list = new ArrayList<>();
        list.add(new Person(1,"nihao",R.drawable.asd));
        list.add(new Person(1,"nihao",R.drawable.asd));
        list.add(new Person(1,"nihao",R.drawable.asd));
    }
}
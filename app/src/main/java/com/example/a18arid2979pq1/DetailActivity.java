package com.example.a18arid2979pq1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Class Attendance");

        ArrayList personNames = new ArrayList<>();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        ClassAdapter customAdapter = new ClassAdapter(personNames);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }
}
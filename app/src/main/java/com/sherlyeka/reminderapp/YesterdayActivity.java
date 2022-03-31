package com.sherlyeka.reminderapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.sherlyeka.reminderapp.recyclerView.AgendaAdapter;
import com.sherlyeka.reminderapp.recyclerView.DataAgenda;

import java.util.ArrayList;

public class YesterdayActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AgendaAdapter agendaAdapter;
    private ArrayList<DataAgenda> agendaArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yesterday);

        recyclerView = findViewById(R.id.recyclerView_itemYesterday);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(YesterdayActivity.this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(agendaAdapter);
    }


    public void btnYesterday(View view) {

    }
    public void btnToday(View view) {
        startActivity(new Intent(getApplicationContext(), TodayActivity.class));
    }
    public void btnTomorrow(View view) {
        startActivity(new Intent(getApplicationContext(), TomorrowActivity.class));
    }
}
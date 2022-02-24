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

        getData();
        recyclerView = findViewById(R.id.recyclerView_itemYesterday);
        agendaAdapter = new AgendaAdapter(agendaArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(YesterdayActivity.this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(agendaAdapter);
    }

    public void  getData(){
        agendaArrayList = new ArrayList<>();
        agendaArrayList.add(new DataAgenda("Sholat Jumat", "Hari Kemarin : Pukul","12.00"));
        agendaArrayList.add(new DataAgenda("Kumpul di labana", "Hari Kemarin : Pukul","13.00"));
        agendaArrayList.add(new DataAgenda("Pulang sekolah", "Hari Kemarin : Pukul","14.00"));
    }

    public void btnYesterday(View view) {
        Intent intent = new Intent(YesterdayActivity.this, YesterdayActivity.class);
        startActivity(intent);
    }
    public void btnToday(View view) {
        Intent intent = new Intent(YesterdayActivity.this, TodayActivity.class);
        startActivity(intent);
    }
    public void btnTomorrow(View view) {
        Intent intent = new Intent(YesterdayActivity.this, TomorrowActivity.class);
        startActivity(intent);
    }
}
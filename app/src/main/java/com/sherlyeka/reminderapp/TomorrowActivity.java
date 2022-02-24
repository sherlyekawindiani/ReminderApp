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

public class TomorrowActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AgendaAdapter agendaAdapter;
    private ArrayList<DataAgenda> agendaArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tomorrow);

        getData();
        recyclerView = findViewById(R.id.recyclerView_itemTomorrow);
        agendaAdapter = new AgendaAdapter(agendaArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(TomorrowActivity.this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(agendaAdapter);
    }
    public void  getData(){
        agendaArrayList = new ArrayList<>();
        agendaArrayList.add(new DataAgenda("Sholat Jumat", "Hari besok : Pukul","12.00"));
        agendaArrayList.add(new DataAgenda("Kumpul di labana", "Hari besok : Pukul","13.00"));
        agendaArrayList.add(new DataAgenda("Pulang sekolah", "Hari besok : Pukul","14.00"));
    }

    public void btnYesterday(View view) {
        Intent intent = new Intent(TomorrowActivity.this, YesterdayActivity.class);
        startActivity(intent);
    }
    public void btnToday(View view) {
        Intent intent = new Intent(TomorrowActivity.this, TodayActivity.class);
        startActivity(intent);
    }
    public void btnTomorrow(View view) {
        Intent intent = new Intent(TomorrowActivity.this, TomorrowActivity.class);
        startActivity(intent);
    }

}
package com.sherlyeka.reminderapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.sherlyeka.reminderapp.recyclerView.AgendaAdapter;
import com.sherlyeka.reminderapp.recyclerView.DataAgenda;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TodayActivity extends AppCompatActivity implements

        SwipeRefreshLayout.OnRefreshListener
{

     TextView namaUser;
     FirebaseAuth firebaseAuth;
     String user;
     RecyclerView recyclerView;
     AgendaAdapter agendaAdapter;
     ArrayList<DataAgenda> agendaArrayList = new ArrayList<>();
     FirebaseFirestore db;
     SwipeRefreshLayout swipeRefreshLayout;
     DocumentSnapshot lastQuery;;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today);
        recyclerView = findViewById(R.id.recyclerView_itemToday);
        swipeRefreshLayout = findViewById(R.id.swipe);

        swipeRefreshLayout.setOnRefreshListener(this);

        setUpFirebase();
        identity();
        recyclerView();
        getData();
    }

    public void filterData() {
        ArrayList<DataAgenda> futureEvents = new ArrayList<>();

        Date currentDate = new Date();
        for (DataAgenda event : agendaArrayList){
            SimpleDateFormat spf = new SimpleDateFormat("dd MMMM yyyy");
            Date date = null;
            try {
                date = spf.parse(" " + event.getTanggalAgenda());
            } catch (ParseException e){

            }
            if (currentDate.after(date)){
                futureEvents.add(event);
            }
        }
        agendaAdapter = new AgendaAdapter(TodayActivity.this, futureEvents);
        recyclerView.setAdapter(agendaAdapter);
    }



    public void setUpFirebase(){
        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getUid();
    }

    public void identity(){
        db = FirebaseFirestore.getInstance();
        namaUser = findViewById(R.id.namaUser);
        DocumentReference documentReference = db.collection("Akun").document(user);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                namaUser.setText(value.getString("name"));
            }
        });
    }

    public void recyclerView(){
        if (agendaAdapter == null){
            agendaAdapter = new AgendaAdapter(this, agendaArrayList);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(agendaAdapter);
    }

    public void getData(){
        db = FirebaseFirestore.getInstance();
        CollectionReference dataCollRef = db.collection("Agenda");
        Query dataQuery = null;
        if (lastQuery != null){
            dataQuery = dataCollRef.orderBy("waktuAgenda", Query.Direction.ASCENDING)
                    .startAfter(lastQuery);
        } else {
            dataQuery = dataCollRef.orderBy("waktuAgenda", Query.Direction.ASCENDING);
        }
        dataQuery.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    for (QueryDocumentSnapshot document:task.getResult()){
                        DataAgenda obj = document.toObject(DataAgenda.class);
                        agendaArrayList.add(obj);
                    } if (task.getResult().size() != 0){
                        lastQuery = task.getResult().getDocuments()
                                .get(task.getResult().size() - 1);
                    }
                    agendaAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(TodayActivity.this, "Query Gagal !!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void onRefresh(){
        getData();
        swipeRefreshLayout.setRefreshing(false);
    }

    public void btnYesterday(View view) {
        startActivity(new Intent(getApplicationContext(), YesterdayActivity.class));
    }
    public void btnToday(View view) {

    }
    public void btnTomorrow(View view) {
        startActivity(new Intent(getApplicationContext(), TomorrowActivity.class));
    }
}
package com.sherlyeka.reminderapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.sherlyeka.reminderapp.recyclerView.AgendaAdapter;
import com.sherlyeka.reminderapp.recyclerView.DataAgenda;

import java.util.ArrayList;
import java.util.List;

public class TodayActivity extends AppCompatActivity {

     TextView namaUser;
     FirebaseAuth firebaseAuth;
     String user;
     RecyclerView recyclerView;
     AgendaAdapter agendaAdapter;
     ArrayList<DataAgenda> agendaArrayList;
     FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today);
        namaUser = findViewById(R.id.namaUser);

        firebaseAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        user = firebaseAuth.getUid();

        DocumentReference documentReference = db.collection("Akun").document(user);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                namaUser.setText(value.getString("name"));
            }
        });

        recyclerView = findViewById(R.id.recyclerView_itemToday);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        db = FirebaseFirestore.getInstance();
        agendaArrayList = new ArrayList<>();
        agendaAdapter = new AgendaAdapter(agendaArrayList);
        recyclerView.setAdapter(agendaAdapter);

        db.collection("Agenda").orderBy("waktuAgenda", Query.Direction.ASCENDING).get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                        for (DocumentSnapshot data:list){
                            DataAgenda obj = data.toObject(DataAgenda.class);
                            agendaArrayList.add(obj);
                        }
                        agendaAdapter.notifyDataSetChanged();
                    }
                });

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
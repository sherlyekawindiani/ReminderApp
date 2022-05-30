package com.sherlyeka.reminderapp.recyclerView;

import com.google.firebase.firestore.ServerTimestamp;

import java.util.Date;

public class DataAgenda {
     String judulAgenda;
     @ServerTimestamp Date tanggalAgenda, waktuAgenda;

    public DataAgenda() {
    }

    public DataAgenda(String judulAgenda, Date tanggalAgenda, Date waktuAgenda) {
        this.judulAgenda = judulAgenda;
        this.tanggalAgenda = tanggalAgenda;
        this.waktuAgenda = waktuAgenda;
    }

    public String getJudulAgenda() {
        return judulAgenda;
    }

    public void setJudulAgenda(String judulAgenda) {
        this.judulAgenda = judulAgenda;
    }

    public Date getTanggalAgenda() {
        return tanggalAgenda;
    }

    public void setTanggalAgenda(Date tanggalAgenda) {
        this.tanggalAgenda = tanggalAgenda;
    }

    public Date getWaktuAgenda() {
        return waktuAgenda;
    }

    public void setWaktuAgenda(Date waktuAgenda) {
        this.waktuAgenda = waktuAgenda;
    }
}


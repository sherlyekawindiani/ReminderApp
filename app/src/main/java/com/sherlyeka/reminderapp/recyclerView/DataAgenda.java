package com.sherlyeka.reminderapp.recyclerView;

import java.sql.Timestamp;

public class DataAgenda {
     String judulAgenda, hariIni;
     Timestamp waktuAgenda;

    public DataAgenda() {
    }

    public DataAgenda(String judulAgenda, String hariIni, Timestamp waktuAgenda) {
        this.judulAgenda = judulAgenda;
        this.hariIni = hariIni;
        this.waktuAgenda = waktuAgenda;
    }

    public String getJudulAgenda() {
        return judulAgenda;
    }

    public void setJudulAgenda(String judulAgenda) {
        this.judulAgenda = judulAgenda;
    }

    public String getHariIni() {
        return hariIni;
    }

    public void setHariIni(String hariIni) {
        this.hariIni = hariIni;
    }

    public Timestamp getWaktuAgenda() { return waktuAgenda; }

    public void setWaktuAgenda(Timestamp waktuAgenda) { this.waktuAgenda = waktuAgenda; }
}


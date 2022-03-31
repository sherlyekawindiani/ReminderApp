package com.sherlyeka.reminderapp.recyclerView;

public class DataAgenda {
     String judulAgenda, hariIni, waktuAgenda;

    public DataAgenda() {
    }

    public DataAgenda(String judulAgenda, String hariIni, String waktuAgenda) {
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

    public String getWaktuAgenda() {
        return waktuAgenda;
    }

    public void setWaktuAgenda(String waktuAgenda) {
        this.waktuAgenda = waktuAgenda;
    }
}


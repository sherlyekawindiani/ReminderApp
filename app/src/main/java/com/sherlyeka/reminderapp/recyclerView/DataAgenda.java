package com.sherlyeka.reminderapp.recyclerView;

public class DataAgenda {
    private  String judulAgenda;
    private  String texthariIni;
    private  String waktuAgenda;

    public DataAgenda(String judulAgenda, String texthariIni, String waktuAgenda) {
        this.judulAgenda = judulAgenda;
        this.texthariIni = texthariIni;
        this.waktuAgenda = waktuAgenda;
    }

    public String getJudulAgenda() {
        return judulAgenda;
    }

    public void setJudulAgenda(String judulAgenda) {
        this.judulAgenda = judulAgenda;
    }

    public String getTexthariIni() {
        return texthariIni;
    }

    public void setTexthariIni(String texthariIni) {
        this.texthariIni = texthariIni;
    }

    public String getWaktuAgenda() {
        return waktuAgenda;
    }

    public void setWaktuAgenda(String waktuAgenda) {
        this.waktuAgenda = waktuAgenda;
    }
}

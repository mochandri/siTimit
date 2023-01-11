package com.example.sitimit;

public class ModelPlafon {
    int id;
    String nama_plafon;
    String harga_plafon;

    public ModelPlafon(){};
    public ModelPlafon(int id, String nama_plafon, String harga_plafon) {
        this.id = id;
        this.nama_plafon = nama_plafon;
        this.harga_plafon = harga_plafon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama_plafon() {
        return nama_plafon;
    }

    public void setNama_plafon(String nama_plafon) {
        this.nama_plafon = nama_plafon;
    }

    public String getHarga_plafon() {
        return harga_plafon;
    }

    public void setHarga_plafon(String harga_plafon) {
        this.harga_plafon = harga_plafon;
    }
}

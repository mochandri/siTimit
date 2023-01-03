package com.example.sitimit;


public class ModelList {

    int id;
    String nama_bata;
    String harga_bata;
    String deskripsi_bata;
    String gambar_bata;
    String gambar_url;

    public ModelList(){};

    public ModelList(int id, String nama_bata, String harga_bata, String deskripsi_bata, String gambar_bata, String gambar_url) {
        this.id = id;
        this.nama_bata = nama_bata;
        this.harga_bata = harga_bata;
        this.deskripsi_bata = deskripsi_bata;
        this.gambar_bata = gambar_bata;
        this.gambar_url = gambar_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama_bata() {
        return nama_bata;
    }

    public void setNama_bata(String nama_bata) {
        this.nama_bata = nama_bata;
    }

    public String getHarga_bata() {
        return harga_bata;
    }

    public void setHarga_bata(String harga_bata) {
        this.harga_bata = harga_bata;
    }

    public String getDeskripsi_bata() {
        return deskripsi_bata;
    }

    public void setDeskripsi_bata(String deskripsi_bata) {
        this.deskripsi_bata = deskripsi_bata;
    }

    public String getGambar_bata() {
        return gambar_bata;
    }

    public void setGambar_bata(String gambar_bata) {
        this.gambar_bata = gambar_bata;
    }
    public String getGambar_url() {
        return gambar_url;
    }

    public void setGambar_url(String gambar_url) {
        this.gambar_url = gambar_url;
    }
}

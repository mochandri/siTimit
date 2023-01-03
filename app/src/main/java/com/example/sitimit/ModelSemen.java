package com.example.sitimit;

public class ModelSemen {
    int id;
    String nama_semen;
    String harga_semen;
    String deskripsi_semen;
    String gambar_semen;
    String gambar_url;

    public ModelSemen(){};

    public ModelSemen(int id, String nama_semen, String harga_semen, String deskripsi_semen, String gambar_semen, String gambar_url) {
        this.id = id;
        this.nama_semen = nama_semen;
        this.harga_semen = harga_semen;
        this.deskripsi_semen = deskripsi_semen;
        this.gambar_semen = gambar_semen;
        this.gambar_url = gambar_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama_semen() {
        return nama_semen;
    }

    public void setNama_semen(String nama_semen) {
        this.nama_semen = nama_semen;
    }

    public String getHarga_semen() {
        return harga_semen;
    }

    public void setHarga_semen(String harga_semen) {
        this.harga_semen = harga_semen;
    }

    public String getDeskripsi_semen() {
        return deskripsi_semen;
    }

    public void setDeskripsi_semen(String deskripsi_semen) {
        this.deskripsi_semen = deskripsi_semen;
    }

    public String getGambar_semen() {
        return gambar_semen;
    }

    public void setGambar_semen(String gambar_semen) {
        this.gambar_semen = gambar_semen;
    }
    public String getGambar_url() {
        return gambar_url;
    }

    public void setGambar_url(String gambar_url) {
        this.gambar_url = gambar_url;
    }



}

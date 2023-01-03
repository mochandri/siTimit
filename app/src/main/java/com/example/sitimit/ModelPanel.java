package com.example.sitimit;

public class ModelPanel {
    int id;
    String nama_panel;
    String harga_panel;
    String deskripsi_panel;
    String gambar_panel;
    String gambar_url;

    public ModelPanel(){};

    public ModelPanel(int id, String nama_panel, String harga_panel, String deskripsi_panel, String gambar_panel, String gambar_url) {
        this.id = id;
        this.nama_panel = nama_panel;
        this.harga_panel = harga_panel;
        this.deskripsi_panel = deskripsi_panel;
        this.gambar_panel = gambar_panel;
        this.gambar_url = gambar_url;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama_panel() {
        return nama_panel;
    }

    public void setNama_panel(String nama_panel) {
        this.nama_panel = nama_panel;
    }

    public String getHarga_panel() {
        return harga_panel;
    }

    public void setHarga_panel(String harga_panel) {
        this.harga_panel = harga_panel;
    }

    public String getDeskripsi_panel() {
        return deskripsi_panel;
    }

    public void setDeskripsi_panel(String deskripsi_panel) {
        this.deskripsi_panel = deskripsi_panel;
    }

    public String getGambar_panel() {
        return gambar_panel;
    }

    public void setGambar_panel(String gambar_panel) {
        this.gambar_panel = gambar_panel;
    }

    public String getGambar_url() {
        return gambar_url;
    }

    public void setGambar_url(String gambar_url) {
        this.gambar_url = gambar_url;
    }


}

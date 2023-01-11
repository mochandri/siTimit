package com.example.sitimit;

public class ModelProduk {
    int id;
    String nama_produk;
    String harga_produk;

    public ModelProduk(){};

    public ModelProduk(int id, String nama_produk, String harga_produk) {
        this.id = id;
        this.nama_produk = nama_produk;
        this.harga_produk = harga_produk;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama_produk() {
        return nama_produk;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }

    public String getHarga_produk() {
        return harga_produk;
    }

    public void setHarga_produk(String harga_produk) {
        this.harga_produk = harga_produk;
    }
}

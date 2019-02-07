package com.company;

public class Pegawai {
    String nama;
    int umur;

    public Pegawai(String nama, int umur) {
        this.nama = nama;
        this.umur = umur;
    }

    public String getNama() {

        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    @Override
    public String toString() {
        return "Nama = " + nama + "\n" +
                "Umur = " + umur + "\n\n====== Klien =====\n";
    }
}

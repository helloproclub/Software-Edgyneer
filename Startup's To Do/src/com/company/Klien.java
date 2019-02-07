package com.company;

public class Klien {
    String namaKlien, perusahaan;

    public String getNamaKlien() {
        return namaKlien;
    }

    public Klien(String namaKlien, String perusahaan) {
        this.namaKlien = namaKlien;
        this.perusahaan = perusahaan;
    }

    public void setNamaKlien(String namaKlien) {
        this.namaKlien = namaKlien;
    }

    public String getPerusahaan() {
        return perusahaan;
    }

    public void setPerusahaan(String perusahaan) {
        this.perusahaan = perusahaan;
    }

    @Override
    public String toString() {
        return "Nama = " + namaKlien + "\n" +
                "Perusahaan = " + perusahaan + "\n";
    }
}

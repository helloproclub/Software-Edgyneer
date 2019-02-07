package com.company;

public class Proyek {
    String namaProyek;
    int bayaran;

    public Proyek(String namaProyek, int bayaran) {
        this.namaProyek = namaProyek;
        this.bayaran = bayaran;
    }

    public String getNamaProyek() {

        return namaProyek;
    }

    public void setNamaProyek(String namaProyek) {
        this.namaProyek = namaProyek;
    }

    public int getBayaran() {
        return bayaran;
    }

    public void setBayaran(int bayaran) {
        this.bayaran = bayaran;
    }

    @Override
    public String toString() {
        return "Nama = " + namaProyek + "\n" +
                "Bayaran = " + bayaran + "\n\n===== Pegawai =====";
    }
}

package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Pair> array = new ArrayList<Pair>();
    static int bayar = 0;

    public static void main(String[] args) {
        int pilih;
        do {
            System.out.println("===== Startup's To Do =====");
            System.out.println("Menu\n1. Masukkan Project Baru\n2. Hapus Project\n3. Tampilkan Daftar Project\n4. Jumlah bayaran\n5. Exit");
            System.out.print("Masukkan pilihan : ");
            pilih = input.nextInt();
            switch (pilih) {
                case 1:
                    System.out.print("Masukkan nama pegawai : ");
                    String nama = input.next();
                    System.out.print("Masukkan umur : ");
                    int umur = input.nextInt();
                    System.out.print("Masukkan nama klien : ");
                    String namaKlien = input.next();
                    System.out.print("Masukkan nama perusahaan : ");
                    String namaPerusahaan = input.next();
                    System.out.print("Masukkan nama proyek : ");
                    String namaProyek = input.next();
                    System.out.print("Masukkan jumlah bayaran : ");
                    int bayaran = input.nextInt();

                    Pegawai pegawai = new Pegawai(nama, umur);
                    Klien klien = new Klien(namaKlien, namaPerusahaan);
                    Proyek proyek = new Proyek(namaProyek, bayaran);
                    Pair pair = new Pair(pegawai, klien);
                    Pair pair2 = new Pair(pair, proyek);
                    array.add(pair2);
                    bayar = bayar + bayaran;
                    break;
                case 2:
                    Proyek prk = (Proyek) array.get(array.size() - 1).getKanan();
                    bayar -= prk.bayaran;
                    array.remove(array.size() - 1);
                    System.out.println("Data berhasil di hapus !");
                    break;
                case 3:
                    for (int i = 0; i < array.size(); i++) {
                        System.out.println("===== Proyek =====");
                        System.out.println(array.get(i).getKanan().toString());
                        System.out.println(array.get(i).getKiri().toString());
                    }
                    break;
                case 4:
                    System.out.println("Perkiraan pemasukannya : " + bayar);
            }
            System.out.println();
        } while (pilih < 5);
    }
}

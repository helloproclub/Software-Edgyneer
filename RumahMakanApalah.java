package com.company;

import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;

import java.util.ArrayList;
import java.util.Scanner;

public class RumahMakanApalah {



    public static void main(String[] args) {
        int pilihan;
        boolean ulang = true;
        ArrayList<Makanan> makananList = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        System.out.println("Pengolahan Data Rumah Makan Apalah");

        while(ulang){
            System.out.println("1.Tambah Menu");
            System.out.println("2.Tampilkan Menu");
            System.out.println("3.Hapus Menu");
            System.out.println("4.Cari Makanan Berdasarkan Nama");
            System.out.println("5.Tampilkan dari yang termurah");
            System.out.println("6.Keluar");
            System.out.print("pilih menu : ");
            pilihan = input.nextInt();

            switch (pilihan){
                case 1:
                    Makanan makanan = new Makanan();
                    System.out.println("Input Makanan");
                    input.nextLine();
                    System.out.print("Nama Makanan: ");
                    makanan.setNamaMakanan(input.nextLine());
                    System.out.println("Harga Makanan : ");
                    makanan.setHargaMakanan(input.nextInt());
                    System.out.println("Data berhasil ditambahkan");
                    makananList.add(makanan);
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Menu yang tersedia");
                    int count = 0;
                    for (Makanan aMakananList : makananList) {
                        System.out.println("Data ke "+count);
                        System.out.println("Nama Makanan : " + aMakananList.getNamaMakanan());
                        System.out.println("Harga Makanan : " + aMakananList.getHargaMakanan());
                        count++;
                    }
                    System.out.println();
                    break;
                case 3:
                    int index;

                    System.out.print("Index menu yang akan di hapus : ");
                    index = input.nextInt();
                    makananList.remove(index);
                    System.out.println("Data terhapus");
                    System.out.println();
                    break;
                case 4:
                    String cari;
                    input.nextLine();
                    System.out.print("nama makanan : ");
                    cari = input.nextLine();
                    for (Makanan listValue : makananList) {
                        if (cari.equals(listValue.getNamaMakanan())) {
                            System.out.println("Nama Makanan : "+ listValue.getNamaMakanan());
                            System.out.println("Harga : "+listValue.getHargaMakanan());
                            break;
                        }
                    }
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Harga makanan dari yang termurah");
                    for (int i = 0; i < makananList.size(); i++) {
                        for (int j = 1; j < makananList.size(); j++) {
                            if(makananList.get(j-1).getHargaMakanan() > makananList.get(j).getHargaMakanan()){
                                Makanan temp = makananList.get(j-1);
                                makananList.set(j-1,makananList.get(j));
                                makananList.set(j,temp);
                            }
                            System.out.println("Nama Makanan  : "+makananList.get(i).getNamaMakanan());
                            System.out.println("Harga Makanan : "+makananList.get(i).getHargaMakanan());
                        }
                    }
                    break;
                case 6:
                    ulang = false;
                    break;
                default:
                    System.out.println("Menu tidak tersedia");
            }
        }
    }
}

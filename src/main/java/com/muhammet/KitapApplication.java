package com.muhammet;

import com.muhammet.entity.Author;
import com.muhammet.repository.AuthorRepository;

import java.sql.Date;
import java.util.Scanner;

public class KitapApplication {
    public static void main(String[] args) {
        boolean isExit = false;
        do{
            screen();
            switch (secim(5)){
                case 1: yazarEkle(); break;
                case 2: yazarListele(); break;
                case 3: yazarSil(); break;
                case 4: yazarGüncelle(); break;
                case 0:
                    System.out.println("Çıkış Yapıldı.");
                    isExit = true;
                    break;
            }
        }while (!isExit);
    }

    private static int secim(int end){
        do {
            System.out.print("Lütfen seçiniz...: ");
            int secim = new Scanner(System.in).nextInt();
            if(secim<0 || secim>end) System.out.println("Lütfen 0 ile "+ end+ " arasında bir değer giriniz");
            else return secim;
        }while (true);
    }
    private static void screen(){
        System.out.println("""
                *******************************
                *** Kitap Otomasyon Sistemi ***
                *******************************
                1- Yazar Ekle
                2- Yazar Listele
                3- Yazar Sil
                4- Yazar Güncelle
                0- ÇIKIŞ
                """);
    }
    private static void yazarEkle(){

    }
    private static void yazarListele(){

    }
    private static void yazarSil(){

    }
    private static void yazarGüncelle(){

    }
}

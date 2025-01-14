package com.muhammet;

import com.muhammet.entity.Author;
import com.muhammet.entity.Book;
import com.muhammet.entity.Customer;
import com.muhammet.repository.AuthorRepository;
import com.muhammet.repository.BookRepository;

import java.sql.Date;
import java.util.Scanner;

import static com.muhammet.utility.DateConverter.*;

public class KitapApplication {
    private static AuthorRepository authorRepository = new AuthorRepository();
    private static BookRepository bookRepository = new BookRepository();
    public static void main(String[] args) {
        boolean isExit = false;
        do{
            screen();
            switch (secim(18)){
                case 1: yazarEkle(); break;
                case 2: yazarListele(); break;
                case 3: yazarSil(); break;
                case 4: yazarGüncelle(); break;
                case 5: kitapEkle();break;
                case 6: kitapListele();break;
                case 7: kitapSil();break;
                case 8: kitapDuzenle(); break;
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
                5- Kitap Ekle
                6- Kitap Listele
                7- Kitap Sil
                8- Kitap Güncelle
                0- ÇIKIŞ
                """);
    }
    private static void yazarEkle(){
        System.out.print("""
                **** Yazar Ekleme Ekranı ****
                """);
        System.out.print("Yazarın adı..............: ");
        String firstName = new Scanner(System.in).nextLine();
        System.out.print("Yazarın soyadı...........: ");
        String lastName = new Scanner(System.in).nextLine();
        System.out.print("Yazarın doğum tarihi.....: ");
        String sBirthDate = new Scanner(System.in).nextLine();
        System.out.print("Yazarın adresi...........: ");
        String city = new Scanner(System.in).nextLine();
        Author author = new Author(firstName,lastName,stringToDate(sBirthDate),city);
        authorRepository.save(author);
        System.out.println("Yazar Başarı ile kayıt edildi.");
    }
    private static void yazarListele(){
        System.out.println("""
                **** Yazar Listesi ****
                """);

        authorRepository.findAll().forEach(System.out::println);
    }
    private static void yazarSil(){
        System.out.println("""
                ***** Yazar Silme ******
                """);
        System.out.print("Silmek istediğiniz yazarın id si...: ");
        int yazar_id = new Scanner(System.in).nextInt();
        authorRepository.delete(yazar_id);
    }
    private static void yazarGüncelle(){
        System.out.println("""
                **** Yazar Güncelle ****
                """);
        System.out.print("Yazar id si..............: ");
        int yazar_id = new Scanner(System.in).nextInt();
        System.out.print("Yazarın adı..............: ");
        String firstName = new Scanner(System.in).nextLine();
        System.out.print("Yazarın soyadı...........: ");
        String lastName = new Scanner(System.in).nextLine();
        System.out.print("Yazarın doğum tarihi.....: ");
        String sBirthDate = new Scanner(System.in).nextLine();
        System.out.print("Yazarın adresi...........: ");
        String city = new Scanner(System.in).nextLine();

        Author author = new Author(yazar_id,firstName,lastName,stringToDate(sBirthDate),city,null,null,null);
        authorRepository.update(author);
        System.out.println("Yazar Başarı ile kayıt edildi.");
    }
    private static void kitapEkle(){
        System.out.println("""
                *** Kitap Ekleme İşlemleri ***
                """);

        String name = getString("Kitap adını giriniz............: ");
        String genre = getString("Kitap türünü giriniz...........: ");
        Integer page = getInteger("Kitap sayfa adedini giriniz....: ");
        String date = getString("Kitap yayın tarihini giriniz...: ");
        Integer authorId = getInteger("Kitap yazar id sini giriniz....: ");
        Book book = new Book(name,genre,page,stringToDate(date),authorId);
        bookRepository.save(book);
    }
    private static void kitapListele(){
        System.out.println("""
                *** Kitap Listesi ***
                """);
      // new BookRepository().findAll().forEach(System.out::println);
       bookRepository.findAll().forEach(System.out::println);
    }
    private static void kitapSil(){
        System.out.println("""
                *** Kitap Silme ***
                """);
        bookRepository.delete(getInteger("Silmek istediğiniz kitap Id sini giriniz...: "));
    }
    private static void kitapDuzenle(){
        System.out.println("""
                *** Kitap Düzenleme İşlemleri ***
                """);
        Integer id = getInteger("Kitap id sini giriniz...: ");
        String name = getString("Kitap adını giriniz............: ");
        String genre = getString("Kitap türünü giriniz...........: ");
        Integer page = getInteger("Kitap sayfa adedini giriniz....: ");
        String date = getString("Kitap yayın tarihini giriniz...: ");
        Integer authorId = getInteger("Kitap yazar id sini giriniz....: ");
        Book book = new Book(id,name,genre,page,stringToDate(date),authorId,null,null,null);
        bookRepository.update(book);
    }

    private static void musteriEkle(){
        Customer customer = Customer.builder().age(5).city("").email("").build();



    }



    private static String getString(String ifade){
        System.out.print(ifade);
        return new Scanner(System.in).nextLine();
    }
    private static Integer getInteger(String ifade){
        System.out.print(ifade);
        return new Scanner(System.in).nextInt();
    }

}

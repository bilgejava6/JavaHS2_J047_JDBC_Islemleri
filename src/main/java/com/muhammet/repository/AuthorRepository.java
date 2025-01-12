package com.muhammet.repository;

import com.muhammet.entity.Author;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

public class AuthorRepository implements Repository<Author>{

    @Override
    public void save(Author author) {
        try{
            /**
             * String ad = "Ali";
             * String soyad = "TAŞ";
             * String bitisikIsim = ad+ " " +soyad;
             */
            Driver.class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5435/KitapYonetimDB";
            String user = "postgres";
            String password = "root";
            Connection conn = DriverManager.getConnection(url,user,password);
            String SQL = "INSERT INTO authors(first_name,last_name,birth_date,city)  " +
                    " VALUES(?,?,?,?)";
            PreparedStatement ps = conn.prepareCall(SQL);
            ps.setString(1, author.getFirstName());
            ps.setString(2, author.getLastName());
            ps.setDate(3, author.getBirthDate());
            ps.setString(4, author.getCity());
            ps.executeUpdate();
            conn.close();
        }catch (Exception exception){
            System.err.println("Yazar Eklemede hata...: "+ exception.getMessage());
        }
    }

    @Override
    public void update(Author author) {
        try{
            Driver.class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5435/KitapYonetimDB";
            String user = "postgres";
            String password = "root";
            Connection conn = DriverManager.getConnection(url,user,password);
            String SQL = "update authors set first_name=?, last_name=?, birth_date=?, city=? where id=?";
            PreparedStatement ps = conn.prepareCall(SQL);
            ps.setString(1, author.getFirstName());
            ps.setString(2, author.getLastName());
            ps.setDate(3, author.getBirthDate());
            ps.setString(4, author.getCity());
            ps.setInt(5, author.getId());
            ps.executeUpdate();
            conn.close();
        }catch (Exception exception){
            System.err.println("Yazar Güncellemede hata...: "+ exception.getMessage());
        }
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Author> findAll() {
        return List.of();
    }
}

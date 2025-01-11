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
            Driver.class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5435/KitapYonetimDB";
            String user = "postgres";
            String password = "root";
            Connection conn = DriverManager.getConnection(url,user,password);
            String SQL = "INSERT INTO authors(first_name,last_name,birth_date,city)  " +
                    " VALUES('','','','')";
            PreparedStatement ps = conn.prepareCall(SQL);
            ps.executeUpdate();
            conn.close();
        }catch (Exception exception){
            System.err.println("Yazar Eklemede hata...: "+ exception.getMessage());
        }
    }

    @Override
    public void update(Author author) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Author> findAll() {
        return List.of();
    }
}

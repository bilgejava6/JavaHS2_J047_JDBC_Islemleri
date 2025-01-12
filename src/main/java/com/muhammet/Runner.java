package com.muhammet;

import java.sql.*;

public class Runner {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        /**
         * 1- Driver, java ile DB arasındaki iletişimi sağlayan
         * tercüman ve sürücü.
         * Java Database Connection -> JDBC
         * postgresql jdbc driver
         * mssql jdbc driver
         */
        Driver.class.forName("org.postgresql.Driver");
        /**
         * bağlatı(connection) için gerekli olan adrese ConnectionURL bunu sağlayan
         * ifadeye de "Sql Connection String"
         */
        String adres = "jdbc:postgresql://localhost:5435/KitapYonetimDB";
        String kullaniciAdi = "postgres";
        String sifre = "root";
        Connection conn = null;
        conn = DriverManager.getConnection(adres,kullaniciAdi,sifre);
        //String SQL_INSERT = "insert into authors(first_name,last_name) values('Temel','TAŞ')";
         String SQL_UPDATE = "update authors set city='İzmir', birth_date='2002-01-09' where id=11";
        //String SQL_DELETE = "delete from authors where id = 5";
        PreparedStatement ps = conn.prepareCall(SQL_UPDATE);
        ps.executeUpdate();
        System.out.println("Ekleme işlemi tamamlandı.");
        conn.close();
    }
}

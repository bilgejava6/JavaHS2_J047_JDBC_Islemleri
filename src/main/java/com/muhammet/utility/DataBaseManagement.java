package com.muhammet.utility;

import java.sql.*;

public class DataBaseManagement {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private final String URL = "jdbc:postgresql://localhost:5435/KitapYonetimDB";
    private final String USER = "postgres";
    private final String PASSWORD = "root";

    private boolean openConnection() {
        try{
            Driver.class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
            return true;
        }catch (Exception ex){
            System.out.println("Bağlantı açılırken hata..: "+ ex.getMessage());
            return false;
        }
    }
    private void closeConnection() {
        try{
            if(!connection.isClosed()) // eğer bağlantı kapalı değil ise,
                connection.close();
        }catch (Exception exception){
            System.out.println("Bağlantı kapatılırken hata....: "+ exception.getMessage());
        }
    }

    /**
     * SQL emirlerinin çalıştırılması.
     * 4 temel işlem bulunur, CRUD
     * ancak bunların 3 ü aynı şekilde yürütülür (CREATE,UPDATE,DELETE)
     * 1 tanesi farklı çalışır. (READ- SELECT)
     */
    public boolean executeQuery(String query) {
        try{
            if(openConnection()){
                preparedStatement = connection.prepareCall(query);
                preparedStatement.executeUpdate();
                closeConnection();
                return true;
            }
        }catch (Exception exception){
            System.out.println("execute işleminde hata...: "+ exception.getMessage());
        }
        return false;
    }

    public ResultSet getResultSet(String query) {
        try{
            if(openConnection()){
                preparedStatement = connection.prepareCall(query);
                resultSet = preparedStatement.executeQuery(); // select sorgusundan dönen tabloyu getirir.
                closeConnection();
                return resultSet;
            }
        }catch (Exception exception){
            System.out.println("sorgulama hatası...: "+exception.getMessage());
        }
        return null;
    }

}

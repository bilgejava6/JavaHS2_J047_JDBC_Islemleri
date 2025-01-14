package com.muhammet.repository;

import com.muhammet.entity.Book;
import com.muhammet.utility.DataBaseManagement;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookRepository implements Repository<Book>{
    private final DataBaseManagement dataBaseManagement;
    private String SQL;
    public BookRepository(){
        dataBaseManagement = new DataBaseManagement();
    }

    public void save(Book book) {
        SQL = "insert into books(name, genre,page,publish_date,author_id) " +
                "values('"+book.getName()+"','"+book.getGenre()+"',"
                +book.getPage()+",'"+book.getPublish_date()+"',"+book.getAuthor_id()+")";
        dataBaseManagement.executeQuery(SQL);
    }

    public void update(Book book) {
        SQL = "update books set " +
                "name='"+book.getName()+"', " +
                "genre='"+book.getGenre()+"', " +
                "page="+book.getPage()+", " +
                "publish_date='"+book.getPublish_date()+"', " +
                "author_id=" + book.getAuthor_id() +
                " where id="+ book.getId();
        dataBaseManagement.executeQuery(SQL);
    }

    public void delete(Integer id) {
        SQL = "delete from books where id=" + id;
        dataBaseManagement.executeQuery(SQL);
    }

    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        try{
            SQL = "select * from books";
            ResultSet rs = dataBaseManagement.getResultSet(SQL);
            while (rs.next()){
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String genre = rs.getString("genre");
                Integer page = rs.getInt("page");
                Date publish_date = rs.getDate("publish_date");
                Integer author_id = rs.getInt("author_id");
                Long createAt = rs.getLong("create_at");
                Long updateAt = rs.getLong("update_at");
                Integer state = rs.getInt("state");
                Book book = new Book(id,name,genre,page,publish_date,author_id,createAt,updateAt,state);
                books.add(book);
            }
        }catch (Exception exception){
            System.out.println("Kitap Listesi çekilirken hata...: "+ exception.getMessage());
        }
        return books;
    }
}

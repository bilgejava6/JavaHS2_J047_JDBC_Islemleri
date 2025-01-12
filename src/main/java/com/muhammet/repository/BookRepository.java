package com.muhammet.repository;

import com.muhammet.entity.Book;
import com.muhammet.utility.DataBaseManagement;

import java.util.List;

public class BookRepository implements Repository<Book>{
    private final DataBaseManagement dataBaseManagement;
    private String SQL;
    public BookRepository(){
        dataBaseManagement = new DataBaseManagement();
    }

    public void save(Book book) {

        SQL = "insert into books(name, genre,page,publish_date,author_id) values('"+book.getName()+"','',,'',"+book.getAuthor_id()+")";
        dataBaseManagement.executeQuery(SQL);
    }

    public void update(Book book) {

    }

    public void delete(Integer id) {

    }

    public List<Book> findAll() {
        return List.of();
    }
}

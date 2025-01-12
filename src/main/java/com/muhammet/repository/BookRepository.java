package com.muhammet.repository;

import com.muhammet.entity.Book;

import java.util.List;

public class BookRepository implements Repository<Book>{
    @Override
    public void save(Book book) {

    }

    @Override
    public void update(Book book) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Book> findAll() {
        return List.of();
    }
}

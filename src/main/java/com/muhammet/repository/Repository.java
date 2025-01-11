package com.muhammet.repository;

import java.util.List;

public interface Repository<T> {
    void save(T t);
    void update(T t);
    void delete(Integer id);
    List<T> findAll();
}

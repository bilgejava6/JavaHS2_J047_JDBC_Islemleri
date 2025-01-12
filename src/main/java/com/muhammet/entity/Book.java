package com.muhammet.entity;

import java.sql.Date;

public class Book {
    private Integer id;
    private String name;
    private Date publish_date;
    private Integer author_id;

    // get-set
    // constructor, (default, sadece gerekliler, tümü)
    // toString()

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(Date publish_date) {
        this.publish_date = publish_date;
    }

    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }
}

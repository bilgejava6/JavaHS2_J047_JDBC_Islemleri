package com.muhammet.entity;

import java.sql.Date;

public class Book {
    private Integer id;
    private String name;
    private String genre;
    private Integer page;
    private Date publish_date;
    private Integer author_id;
    private Long create_at;
    private Long update_at;
    private Integer state;
    // get-set
    // constructor, (default, sadece gerekliler, tümü)
    // toString()

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Book{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", genre='").append(genre).append('\'');
        sb.append(", page=").append(page);
        sb.append(", publish_date=").append(publish_date);
        sb.append(", author_id=").append(author_id);
        sb.append(", create_at=").append(new Date(create_at));
        sb.append(", update_at=").append(new Date(update_at));
        sb.append(", state=").append(state);
        sb.append('}');
        return sb.toString();
    }

    public Book() {
    }

    public Book(String name, String genre, Integer page, Date publish_date, Integer author_id) {
        this.name = name;
        this.genre = genre;
        this.page = page;
        this.publish_date = publish_date;
        this.author_id = author_id;
    }

    public Book(Integer id, String name, String genre, Integer page, Date publish_date, Integer author_id, Long create_at, Long update_at, Integer state) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.page = page;
        this.publish_date = publish_date;
        this.author_id = author_id;
        this.create_at = create_at;
        this.update_at = update_at;
        this.state = state;
    }

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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
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

    public Long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Long create_at) {
        this.create_at = create_at;
    }

    public Long getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Long update_at) {
        this.update_at = update_at;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}

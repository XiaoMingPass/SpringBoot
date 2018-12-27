package com.xm.demo.book;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String reader;
    private String title;
    private String author;
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReader() {
        return reader;
    }

    public void setReader(String reader) {
        this.reader = reader;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public book(String reader, String title, String author, String description) {
        this.reader = reader;
        this.title = title;
        this.author = author;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof book)) return false;
        book book = (book) o;
        return getId() == book.getId() &&
                Objects.equals(getReader(), book.getReader()) &&
                Objects.equals(getTitle(), book.getTitle()) &&
                Objects.equals(getAuthor(), book.getAuthor()) &&
                Objects.equals(getDescription(), book.getDescription());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getReader(), getTitle(), getAuthor(), getDescription());
    }
}

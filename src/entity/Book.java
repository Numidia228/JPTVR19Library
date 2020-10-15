package entity;

import java.io.Serializable;

public class Book implements Serializable{
    private String name;
    private String author;
    private Integer publishedYear;

    public Book() {
    }

    public Book(String name, String author, Integer publishedYear) {
        this.name = name;
        this.author = author;
        this.publishedYear = publishedYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(Integer publishedYear) {
        this.publishedYear = publishedYear;
    }

    @Override
    public String toString() {
        return "Название = " + name
                + ", Автор = " + author
                + ", Год публикации = " + publishedYear;
    }
}
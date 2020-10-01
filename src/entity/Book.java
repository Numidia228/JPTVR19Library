package entity;

public class Book {
    private String name;
    private String author;
    private Integer publishedYear;
    private String ISBN;


    public Book(String name, String author, Integer publishedYear, String isbn) {
        this.name = name;
        this.author = author;
        this.publishedYear = publishedYear;
        this.ISBN = isbn;
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

    public String toString() {
        return "Название книги = " + name
                + ", Автор = " + author
                + ", Год публикации = " + publishedYear;
    }
}


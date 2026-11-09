package DAL.models;

import java.util.Scanner;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private int year;
    private boolean available;

    public Book(String t, String a, String i, int y) {
        this.title = t;
        this.author = a;
        this.isbn = i;
        this.year = y;
        available = true;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public int getYear() { return year; }
    public boolean isAvailable() { return available; }

    public void setTitle(String t) {
        title = t;
    }
    public void setAuthor(String a) {
        author = a;
    }
    public void setYear(int y) {
        year = y;
    }
    public void setAvailable(boolean a) {
        available = a;
    }

    @Override
    public String toString() {
        String status;
        if (available) {
            status = "Available";
        }
        else  {
            status = "Not Available";
        }
        return title + " | " + author + " | " + isbn + " | " + year + " | " + status;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author Prateek
 */
public class Book {
    private int bookID;
    private String title;
    private String author;
    private String ISBN_10;
    private String ISBN_13;
    private String genre;
    private String edition;
    private String publisher;
    private String description;

    public Book() {
    }

    public Book( String title, String author, String ISBN_10, String ISBN_13, String genre, String edition, String publisher, String description) {

        this.title = title;
        this.author = author;
        this.ISBN_10 = ISBN_10;
        this.ISBN_13 = ISBN_13;
        this.genre = genre;
        this.edition = edition;
        this.publisher = publisher;
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public int getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getEdition() {
        return edition;
    }

    public String getGenre() {
        return genre;
    }

    public String getISBN_10() {
        return ISBN_10;
    }

    public String getISBN_13() {
        return ISBN_13;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public void setISBN_10(String ISBN_10) {
        this.ISBN_10 = ISBN_10;
    }

    public void setISBN_13(String ISBN_13) {
        this.ISBN_13 = ISBN_13;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
}

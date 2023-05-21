package com.example.mylibrary;

import java.util.ArrayList;

public class Utils {

    private static Utils instance;
    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> currentlyReadingBooks;
    private static ArrayList<Book> wantToReadBooks;
    private static ArrayList<Book> alreadyReadBooks;
    private static ArrayList<Book> favBooks;

    private Utils() {
        if (null == allBooks) {
            allBooks = new ArrayList<>();
            initData();
        }
        if (null == currentlyReadingBooks) {
            currentlyReadingBooks = new ArrayList<>();
        }
        if (null == wantToReadBooks) {
            wantToReadBooks = new ArrayList<>();
        }
        if (null == alreadyReadBooks) {
            alreadyReadBooks = new ArrayList<>();
        }
        if (null == favBooks) {
            favBooks = new ArrayList<>();
        }
    }

    private void initData() {
        //TODO: add initial data

        allBooks.add(new Book(1, "book1", "author1", 1000, "short desc", "", "https://bestlifeonline.com/wp-content/uploads/sites/3/2020/10/The-Hobbit-book-cover.jpg"));
        allBooks.add(new Book(2, "book2", "author2", 1000, "short desc", "", "https://storage.googleapis.com/du-prd/books/images/9780735211292.jpg"));
        allBooks.add(new Book(3, "book3", "author3", 1000, "short desc", "", "https://bestlifeonline.com/wp-content/uploads/sites/3/2020/10/A-Tale-of-Two-Cities-Cover.jpg"));

    }

    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static void setAllBooks(ArrayList<Book> allBooks) {
        Utils.allBooks = allBooks;
    }

    public static ArrayList<Book> getCurrentlyReadingBooks() {
        return currentlyReadingBooks;
    }

    public static void setCurrentlyReadingBooks(ArrayList<Book> currentlyReadingBooks) {
        Utils.currentlyReadingBooks = currentlyReadingBooks;
    }

    public static ArrayList<Book> getWantToReadBooks() {
        return wantToReadBooks;
    }

    public static void setWantToReadBooks(ArrayList<Book> wantToReadBooks) {
        Utils.wantToReadBooks = wantToReadBooks;
    }

    public static ArrayList<Book> getAlreadyReadBooks() {
        return alreadyReadBooks;
    }

    public static void setAlreadyReadBooks(ArrayList<Book> alreadyReadBooks) {
        Utils.alreadyReadBooks = alreadyReadBooks;
    }

    public static ArrayList<Book> getFavBooks() {
        return favBooks;
    }

    public static void setFavBooks(ArrayList<Book> favBooks) {
        Utils.favBooks = favBooks;
    }

    public Book getBookById(int id){
        for (Book b: allBooks){
            if (b.getId() == id){
                return b;
            }
        }
        return null;
    }

    public static synchronized Utils getInstance(){
        if (null != instance){
            return instance;
        } else {
            instance = new Utils();
            return instance;
        }
    }

    public boolean addToAlreadyRead(Book book){
        return alreadyReadBooks.add(book);
    }
}

package ru.netology.domain;

import java.util.Objects;

public class Book extends Product {

    private String author;

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        if (this.getAuthor().equalsIgnoreCase(search)) {
            return true;
        }
        return false;
    }
}

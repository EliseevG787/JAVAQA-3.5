package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    Product book = new Book(1, "Чистый код", 364, "Роберт Мартин");

    @Test
    void shouldMatchesByName() {
        assertTrue(book.matches("Чистый код"));
    }

    @Test
    void shouldMatchesByNotExistName() {
        assertFalse(book.matches("Код"));
    }
}
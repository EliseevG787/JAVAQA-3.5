package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    Product book = new Book(1, "Чистый код", 364, "Роберт Мартин");

        @Test
        void shouldMatchesBookByAuthor() {
            assertTrue(book.matches("Роберт Мартин"));
        }

        @Test
        void shouldMatchesBookByNotExistAuthor() {
            assertFalse(book.matches("Мартин"));
        }
}
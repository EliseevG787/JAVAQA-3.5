package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Product book1 = new Book(1, "Чистый код", 364, "Роберт Мартин");
    Product book2 = new Book(2, "Искусство программирования", 3298, "Дональд Кнут");
    Product smartphone1 = new Smartphone(3, "iPhone 12", 119990, "Apple");
    Product smartphone2 = new Smartphone(4, "Galaxy A51", 22290, "Samsung");

    @BeforeEach
    public void setUp(){
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
    }

    @Test
    void shouldSearchBookByName() {
        Product[] actual = manager.searchBy("Чистый код");
        Product[] expected = new Product[]{book1};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookByAuthor() {
        Product[] actual = manager.searchBy("Дональд Кнут");
        Product[] expected = new Product[]{book2};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNotExistName() {
        Product[] actual = manager.searchBy("Паттерны проектирования");
        Product[] expected = new Product[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneByName() {
        Product[] actual = manager.searchBy("iPhone 12");
        Product[] expected = new Product[]{smartphone1};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneByFabricator() {
        Product[] actual = manager.searchBy("Samsung");
        Product[] expected = new Product[]{smartphone2};

        assertArrayEquals(expected, actual);
    }
}
package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Product book1 = new Book(1, "Чистый код", 364, "Роберт Мартин");
    Product book2 = new Book(2, "Искусство программирования", 3298, "Дональд Кнут");
    Product book3 = new Book(3, "Сюрреальные числа", 3298, "Дональд Кнут");
    Product smartphone1 = new Smartphone(4, "iPhone 12", 119990, "Apple");
    Product smartphone2 = new Smartphone(5, "Galaxy A51", 22290, "Samsung");
    Product smartphone3 = new Smartphone(6, "Galaxy M31", 16490, "Samsung");

    @Test
    void shouldSearchWhenTheSetIsEmpty() {
        Product[] actual = manager.searchBy("Чистый код");
        Product[] expected = new Product[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookByName() {
        manager.add(book1);

        Product[] actual = manager.searchBy("Чистый код");
        Product[] expected = new Product[]{book1};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBookByAuthor() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = manager.searchBy("Дональд Кнут");
        Product[] expected = new Product[]{book2, book3};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNotExistName() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = manager.searchBy("Паттерны проектирования");
        Product[] expected = new Product[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneByName() {
        manager.add(smartphone1);

        Product[] actual = manager.searchBy("iPhone 12");
        Product[] expected = new Product[]{smartphone1};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSmartphoneByFabricator() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);

        Product[] actual = manager.searchBy("Samsung");
        Product[] expected = new Product[]{smartphone2, smartphone3};

        assertArrayEquals(expected, actual);
    }
}
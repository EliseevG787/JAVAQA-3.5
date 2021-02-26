package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    Product smartphone = new Smartphone(3, "iPhone 12", 119990, "Apple");

    @Test
    void shouldMatchesSmartphoneByFabricator() {
        assertTrue(smartphone.matches("Apple"));
    }

    @Test
    void shouldMatchesSmartphoneByNotExistFabricator() {
        assertFalse(smartphone.matches("Nokia"));
    }
}
package ru.netology.domain;

public class Smartphone extends Product {

    private String fabricator;

    public Smartphone(int id, String name, int price, String fabricator) {
        super(id, name, price);
        this.fabricator = fabricator;
    }

    public String getFabricator() {
        return fabricator;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        if (this.getFabricator().equalsIgnoreCase(search)) {
            return true;
        }
        return false;
    }
}

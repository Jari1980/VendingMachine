package org.example.model;

public class Pepsi extends Product {

    private double size;

    public Pepsi(int id, double price, String productName, double size){
        super(id, price, productName);
        this.size = size;
    }

    public double getSize() {
        return size;
    }

    @Override
    public String examine() {
        return "Id: " + getId() + ", name: " + getProductName() + ", price:" + getPrice() + ", size: " + getSize();
    }

    @Override
    public String use() {
        return "Enjoy your drink!";
    }
}
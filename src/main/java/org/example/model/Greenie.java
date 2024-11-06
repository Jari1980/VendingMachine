package org.example.model;

public class Greenie extends Product {
    private double weight;

    public Greenie(int id, double price, String productName, double weight){
        super(id, price, productName);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String examine() {
        return "Id: " + getId() + ", name:" + getProductName() + ", price:" + getPrice() + ", weight:" + getWeight();
    }

    @Override
    public String use() {
        return "Enjoy your " + getWeight() + " gram Broccoli!";
    }
}

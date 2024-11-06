package org.example.model;

public class Snus extends Product {
    private String flavor;

    public Snus(int id, double price, String productName, String flavor){
        super(id, price, productName);
        this.flavor = flavor;
    }

    public String getFlavor() {
        return flavor;
    }

    @Override
    public String examine() {
        return "Id: " + getId() + ", name: " + getProductName() + ", price: " + getPrice() + ", flavor: " + getFlavor();
    }

    @Override
    public String use() {
        return "Enjoy your " + getFlavor() + " snus!";
    }
}

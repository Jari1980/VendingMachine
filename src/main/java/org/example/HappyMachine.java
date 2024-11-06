package org.example;

import org.example.model.*;

public class HappyMachine implements VendingMachine {

    private Product[] products;
    private int depositPool = 0;

    public HappyMachine(){
        products = new Product[3];
        products[0] = new Broccoli(1, 2.0, "Green Broccoli", 0.5);
        products[1] = new Snus(2, 49.0, "Kronan", "Bitter Orange");
        products[2] = new Pepsi(3, 20, "Pepsi Max", 50);
    }

    @Override
    public void addCurrency(Currency amount) {
        depositPool += amount.getValue();
    }
    @Override
    public int getBalance() {
        return depositPool;
    }
    @Override
    public Product request(int id) {
        switch(id){
            case 1:
                if(depositPool >= products[0].getPrice()){
                    System.out.println(products[0].use());
                    depositPool -= products[0].getPrice();
                    break;
                }
                else{
                    System.out.println("Add more money!");
                }
                break;
            case 2:
                if(depositPool >= products[1].getPrice()){
                    System.out.println(products[1].use());
                    depositPool -= products[1].getPrice();
                    break;
                }
                else{
                    System.out.println("Add more money!");
                }
                break;
            case 3:
                if(depositPool >= products[2].getPrice()){
                    System.out.println(products[2].use());
                    depositPool -= products[2].getPrice();
                    break;
                }
                else{
                    System.out.println("Add more money!");
                }
                break;
            default:
                System.out.println("Product not found");
                break;
        }
        return null;
    }
    @Override
    public int endSession() {
        int remainingBalance = depositPool;
        System.out.println("Returning " + remainingBalance + "kr.");
        depositPool = 0;
        return remainingBalance;
    }

    @Override
    public String getDescription(int id) {
        switch(id){
            case 1:
                products[0].examine();
                break;
            case 2:
                products[1].examine();
                break;
            case 3:
                products[2].examine();
                break;
            default:
                System.out.println("Product not found.");
                break;
        }
        return "";
    }
    @Override
    public String[] getProducts() {
        String[] prods = new String[3];
        prods[0] = products[0].examine();
        prods[1] = products[1].examine();
        prods[2] = products[2].examine();
        return prods;
    }
}

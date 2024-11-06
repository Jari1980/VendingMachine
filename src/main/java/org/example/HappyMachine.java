package org.example;

import org.example.model.*;

public class HappyMachine implements VendingMachine {

    private Product[] products;
    private int depositPool = 0;

    public HappyMachine(){
        products = new Product[6];
        products[0] = new Greenie(1, 2.0, "Green Broccoli", 0.5);
        products[1] = new Greenie(2, 3.0, "Brown Broccoli", 0.2);
        products[2] = new Snus(3, 49.0, "Kronan", "Bitter Orange");
        products[3] = new Snus(4, 60, "General", "Orginal");
        products[4] = new SoftDrink(5, 15.0, "Milk", 100);
        products[5] = new SoftDrink(6, 20, "Pepsi Max", 50);
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
        String[] prods = new String[6];
        prods[0] = products[0].examine();
        prods[1] = products[1].examine();
        prods[2] = products[2].examine();
        prods[3] = products[3].examine();
        prods[4] = products[4].examine();
        prods[5] = products[5].examine();
        return prods;
    }
}

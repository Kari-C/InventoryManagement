package Model;

import java.util.ArrayList;

public class Product {
    int id;
    String name;
    double price;
    int stock;
    int min;
    int max;
    ArrayList<Part> associatedParts;

    public Product(int id, String name, double price, int stock, int min, int max) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
    }

    public void addAssociatedPart(Part part){
        associatedParts.add(part);
    }
    public boolean deleteAssociatedPart(Part selectedAspart){
        for ( Part part : associatedParts){
            if (part == selectedAspart){
                associatedParts.remove(selectedAspart);
            }
            else{
                System.out.println("no match");
            }
        }
        return true; //fixme true/false
    }
    public ArrayList getAllAssociatedParts(){
        return associatedParts;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }
}

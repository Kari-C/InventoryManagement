package Model;

import java.util.ArrayList;

public class Inventory {
    ArrayList<Part> parts = new ArrayList<>();
    ArrayList<Product> products = new ArrayList<>();

    public Inventory(ArrayList<Part> parts, ArrayList<Product> products) {
        parts = parts;
        products = products;
    }

    public void addPart(Part part){
        parts.add(part);
    }
    public void addProduct(Product product){
        products.add(product);
    }
    public Part lookupPart(int partId){
        return lookupPart(partId);
    }
    public Product lookupProduct(int productId){
        return lookupProduct(productId);
    }
    public ArrayList lookupPart(String partName){
        ArrayList <Part> matchedParts = new ArrayList<>(); //create an array to hold the matches
        for (Part part : parts){  //use enhanced for loop to save matches
            if (part.name == partName){
                matchedParts.add(part);
            }
        }
        return matchedParts;
    }
    public ArrayList lookupProduct(String productName){
        ArrayList <Product> matchedProducts = new ArrayList<>();
            for (Product product : products){
                if (product.name == productName){
                    matchedProducts.add(product);
                }
            }
        return matchedProducts;
    }
    public ArrayList getAllParts(){
        return parts;
    }
    public ArrayList getAllProducts(){
        return products;
    }
    public void updateProduct(int index, Product newProduct){
        for (Product product : products ){
            if (product.id == index){
                product = newProduct;
            }else{
                System.out.println("no Match");
            }
        }
    }
    public void updatePart(int index, Part selectedPart){
        for (Part part : parts ){
            if (part.id == index){
                part = selectedPart;
            } else {
                System.out.println("no match");
            }
        }
    }
    public boolean deletePart(Part selectedPart){
        for (Part part : parts){
            if (part == selectedPart){
                parts.remove(part);
            }
        }
        return true; //fixme not sure on this
    }
    public boolean deleteProduct(Product selectedProduct){
        for (Product product : products) {
            if (product == selectedProduct){
                products.remove(selectedProduct);
            }
        }
        return true;  //fixme not sure on this.
    }



    public void setParts(ArrayList<Part> parts) {
        parts = parts;
    }

    public void setProducts(ArrayList<Product> products) {
        products = products;
    }


}
package deu.ces.pattern_test.ShoppingCart;

import java.util.ArrayList;

public class ShoppingData extends Subject {

    private String customerID;
    private String brandName;
    private String productName;
    private String size;
    private String color;
    private int productQuantity;
    private int productPrice;

    public ShoppingData() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(o);
        }
    }

    @Override
    public void notifyObserver() {
        observers.forEach((observer) -> {
            observer.update(brandName, productName, color, size, productQuantity, productPrice);
        });
    }

    public void setShoppingCart(String customerID, String brandName, String productName, String color, String size, int productQuantity, int productPrice) {
        this.customerID = customerID;
        this.brandName = brandName;
        this.productName = productName;
        this.size = size;
        this.color = color;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;

        notifyObserver();
    }

    public void initialSetShoppingCart(String customerID, String brandName, String productName, String color, String size, int productQuantity, int productPrice) {
        this.customerID = customerID;
        this.brandName = brandName;
        this.productName = productName;
        this.size = size;
        this.color = color;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
    }

    // Getters and setters
    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }
}

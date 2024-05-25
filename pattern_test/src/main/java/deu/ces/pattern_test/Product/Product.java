/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.ces.pattern_test.Product;

import java.util.ArrayList;

/**
 *
 * @author 홍서영
 */
public class Product extends Subject {

    private String productID;
    private String name;
    private int price;
    private String description;
    private String imagePath;
    private String brand;

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
            observer.update(name, (int) price);
        });
    }

    @Override
    public void deleteNotifyObserver() {
        observers.forEach((observer) -> {
            observer.delete();
        });
        observers.clear();
    }

    public void updateInfo(String name, int price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
        notifyObserver();
    }

    public void deleteProduct() {
        deleteNotifyObserver();
    }

    public Product(String productID, String name, int price, String description, String imagePath, String brand) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.description = description;
        this.imagePath = imagePath;
        this.brand = brand;
        observers = new ArrayList<>();
    }

    public String getProductID() {
        return productID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

}

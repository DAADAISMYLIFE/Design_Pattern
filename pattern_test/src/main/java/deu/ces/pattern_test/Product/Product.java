/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.ces.pattern_test.Product;

/**
 *
 * @author 홍서영
 */

public class Product {
    private String name;
    private double price;
    private String description;
    private String imagePath;
    private String brand;

    public Product(String name, double price, String description, String imagePath) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.imagePath = imagePath;
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    
    public String getBrand() {
        return brand;
    }

    public String getDescription() {
        return description;
    }

    public String getImagePath() {
        return imagePath;
    }
    
     public void setBrand(String brand) {
        this.brand = brand;
    }
     
}
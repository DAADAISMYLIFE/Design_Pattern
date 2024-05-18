/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.ces.pattern_test.ShoppingCart;

/**
 *
 * @author gka
 */
public class ShoppingHistory {

    private String customerID;
    private String brandName;
    private String productName;
    private String size;
    private String color;
    private int productQuantity;
    private int productPrice;
    private int totalAmount;

    public ShoppingHistory(String customerID, String brandName, String productName, String color, String size, int productQuantity, int productPrice) {
        this.customerID = customerID;
        this.brandName = brandName;
        this.productName = productName;
        this.size = size;
        this.color = color;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
        this.totalAmount = productQuantity * productPrice;
    }

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

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

}

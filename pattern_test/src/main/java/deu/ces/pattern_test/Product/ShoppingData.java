package deu.ces.pattern_test.Product;

import deu.ces.pattern_test.FileManager.RemoteLoader;

public class ShoppingData implements Observer {

    private String customerID;
    private String productID;
    private String brandName;
    private String productName;
    private String size;
    private String color;
    private int productQuantity;
    private int productPrice;
    private Product product;

    public ShoppingData(Product product) {
        this.product = product;
        this.product.registerObserver(this);
    }

    @Override
    public void update(String productName, int productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
        RemoteLoader.getInstance().getRemoteControl().buttonWasPressed(2, "shopping_cart.txt");
    }

    @Override
    public void delete() {
        ShoppingCartSystem.getInstance().removeCart(this);
        RemoteLoader.getInstance().getRemoteControl().buttonWasPressed(2, "shopping_cart.txt");
    }

    public void initialSetShoppingCart(String customerID, String productID, String brandName, String productName, String color, String size, int productQuantity, int productPrice) {
        this.customerID = customerID;
        this.productID = productID;
        this.brandName = brandName;
        this.productName = productName;
        this.size = size;
        this.color = color;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
    }

    public String getProductID() {
        return productID;
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
}

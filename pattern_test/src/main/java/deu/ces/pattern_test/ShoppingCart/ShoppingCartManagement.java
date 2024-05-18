package deu.ces.pattern_test.ShoppingCart;

import javax.swing.JOptionPane;

public class ShoppingCartManagement implements Observer {

    private String brandName;
    private String productName;
    private String productColor;
    private String productSize;
    private int productQuantity;
    private int productPrice;
    private Subject shoppingData;

    public ShoppingCartManagement(ShoppingData shoppingData) {
        this.shoppingData = shoppingData;
        this.shoppingData.registerObserver(this);
    }

    @Override
    public void update(String brandName, String productName, String productColor, String productSize, int productQuantity, int productPrice) {
        this.brandName = brandName;
        this.productName = productName;
        this.productColor = productColor;
        this.productSize = productSize;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;

        addShoppingCart();
    }

    private void addShoppingCart() {
        String message = "장바구니에 " + this.productQuantity + "개의 " + this.productName + " (사이즈: " + this.productSize + ", 색상: " + this.productColor + ") 상품이 추가되었습니다.";
        JOptionPane.showMessageDialog(null, message, "장바구니 추가", JOptionPane.INFORMATION_MESSAGE);
    }

    //기본 프로퍼티
    public String getBrandName() {
        return brandName;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public String getProductColor() {
        return productColor;
    }

    public String getProductSize() {
        return productSize;
    }
}

package deu.ces.pattern_test.ShoppingCart;

import java.awt.Container;
import javax.swing.*;

public class ShoppingCartDisplay implements Observer, DisplayElement {

    private String customerID;
    private String brandName;
    private String productName;
    private int productQuantity;
    private int productPrice;
    private Subject shoppingData;

    public ShoppingCartDisplay(ShoppingData shoppingCart) {
        this.shoppingData = shoppingCart;
        this.shoppingData.registerObserver(this);
    }

    @Override
    public void update(String customerID, String brandName, String productName, int productQuantity, int productPrice) {
        this.customerID = customerID;
        this.brandName = brandName;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
    }

    @Override
    public void display() {

        // swing 사용
        JFrame cartFrame = new JFrame();
        cartFrame.setTitle("장바구니 조회");
        cartFrame.setSize(300, 300);
        Container swingContext = cartFrame.getContentPane();
        swingContext.setLayout(null);

        JLabel customerLabel = new JLabel("구매자 : ");
        JLabel customerField = new JLabel(customerID);
        JLabel brandLabel = new JLabel("브랜드 : ");
        JLabel brandField = new JLabel(brandName);
        JLabel productLabel = new JLabel("제품명 : ");
        JLabel productField = new JLabel(productName);
        JLabel quantityLabel = new JLabel("개 수 : ");
        JLabel quantityField = new JLabel(Integer.toString(productQuantity));
        JLabel priceLabel = new JLabel("가 격 : ");
        JLabel priceField = new JLabel(Integer.toString(productPrice));

        JButton backBtn = new JButton("돌아가기");

        customerLabel.setBounds(40, 30, 100, 30);
        customerField.setBounds(160, 30, 100, 30);
        brandLabel.setBounds(40, 60, 100, 30);
        brandField.setBounds(160, 60, 100, 30);
        productLabel.setBounds(40, 90, 100, 30);
        productField.setBounds(160, 90, 100, 30);
        quantityLabel.setBounds(40, 120, 100, 30);
        quantityField.setBounds(160, 120, 100, 30);
        priceLabel.setBounds(40, 150, 100, 30);
        priceField.setBounds(160, 150, 100, 30);
        backBtn.setBounds(90, 210, 90, 30);

        swingContext.add(customerLabel);
        swingContext.add(customerField);
        swingContext.add(brandLabel);
        swingContext.add(brandField);
        swingContext.add(productLabel);
        swingContext.add(productField);
        swingContext.add(quantityLabel);
        swingContext.add(quantityField);
        swingContext.add(priceLabel);
        swingContext.add(priceField);
        swingContext.add(backBtn);

        cartFrame.setVisible(true);
        cartFrame.setLocationRelativeTo(null);
        cartFrame.setResizable(false);
        cartFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
    
    
    //기본 프로퍼티

    public String getCustomerID() {
        return customerID;
    }

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
    
}

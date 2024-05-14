/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.ces.pattern_test.ShoppingCart;

import deu.ces.pattern_test.FileManager.FileManager;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author gka
 */
public class ShoppingCartSystem {

    private static ShoppingCartSystem instance;

    private ArrayList<ShoppingCartDisplay> currentShoppingCartDisplays = new ArrayList<>();

    // 외부에서 인스턴스를 생성하지 못하도록 private 생성자를 사용
    private ShoppingCartSystem() {
    }

    // 인스턴스에 접근할 수 있는 public static 메서드
    public static ShoppingCartSystem getInstance() {
        if (instance == null) {
            instance = new ShoppingCartSystem();
        }
        return instance;
    }

    public void registerCart(ShoppingCartDisplay shoppingCartshoppingCartDisplay) throws IOException {
        currentShoppingCartDisplays.add(shoppingCartshoppingCartDisplay);
        FileManager.getInstance().writeDBFile("shoppingCart.txt");

    }

    public ArrayList<ShoppingCartDisplay> getShoppingCarts(String customerID) {
        ArrayList<ShoppingCartDisplay> shoppingCart = new ArrayList<>();
        for (ShoppingCartDisplay cart : currentShoppingCartDisplays) {
            if (customerID.equals(cart.getCustomerID())) {
                shoppingCart.add(cart);
            }
        }

        //return shoppingCart;
        return shoppingCart;
    }

    // 이 메서드 삭제 예정
    public void initShoppingCart() {

    }
    
    public void showCarts(ArrayList<ShoppingCartDisplay> shoppingCarts){
        for(ShoppingCartDisplay displayer : shoppingCarts){
            displayer.display();
        }
    }

}

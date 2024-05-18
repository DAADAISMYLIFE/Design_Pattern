/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.ces.pattern_test.ShoppingCart;

import deu.ces.pattern_test.FileManager.RemoteLoader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author gka
 */
public class ShoppingCartSystem {

    private static ShoppingCartSystem instance;

    private ArrayList<ShoppingData> shoppingDatas = new ArrayList<>();
    private ArrayList<ShoppingHistory> shoppingHistory = new ArrayList<>();
    private ShoppingCartManagement shoppingCartManagement;

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

    // 파일 입출력을 이용해 처음 초기화할 때만 사용하는 Register
    public void initialRegisterCart(ShoppingData shoppingData) throws IOException {
        shoppingDatas.add(shoppingData);
        shoppingCartManagement = new ShoppingCartManagement(shoppingData);
        RemoteLoader.getInstance().getRemoteControl().buttonWasPressed(2, "shopping_cart.txt");

    }

    // 사용자가 시스템을 이용할 때 사용하는 Register
    public void registerCart(ShoppingData shoppingData) throws IOException {
        shoppingDatas.add(shoppingData);
        shoppingCartManagement = new ShoppingCartManagement(shoppingData);
        shoppingCartManagement.update(shoppingData.getBrandName(), shoppingData.getProductName(),
                shoppingData.getColor(), shoppingData.getSize(),
                shoppingData.getProductQuantity(), shoppingData.getProductPrice());
        RemoteLoader.getInstance().getRemoteControl().buttonWasPressed(2, "shopping_cart.txt");

    }

    public void registerHistory(ShoppingHistory history) throws IOException {
        shoppingHistory.add(history);
        RemoteLoader.getInstance().getRemoteControl().buttonWasPressed(2, "shopping_history.txt");

    }

    // 모든 구매목록 불러옴
    public ArrayList<ShoppingHistory> getAllHistory() {
        return shoppingHistory;
    }

    // 입력된 ID의 사용자에 대한 모든 장바구니 목록 불러옴
    public ArrayList<ShoppingHistory> getHistory(String customerID) {
        ArrayList<ShoppingHistory> getHistory = new ArrayList<>();
        for (ShoppingHistory shoppingHistory : shoppingHistory) {
            try {
                if (customerID.equals(shoppingHistory.getCustomerID())) {
                    getHistory.add(shoppingHistory);
                }
            } catch (NullPointerException ex) {
                System.out.println("뭔가 이상한데");
            }
        }

        return getHistory;
    }

    // 모든 장바구니 목록 불러옴
    public ArrayList<ShoppingData> getAllShoppingCarts() {
        return shoppingDatas;
    }

    // 입력된 ID의 사용자에 대한 모든 장바구니 목록 불러옴
    public ArrayList<ShoppingData> getShoppingCarts(String customerID) {
        ArrayList<ShoppingData> shoppingCarts = new ArrayList<>();
        for (ShoppingData shoppingData : shoppingDatas) {
            try {
                if (customerID.equals(shoppingData.getCustomerID())) {
                    shoppingCarts.add(shoppingData);
                }
            } catch (NullPointerException ex) {
                System.out.println("뭔가 이상한데");
            }
        }

        return shoppingCarts;
    }

    public void clearCart(String customerID) throws IOException {
        ArrayList<ShoppingData> userShoppingCarts = getShoppingCarts(customerID);
        for (ShoppingData shoppingData : userShoppingCarts) {
            ShoppingHistory newHistory = new ShoppingHistory(shoppingData.getCustomerID(), shoppingData.getBrandName(), shoppingData.getProductName(), shoppingData.getColor(), shoppingData.getSize(), shoppingData.getProductQuantity(), shoppingData.getProductPrice());
            registerHistory(newHistory);
            shoppingDatas.remove(shoppingData);
        }
        RemoteLoader.getInstance().getRemoteControl().buttonWasPressed(2, "shopping_cart.txt");

    }

    // 장바구니 항목을 제거하고 결제 정보를 업데이트하는 메소드
    public void removeCartItem(String customerID, String productName) throws IOException {
        Iterator<ShoppingData> iterator = shoppingDatas.iterator();
        while (iterator.hasNext()) {
            ShoppingData cart = iterator.next();
            if (cart.getCustomerID().equals(customerID) && cart.getProductName().equals(productName)) {
                iterator.remove();
                updatePaymentInfo(customerID);
            }
        }
        RemoteLoader.getInstance().getRemoteControl().buttonWasPressed(2, "shopping_cart.txt");

    }

    // 결제 정보 업데이트 메소드 (실제 구현은 결제 정보를 관리하는 시스템에 따라 다릅니다)
    private void updatePaymentInfo(String customerID) throws IOException {
        // 결제 정보 업데이트 로직을 구현합니다.
        // 예: 해당 고객의 결제 정보를 재계산하여 업데이트하거나 삭제하는 로직을 추가합니다.
        System.out.println("결제 정보가 업데이트되었습니다: " + customerID);
    }
}

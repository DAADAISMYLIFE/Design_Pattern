/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.ces.pattern_test.Product;

import deu.ces.pattern_test.FileManager.RemoteLoader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author gka
 */
public class ProductSystem {

    private static ProductSystem instance;
    private ArrayList<Product> products = new ArrayList<>();

    // 인스턴스에 접근할 수 있는 public static 메서드
    public static ProductSystem getInstance() {
        if (instance == null) {
            instance = new ProductSystem();
        }
        return instance;
    }

    public void registerProduct(Product product) throws IOException {
        products.add(product);
        RemoteLoader.getInstance().getRemoteControl().buttonWasPressed(2, "product.txt");

    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}

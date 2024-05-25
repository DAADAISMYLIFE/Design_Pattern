/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.ces.pattern_test.Forms.Product;

import deu.ces.pattern_test.FileManager.RemoteLoader;
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

    public void removeProduct(Product product) {
        
        //옵저버에게 알림
        product.deleteProduct();
        products.remove(product);
        RemoteLoader.getInstance().getRemoteControl().buttonWasPressed(2, "product.txt");
    }

    public void registerProduct(Product product) {
        products.add(product);
        RemoteLoader.getInstance().getRemoteControl().buttonWasPressed(2, "product.txt");
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public ArrayList<Product> getProductsByBrand(String sellerBrandName) {
        ArrayList<Product> brandProducts = new ArrayList<>();
        for (Product product : products) {
            try {
                if (sellerBrandName.equals(product.getBrand())) {
                    brandProducts.add(product);
                }
            } catch (NullPointerException ex) {
                System.out.println("뭔가 이상한데");
            }
        }

        return brandProducts;
    }

    public Product getProductsByID(String id) {
        for (Product product : products) {
            try {
                if (id.equals(product.getProductID())) {
                    return product;
                }
            } catch (NullPointerException ex) {
                System.out.println("뭔가 이상한데");
            }
        }
        return null;
    }
}

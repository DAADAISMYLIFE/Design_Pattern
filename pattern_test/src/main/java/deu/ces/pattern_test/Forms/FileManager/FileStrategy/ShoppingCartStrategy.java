/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.ces.pattern_test.Forms.FileManager.FileStrategy;

import deu.ces.pattern_test.Product.ProductSystem;
import deu.ces.pattern_test.Product.Product;
import deu.ces.pattern_test.Product.ShoppingCartSystem;
import deu.ces.pattern_test.Product.ShoppingData;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author gka
 */
public class ShoppingCartStrategy implements FileStrategy {

    @Override
    public void read(String fileContent) {
        String[] params = fileContent.split(";");
        Product product = ProductSystem.getInstance().getProductsByID(params[1]);
        if (product != null) {
            ShoppingData newShoppingData = new ShoppingData(product);
            newShoppingData.initialSetShoppingCart(params[0], params[1], params[2], params[3], params[4], params[5], Integer.parseInt(params[6]), Integer.parseInt(params[7]));
            ShoppingCartSystem.getInstance().registerCart(newShoppingData);
        }
    }

    @Override
    public void write(FileWriter writer) throws IOException {
        for (ShoppingData shoppingData : ShoppingCartSystem.getInstance().getAllShoppingCarts()) {
            String context = shoppingData.getCustomerID() + ';' + shoppingData.getProductID() + ';' + shoppingData.getBrandName() + ';' + shoppingData.getProductName() + ';' + shoppingData.getColor() + ';' + shoppingData.getSize() + ';' + shoppingData.getProductQuantity() + ';' + shoppingData.getProductPrice() + '\n';
            writer.write(context);
        }
    }

}

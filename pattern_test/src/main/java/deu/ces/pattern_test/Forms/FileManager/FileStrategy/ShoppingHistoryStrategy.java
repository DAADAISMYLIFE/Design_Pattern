/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.ces.pattern_test.Forms.FileManager.FileStrategy;

import deu.ces.pattern_test.Product.ShoppingCartSystem;
import deu.ces.pattern_test.Product.ShoppingHistory;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gka
 */
public class ShoppingHistoryStrategy implements FileStrategy {

    @Override
    public void read(String fileContent) {
        String[] params = fileContent.split(";");
        ShoppingHistory newShoppingHistory = new ShoppingHistory(params[0], params[1], params[2], params[3], params[4], Integer.parseInt(params[5]), Integer.parseInt(params[6]));
        try {
            ShoppingCartSystem.getInstance().registerHistory(newShoppingHistory);
        } catch (IOException ex) {
            Logger.getLogger(ShoppingHistoryStrategy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void write(FileWriter writer) throws IOException {
        for (ShoppingHistory history : ShoppingCartSystem.getInstance().getAllHistory()) {
            String context = history.getCustomerID() + ';' + history.getBrandName() + ';' + history.getProductName() + ';' + history.getColor() + ';' + history.getSize() + ';' + history.getProductQuantity() + ';' + history.getProductPrice() + ';' + history.getTotalAmount() + '\n';
            writer.write(context);
        }
    }

}

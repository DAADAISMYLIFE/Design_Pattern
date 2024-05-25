/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.ces.pattern_test.FileManager.FileStrategy;

import deu.ces.pattern_test.Product.ProductSystem;
import deu.ces.pattern_test.Product.Product;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author gka
 */
public class ProductStrategy implements FileStrategy{

     @Override
    public void read(String fileContent) {
        String[] params = fileContent.split(";");
        Product newProduct = new Product(params[0], params[1], Integer.parseInt(params[2]), params[3], params[4], params[5]);
        ProductSystem.getInstance().registerProduct(newProduct);
    }

    @Override
    public void write(FileWriter writer) throws IOException {
        for (Product product : ProductSystem.getInstance().getProducts()) {
            String context = product.getProductID() + ';' + product.getName() + ';' + product.getPrice() + ';' + product.getDescription() + ';' + product.getImagePath() + ';' + product.getBrand() + '\n';
            writer.write(context);
        }
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.ces.pattern_test.FileManager;

import deu.ces.pattern_test.Product.Product;
import deu.ces.pattern_test.Product.ProductSystem;
import deu.ces.pattern_test.ShoppingCart.ShoppingCartSystem;
import deu.ces.pattern_test.ShoppingCart.ShoppingData;
import deu.ces.pattern_test.ShoppingCart.ShoppingHistory;
import deu.ces.pattern_test.Users.Customer;
import deu.ces.pattern_test.Users.Seller;
import deu.ces.pattern_test.Users.User;
import deu.ces.pattern_test.Users.UserSystem;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gka
 */
public class FileManager {

    private static String basePath = System.getProperty("user.dir") + File.separator + "data"; //파일 저장 경로

    public FileManager() {
        File baseFolder = new File(basePath);
        if (!baseFolder.exists()) {
            baseFolder.mkdir();
        }
    }

    public static String getBasePath() {
        return basePath;
    }

    public void createDBFile(String fileName) {
        String createFilePath = basePath + File.separator + fileName;
        File createFile = new File(createFilePath);//File 객체 생성

        // 파일이 존재하지 않으면 파일 생성
        if (!createFile.exists()) {
            try {
                createFile.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void createDB(String fileName) {
        try {
            ArrayList<String> fileContents = readDBFile(fileName);
            for (String fileContent : fileContents) {

                //유저 데이터 파일 읽기
                if (fileName.equals("user.txt")) {
                    User newUser;
                    String[] params = fileContent.split(";");
                    if (params[0].equals("customer")) {
                        newUser = new Customer(params[1], params[2], params[3], params[4]);
                    } else {
                        newUser = new Seller(params[1], params[2], params[3], params[4]);
                    }
                    UserSystem.getInstance().registerUser(newUser);
                } //품목 데이터 파일 읽기
                else if (fileName.equals("product.txt")) {
                    Product newProduct;
                    String[] params = fileContent.split(";");
                    newProduct = new Product(params[0], Double.parseDouble(params[1]), params[2], params[3]);
                    ProductSystem.getInstance().registerProduct(newProduct);
                } //장바구니 데이터 파일 읽기
                else if (fileName.equals("shopping_cart.txt")) {
                    ShoppingData newShoppingData = new ShoppingData();
                    String[] params = fileContent.split(";");
                    newShoppingData.initialSetShoppingCart(params[0], params[1], params[2], params[3], params[4], Integer.parseInt(params[5]), Integer.parseInt(params[6]));
                    ShoppingCartSystem.getInstance().initialRegisterCart(newShoppingData);
                } //구매기록 데이터 파일 읽기
                else if (fileName.equals("shopping_history.txt")) {
                    String[] params = fileContent.split(";");
                    ShoppingHistory newShoppingHistory = new ShoppingHistory(params[0], params[1], params[2], params[3], params[4], Integer.parseInt(params[5]), Integer.parseInt(params[6]));
                    ShoppingCartSystem.getInstance().registerHistory(newShoppingHistory);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<String> readDBFile(String fileName) throws IOException {
        String readFilePath = basePath + File.separator + fileName;
        File readFile;
        String fileContent;
        ArrayList<String> fileContents = new ArrayList<>();

        readFile = new File(readFilePath);
        BufferedReader br = new BufferedReader(new FileReader(readFile));
        while ((fileContent = br.readLine()) != null) {
            fileContents.add(fileContent);
            System.out.println(fileContent);
        }

        return fileContents;
    }

    public void writeDBFile(String fileName) throws IOException {
        String writeFilePath = basePath + File.separator + fileName;
        FileWriter write;
        write = new FileWriter(writeFilePath, false);

        //유저 데이터 파일 작성
        if (fileName.equals("user.txt")) {
            String userType;
            String info;
            for (User u : UserSystem.getInstance().getUsers()) {
                if (u instanceof Customer) {
                    userType = "customer";
                    info = ((Customer) u).getAddress();
                } else {
                    userType = "seller";
                    info = ((Seller) u).getBrandName();
                }

                String context = userType + ';' + u.getId() + ';' + u.getPassword() + ';' + u.getName() + ';' + info + '\n';
                write.write(context);
            }
            write.flush();
            write.close();
        }//상품 데이터 파일 작성 
        else if (fileName.equals("product.txt")) {
            for (Product product : ProductSystem.getInstance().getProducts()) {
                String context = product.getName() + ';' + product.getPrice() + ';' + product.getDescription() + ';' + product.getImagePath() + '\n';
                write.write(context);
            }
            write.flush();
            write.close();
        } //장바구니 데이터 파일 작성 
        else if (fileName.equals("shopping_cart.txt")) {
            for (ShoppingData shoppingData : ShoppingCartSystem.getInstance().getAllShoppingCarts()) {
                String context = shoppingData.getCustomerID() + ';' + shoppingData.getBrandName() + ';'
                        + shoppingData.getProductName() + ';' + shoppingData.getColor() + ';'
                        + shoppingData.getSize() + ';' + shoppingData.getProductQuantity() + ';'
                        + shoppingData.getProductPrice() + '\n';
                write.write(context);
            }
            write.flush();
            write.close();
        } //구매기록 데이터 파일 작성 
        else if (fileName.equals("shopping_history.txt")) {
            for (ShoppingHistory history : ShoppingCartSystem.getInstance().getAllHistory()) {
                String context = history.getCustomerID() + ';' + history.getBrandName() + ';'
                        + history.getProductName() + ';' + history.getColor() + ';'
                        + history.getSize() + ';' + history.getProductQuantity() + ';'
                        + history.getProductPrice() + ';' + history.getTotalAmount() + '\n';
                write.write(context);
            }
            write.flush();
            write.close();
        }

    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.ces.pattern_test.Forms.FileManager.FileStrategy;

import deu.ces.pattern_test.Users.Customer;
import deu.ces.pattern_test.Users.Seller;
import deu.ces.pattern_test.Users.User;
import deu.ces.pattern_test.Users.UserSystem;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gka
 */
public class UserStrategy implements FileStrategy {

    @Override
    public void read(String fileContent) {
        String[] params = fileContent.split(";");
        User newUser;
        if (params[0].equals("customer")) {
            newUser = new Customer(params[1], params[2], params[3], params[4]);
        } else {
            newUser = new Seller(params[1], params[2], params[3], params[4]);
        }
        try {
            UserSystem.getInstance().registerUser(newUser);
        } catch (IOException ex) {
            Logger.getLogger(UserStrategy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void write(FileWriter writer) throws IOException {
        for (User u : UserSystem.getInstance().getUsers()) {
            String userType;
            String info;
            if (u instanceof Customer) {
                userType = "customer";
                info = ((Customer) u).getAddress();
            } else {
                userType = "seller";
                info = ((Seller) u).getBrandName();
            }
            String context = userType + ';' + u.getId() + ';' + u.getPassword() + ';' + u.getName() + ';' + info + '\n';
            writer.write(context);
        }
    }

}

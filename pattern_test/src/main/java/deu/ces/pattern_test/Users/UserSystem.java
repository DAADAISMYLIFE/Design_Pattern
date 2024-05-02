/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.ces.pattern_test.Users;

import java.util.ArrayList;

/**
 *
 * @author gka
 */
public class UserSystem {

    public static ArrayList<User> users = new ArrayList<>();
    public static User LogedInUser = null;

    public UserSystem() {
        User initial_customer = new Customer("test", "123", "customer", "address");
        User initial_seller = new Seller("qwer", "123", "seller", "brand");

        users.add(initial_customer);
        users.add(initial_seller);

    }

    public void registerUser(User user) {
        users.add(user);
    }

    public static void login(String id, String password) {
        for (User user : users) {
            if (user.getId().equals(id) && user.getPassword().equals(password)) {
                LogedInUser = user;
            }
        }
    }

}

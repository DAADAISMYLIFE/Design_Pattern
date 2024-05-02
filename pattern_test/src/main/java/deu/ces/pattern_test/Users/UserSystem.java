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
    
    public void registerUser(User user){
        users.add(user);
    }
    
    public static void login(String id, String password){
        for(User user : users){
            if(user.getId().equals(id) && user.getPassword().equals(password)){
                LogedInUser = user;
            }
        }
    }
    
}

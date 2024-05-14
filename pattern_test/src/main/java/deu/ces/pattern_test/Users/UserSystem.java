/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.ces.pattern_test.Users;

import deu.ces.pattern_test.FileManager.FileManager;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author gka
 */
public class UserSystem {

    private static UserSystem instance;

    private ArrayList<User> users = new ArrayList<>();
    private User LogedInUser = null;

    // 외부에서 인스턴스를 생성하지 못하도록 private 생성자를 사용
    private UserSystem() {
    }

    // 인스턴스에 접근할 수 있는 public static 메서드
    public static UserSystem getInstance() {
        if (instance == null) {
            instance = new UserSystem();
        }
        return instance;
    }

    public void registerUser(User user) throws IOException {
        users.add(user);
        FileManager.getInstance().writeDBFile("user.txt");
        
    }

    public void login(String id, String password) {
        for (User user : users) {
            if (user.getId().equals(id) && user.getPassword().equals(password)) {
                LogedInUser = user;
            }
        }
    }
    
    public void logout() {
        LogedInUser = null;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public User getLogedInUser() {
        return LogedInUser;
    }
}

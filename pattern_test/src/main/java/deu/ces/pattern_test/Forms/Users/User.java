/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.ces.pattern_test.Forms.Users;

/**
 *
 * @author gka
 */
public abstract class User {

    String id;
    String password;
    String name;

    //생성자
    public User(String id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
    }

    //기본 프로퍼티
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

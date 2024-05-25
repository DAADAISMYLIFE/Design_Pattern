/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.ces.pattern_test.Forms.Users;

/**
 *
 * @author gka
 */
public class Customer extends User {

    private String address;

    public Customer(String id, String password, String name, String address) {
        super(id, password, name);
        this.address = address;
    }
    
    public String getAddress(){
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.ces.pattern_test.Forms;

import deu.ces.pattern_test.Forms.MainForm.CustomerMainBehavior;
import deu.ces.pattern_test.Forms.RegisterBehaviors.CustomerRegisterBehavior;

/**
 *
 * @author gka
 */
public class CustomerForm extends Form {

    private String address;
    
    public CustomerForm() {
        this.registerBehavior = new CustomerRegisterBehavior();
        this.mainBehavior = new CustomerMainBehavior();
    }

}

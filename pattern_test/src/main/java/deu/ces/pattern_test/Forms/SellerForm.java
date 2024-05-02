/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.ces.pattern_test.Forms;

import deu.ces.pattern_test.Forms.MainForm.SellerMainBehavior;
import deu.ces.pattern_test.Forms.RegisterBehaviors.SellerRegisterBehavior;

/**
 *
 * @author gka
 */
public class SellerForm extends Form {

    private String brandName;

    public SellerForm() {
        this.registerBehavior = new SellerRegisterBehavior();
        this.mainBehavior = new SellerMainBehavior();
    }
}

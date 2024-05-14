/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.ces.pattern_test.Forms;

import deu.ces.pattern_test.Forms.MainForm.MainBehavior;
import deu.ces.pattern_test.Forms.RegisterBehaviors.RegisterBehavior;

/**
 *
 * @author gka
 */

// 전략패턴 사용
public abstract class Form {

    protected RegisterBehavior registerBehavior;
    protected MainBehavior mainBehavior;

    public void performRegister() {
        registerBehavior.showRegisterForm();
    }
    
    public void performMain(){
        mainBehavior.showMainForm();
    }
}

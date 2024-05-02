/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package deu.ces.pattern_test.Forms.RegisterBehaviors;

/**
 *
 * @author gka
 */
public interface RegisterBehavior {
    public void showRegisterForm();
    public boolean checkRegisterContext(String id, String password, String passwordCheck);
}

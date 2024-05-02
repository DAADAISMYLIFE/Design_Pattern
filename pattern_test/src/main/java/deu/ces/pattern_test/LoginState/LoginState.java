/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package deu.ces.pattern_test.LoginState;

/**
 *
 * @author gka
 */
public interface LoginState {
    

    public void login(UserContext context);
    public void logout(UserContext context);

}

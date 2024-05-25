/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.ces.pattern_test.Forms.LoginState;

import deu.ces.pattern_test.Forms.LandingForm;

/**
 *
 * @author gka
 */
public class LoggedOutState implements LoginState {

    @Override
    public void login(UserContext context) {
        LandingForm form = new LandingForm();
        form.showInterface();
        context.setState(new LoggedInState());
    }

    @Override
    public void logout(UserContext context) {
        System.out.println("이미 로그아웃 상태입니다.");
    }

}

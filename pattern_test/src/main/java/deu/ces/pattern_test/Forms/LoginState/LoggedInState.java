/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.ces.pattern_test.Forms.LoginState;

import deu.ces.pattern_test.Forms.CustomerForm;
import deu.ces.pattern_test.Forms.Form;
import deu.ces.pattern_test.Forms.SellerForm;
import deu.ces.pattern_test.Users.Customer;
import deu.ces.pattern_test.Users.UserSystem;

/**
 *
 * @author gka
 */
public class LoggedInState implements LoginState {

    @Override
    public void login(UserContext context) {
        System.out.println("이미 로그인 상태");
        Form form;
        if (UserSystem.getInstance().getLogedInUser() instanceof Customer) {
            form = new CustomerForm();
        } else {
            form = new SellerForm();
        }
        form.performMain();
    }

    @Override
    public void logout(UserContext context) {
        System.out.println("로그아웃 되었습니다.");
        UserSystem.getInstance().logout();
        context.setState(new LoggedOutState());
    }

}

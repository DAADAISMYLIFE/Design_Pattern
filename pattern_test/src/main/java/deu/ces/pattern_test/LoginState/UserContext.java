/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.ces.pattern_test.LoginState;

import deu.ces.pattern_test.Forms.LandingForm;

/**
 *
 * @author gka
 */
public class UserContext {

    private static UserContext instance;
    public LoginState state;

    // 외부에서 인스턴스를 생성하지 못하도록 private 생성자를 사용
    private UserContext() {
        state = new LoggedOutState();
    }

    // 인스턴스에 접근할 수 있는 public static 메서드
    public static UserContext getInstance() {
        if (instance == null) {
            instance = new UserContext();
        }
        return instance;
    }

    public void setState(LoginState state) {
        this.state = state;
    }

    public void login() {
        state.login(this);
    }

    public void logout() {
        state.logout(this);
    }

}

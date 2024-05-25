/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package deu.ces.pattern_test.Forms;

import deu.ces.pattern_test.FileManager.Command.FileRemoteControl;
import deu.ces.pattern_test.FileManager.RemoteLoader;
import deu.ces.pattern_test.LoginState.UserContext;
import java.io.IOException;

/**
 *
 * @author gka
 */
public class TestDrive {

    public static void main(String[] args) throws IOException {

        //커맨드 패턴 적용
        RemoteLoader.getInstance().setRemoteControl();
        FileRemoteControl remote = RemoteLoader.getInstance().getRemoteControl();
        remote.buttonWasPressed(0, "user.txt");
        remote.buttonWasPressed(0, "product.txt");
        remote.buttonWasPressed(0, "shopping_cart.txt");
        remote.buttonWasPressed(0, "shopping_history.txt");

        UserContext user = UserContext.getInstance();
        user.login();
    }
}

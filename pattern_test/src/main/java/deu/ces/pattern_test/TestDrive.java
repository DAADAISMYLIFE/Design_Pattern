/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package deu.ces.pattern_test;

import deu.ces.pattern_test.FileManager.FileManager;
import deu.ces.pattern_test.LoginState.UserContext;
import java.io.IOException;

/**
 *
 * @author gka
 */
public class TestDrive {

    public static void main(String[] args) throws IOException {

        FileManager fm = FileManager.getInstance();
        fm.createDBFile("user.txt");
        fm.createDB("user.txt");

        UserContext user = UserContext.getInstance();
        user.login();
    }
}

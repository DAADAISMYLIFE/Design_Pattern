/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package deu.ces.pattern_test;

import deu.ces.pattern_test.Forms.LandingForm;
import deu.ces.pattern_test.LoginState.UserContext;
import deu.ces.pattern_test.Users.UserSystem;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author gka
 */
public class TestDrive {

    public static void main(String[] args) throws IOException {   
        UserSystem us = new UserSystem();
        UserContext user = UserContext.getInstance();
        user.login();
    }
}

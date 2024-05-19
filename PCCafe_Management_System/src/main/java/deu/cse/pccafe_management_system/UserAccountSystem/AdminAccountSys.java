/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.pccafe_management_system.UserAccountSystem;

import deu.cse.pccafe_management_system.Forms.AdminForm;
import deu.cse.pccafe_management_system.Forms.Form;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author kgb69
 */
public class AdminAccountSys {
    public boolean isRunning = true; // 로그인/회원가입 시스템이 실행중인 상태 | 로그인 성공시 false로 됨
    private static AdminAccountSys instance; //싱글턴

    private AdminAccountSys() {
    }

    public static synchronized AdminAccountSys GetInstance() {
        if (instance == null) {
            instance = new AdminAccountSys();
        }
        return instance;
    }
    
    public void AdminAccountSys() throws IOException {
        System.out.println("관리자 시스템 시작");
        while (isRunning) {

            Form form = new AdminForm();
            form.Perform_Main();
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); //사용자 입력
            String input = reader.readLine();
            int choice = Integer.parseInt(input);

            switch (choice) { // 1 입력시 로그인 기능 실행, 2 입력시 회원가입 기능 실행
                case 1:
                    Login(); 
                    break;
                case 2:
                    Create_Admin(); //회원가입 후 다시 로그인, 회원가입으로 돌아감
                    break;
                case 3:
                    PCCafeMemberManager.GetInstance().Print_all_members();
                    break;
            }
        }
    }
        private void Login() throws IOException {
        BufferedReader reader;

        System.out.print("관리자 아이디: ");
        reader = new BufferedReader(new InputStreamReader(System.in));
        String input_ID = reader.readLine();

        if (AdminMemberManager.GetInstance().Check_Member(input_ID)) {
            isRunning = false;
        }
    }
        private void Create_Admin() throws IOException {
        Form form = new AdminForm();
        form.perform_Creation();
    }
}

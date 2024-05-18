
package deu.cse.pccafe_management_system.UserAccountSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserAccountSys { //로그인/회원가입 시스템

    public boolean isRunning = true;
    public static UserAccountSys instance;
    PCCafeMemberManager member_manager = PCCafeMemberManager.getInstance();

    public UserAccountSys() {
    }

    public static synchronized UserAccountSys getInstance() {
        if (instance == null) {
            instance = new UserAccountSys();
        }
        return instance;
    }

    public void Run_UserAccountSys() throws IOException {
        System.out.println("로그인 / 회원가입 시스템 시작.");
        while (isRunning) {
            System.out.println("1. 로그인");
            System.out.println("2. 회원가입");

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input = reader.readLine();
            int choice = Integer.parseInt(input);

            switch (choice) {
                case 1:
                    Login();
                    break;
                case 2:
                    Create_account();
                    break;
                case 3:
                    Print_all_members();
                    break;
            }
        }
    }

    private void Login() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        System.out.print("아이디: ");
        reader = new BufferedReader(new InputStreamReader(System.in));
        String input_ID = reader.readLine();
        System.out.print("비밀번호: ");
        reader = new BufferedReader(new InputStreamReader(System.in));
        String input_password = reader.readLine();

        for (PCCafeMember member : member_manager.memberList) {
            if (member.user_ID.equals(input_ID) && member.user_password.equals(input_password)) {
                System.out.println("<로그인 성공>");
                isRunning =false;
            }
        }
    }

    private void Create_account() throws IOException {
        System.out.println("===== 회원 정보를 입력 =====");
        System.out.print("사용할 아이디: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input_ID = reader.readLine();
        System.out.print("사용할 비밀번호: ");
        reader = new BufferedReader(new InputStreamReader(System.in));
        String input_password = reader.readLine();
        System.out.print("이름: ");
        reader = new BufferedReader(new InputStreamReader(System.in));
        String input_name = reader.readLine();
        System.out.print("나이: ");
        reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        int input_age = Integer.parseInt(str);
        member_manager.Add_Member(input_ID, input_password, input_name, input_age);

        Print_all_members();
    }

    public void Print_all_members() {
        System.out.println("===== 회원 리스트 =====");
        for (PCCafeMember member : member_manager.memberList) {
            System.out.println("아이디: " + member.user_ID);
            System.out.println("이름: " + member.user_name);
            System.out.println("나이: " + member.user_age);
            System.out.println("======================");
        }
    }
}

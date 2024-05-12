package deu.cse.pccafe_management_system.UserAccountSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 로그인/회원가입을 담당하는 클래스
// 회원가입시 멤버매니저에게 요청하여 회원리스트에 추가
public class UserAccountSys { //로그인/회원가입 시스템

    public boolean isRunning = true; // 로그인/회원가입 시스템이 실행중인 상태 | 로그인 성공시 false로 됨
    public static UserAccountSys instance; //싱글턴

    private UserAccountSys() {
    }

    public static synchronized UserAccountSys GetInstance() {
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

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); //사용자 입력
            String input = reader.readLine();
            int choice = Integer.parseInt(input);

            switch (choice) { // 1 입력시 로그인 기능 실행, 2 입력시 회원가입 기능 실행
                case 1:
                    Login();
                    break;
                case 2:
                    Create_account();
                    break;
                case 3:
                    PCCafeMemberManager.GetInstance().Print_all_members();
                    break;
            }
        }
    }
    //로그인 기능

    private void Login() throws IOException {
        BufferedReader reader;

        System.out.print("아이디: ");
        reader = new BufferedReader(new InputStreamReader(System.in));
        String input_ID = reader.readLine();
        System.out.print("비밀번호: ");
        reader = new BufferedReader(new InputStreamReader(System.in));
        String input_password = reader.readLine();

        if (PCCafeMemberManager.GetInstance().Check_Member(input_ID, input_password)) {
            System.out.println("<로그인 성공>");
            isRunning = false;
        }

    }

    //회원가입 기능
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
        PCCafeMemberManager.GetInstance().Add_Member(input_ID, input_password, input_name, input_age);
    }

}

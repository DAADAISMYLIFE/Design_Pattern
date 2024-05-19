package deu.cse.pccafe_management_system.UserAccountSystem;

import deu.cse.pccafe_management_system.Forms.Form;
import deu.cse.pccafe_management_system.Forms.GuestForm;
import deu.cse.pccafe_management_system.IntegratedSystems.Guest_IntegratedSystems;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 로그인/회원가입을 담당하는 클래스
// 회원가입시 멤버매니저에게 요청하여 회원리스트에 추가
public class UserAccountSys { //로그인/회원가입 시스템

    public boolean isRunning = true; // 로그인/회원가입 시스템이 실행중인 상태 | 로그인 성공시 false로 됨
    public static UserAccountSys instance; //싱글턴
    public PCCafeMember cur_member;
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

            Form form = new GuestForm();
            form.Perform_Main();
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); //사용자 입력
            String input = reader.readLine();
            int choice = Integer.parseInt(input);

            switch (choice) { // 1 입력시 로그인 기능 실행, 2 입력시 회원가입 기능 실행
                case 1:
                    Login(); 
                    break;
                case 2:
                        form.perform_Creation();
                        //Create_account(); //회원가입 후 다시 로그인, 회원가입으로 돌아감
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

        if (PCCafeMemberManager.GetInstance().Check_Member(input_ID, input_password)!=null) {
            System.out.println("<로그인 성공>");
            isRunning = false;
            Guest_IntegratedSystems g = new Guest_IntegratedSystems(PCCafeMemberManager.GetInstance().Check_Member(input_ID, input_password));
            g.Run_IntegratedSys();
        }
        else{
            System.out.println("<로그인 실패>");
        }
    }


}

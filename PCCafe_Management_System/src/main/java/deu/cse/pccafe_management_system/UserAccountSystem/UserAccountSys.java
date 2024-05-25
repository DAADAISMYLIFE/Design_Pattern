package deu.cse.pccafe_management_system.UserAccountSystem;

import deu.cse.pccafe_management_system.Forms.Form;
import deu.cse.pccafe_management_system.Forms.GuestForm;
import deu.cse.pccafe_management_system.IntegratedSystem.IntegratedSys;
import deu.cse.pccafe_management_system.SeatSystem.Main_SeatSystem;
import deu.cse.pccafe_management_system.SeatSystem.Seat;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 로그인/회원가입을 담당하는 클래스
// 회원가입시 멤버매니저에게 요청하여 회원리스트에 추가
public class UserAccountSys { //로그인/회원가입 시스템

    public boolean isRunning = true; // 로그인/회원가입 시스템이 실행중인 상태 | 로그인 성공시 false로 됨
    public static UserAccountSys instance; //싱글턴
    public IntegratedSys start_sys = new IntegratedSys();
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

            Form form = new GuestForm();
            form.perform_Main();

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); //사용자 입력
            String input = reader.readLine();
            int choice = Integer.parseInt(input);

            switch (choice) { // 1 입력시 로그인 기능 실행, 2 입력시 회원가입 기능 실행
                case 1:
                    Login();
                    break;
                case 2:
                    form.perform_Creation();
                    Run_UserAccountSys();
                    break;
                case 3:
                    start_sys.Run_Start();
                    break;
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
            Main_SeatSystem.GetInstance().Print_Seat();
            System.out.print("사용할 좌석을 선택해 주세요: ");
            reader = new BufferedReader(new InputStreamReader(System.in));//입력
            String input = reader.readLine();
            Seat seat =Main_SeatSystem.GetInstance().Set_Ues(input, true);
            if (seat!=null) {
                System.out.println(" 좌석에 로그인 성공");
                isRunning = false;
                IntegratedSys is = new IntegratedSys();
                is.Guest_Menu(seat);
            }
            else{
                System.out.println("사용중인 좌석입니다.");
                Run_UserAccountSys();
            }
        }
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.pccafe_management_system.IntegratedSystem;

import deu.cse.pccafe_management_system.FoodSystem.AdminModeManager;
import deu.cse.pccafe_management_system.FoodSystem.CustomerModeManager;
import deu.cse.pccafe_management_system.FoodSystem.util.FoodMenu;
import deu.cse.pccafe_management_system.SeatSystem.Main_SeatSystem;
import deu.cse.pccafe_management_system.SeatSystem.Seat;
import deu.cse.pccafe_management_system.UserAccountSystem.AdminAccountSys;
import deu.cse.pccafe_management_system.UserAccountSystem.PCCafeMember;
import deu.cse.pccafe_management_system.UserAccountSystem.PCCafeMemberManager;
import deu.cse.pccafe_management_system.UserAccountSystem.UserAccountSys;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author kgb69
 */
public class IntegratedSys {

    public IntegratedSys() {
    }

    public void Guest_Menu(Seat seat) throws IOException {
        System.out.println(" ===============");
        System.out.println("||   1. 음식 주문            ||");
        System.out.println("||   2. 컴퓨터 사용하기   ||");
        System.out.println("||   3. 로그아웃             ||");
        System.out.println("||   4. 뒤로가기             ||");
        System.out.println(" ===============");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));//입력
        String input = reader.readLine();

        switch (input) {
            case "1":
                Scanner scanner = new Scanner(System.in);
                CustomerModeManager customerModeManager = new CustomerModeManager();
                customerModeManager.customerMode(scanner, seat);
                break;
            case "2":
                seat.computerUse();
                Guest_Menu(seat);
                break;
            case "3":
                seat.isUse = false;
                UserAccountSys.GetInstance().Run_UserAccountSys();
                break;
            case "4":
                UserAccountSys.GetInstance().Run_UserAccountSys();
                break;
        }

    }

    public void Admin_Menu() throws IOException {
        System.out.println(" ===============");
        System.out.println("||   1. 음식 시스템          ||");
        System.out.println("||   2. 좌석 시스템          ||");
        System.out.println("||   3. 회원 정보 출력      ||");
        System.out.println("||   4. 뒤로가기              ||");
        System.out.println(" ===============");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));//입력
        String input = reader.readLine();

        switch (input) {
            case "1":
                Scanner scanner = new Scanner(System.in);
                FoodMenu foodMenu = FoodMenu.getInstance(); // FoodMenu 객체 얻기
                AdminModeManager adminModeManager = new AdminModeManager(foodMenu); // AdminModeManager 객체 생성 시 FoodMenu 객체 전달
                adminModeManager.adminMode(scanner);
                break;
            case "2":
                Main_SeatSystem.GetInstance().Run_Admin_SeatSys();
                break;
            case "3":
                PCCafeMemberManager.GetInstance().Print_all_members();
                break;
            case "4":
                Run_Start();
                break;
        }

    }

    public void Run_Start() throws IOException {
        System.out.println("==================");
        System.out.println("1. 관리자");
        System.out.println("2. 손님");
        System.out.println("==================");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        int choice = Integer.parseInt(input);

        if (choice == 1) {
            AdminAccountSys.GetInstance().AdminAccountSys();
        } else if (choice == 2) {
            UserAccountSys.GetInstance().Run_UserAccountSys();
        }
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.pccafe_management_system.SeatSystem;

import deu.cse.pccafe_management_system.IntegratedSystem.IntegratedSys;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author kgb69
 */
public class Main_SeatSystem {

    private static Main_SeatSystem instance;

    Scanner scanner = new Scanner(System.in);
    SeatManager seatManager = new SeatManager();
    Factory seatCreator = new SeatFactory();
    SeatSystem seatSystem = new SeatSystem(scanner, seatManager, seatCreator, seatManager.getSeat_List());
    IntegratedSys is = new IntegratedSys();

    public Main_SeatSystem() {
    }

    public static synchronized Main_SeatSystem GetInstance() {
        if (instance == null) {
            instance = new Main_SeatSystem();
        }
        return instance;
    }

    public void Run_Guest_SeatSys() {

    }

    public void Print_Seat() throws IOException {
        seatSystem.handleCase(5);
    }

    public void Run_Admin_SeatSys() throws IOException {
        System.out.println(" ==================");
        System.out.println("|| 1. 좌석 생성                    ||");
        System.out.println("|| 2. 좌석 삭제                    ||");
        System.out.println("|| 3. 좌석 현황 출력             ||");
        System.out.println("|| 4. 뒤로가기                     ||");
        System.out.println(" ==================");

        System.out.print("원하는 작업을 선택하세요: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1, 2, 3 ->
                seatSystem.handleCase(choice);
            case 4 ->
                is.Admin_Menu();
        }
    }

    public Seat Set_Ues(String seatName, boolean set) {
        Seat temp = seatManager.Set_Seat(seatName, set);
        if (temp != null) {
            return temp;
        } else {
            return null;
        }
    }

}

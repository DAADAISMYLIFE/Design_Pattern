package deu.cse.pccafe_management_system.SeatSystem;

import java.util.Scanner;

public class SeatTestDriver { // 메인 테스트 코드

    public static void main(String[] args) { 
        try (Scanner scanner = new Scanner(System.in)) {
            SeatManager seatManager = new SeatManager();
            Factory seatCreator = new SeatFactory();
            SeatSystem seatSystem = new SeatSystem(scanner, seatManager, seatCreator, seatManager.getSeat_List());
            
            boolean running = true;
            while (running) {
                System.out.println("\n1. 좌석 생성");
                System.out.println("2. 좌석 삭제");
                System.out.println("3. 좌석 현황 출력");
                System.out.println("4. 종료\n");
                System.out.print("원하는 작업을 선택하세요: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    //case 1, 2, 3, 4 -> seatSystem.handleCase(choice);
                    default -> System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
                }
            }
        }
    }
}
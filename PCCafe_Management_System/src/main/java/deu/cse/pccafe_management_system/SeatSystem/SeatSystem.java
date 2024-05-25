package deu.cse.pccafe_management_system.SeatSystem;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class SeatSystem {

    private static SeatSystem instance;
    private Scanner scanner;
    private SeatManager seatManager;
    private Factory seatCreator;
    private List<Seat> seats;

    public SeatSystem(Scanner scanner, SeatManager seatManager, Factory seatCreator, List<Seat> seats) {
        this.scanner = scanner;
        this.seatManager = seatManager;
        this.seatCreator = seatCreator;
        this.seats = seats;
    }

    public void handleCase(int choice) throws IOException {
        switch (choice) {
            case 1 ->
                createSeat();
            case 2 ->
                removeSeat();
            case 3 ->
                showSeatStatus();
            case 4 ->
                exit();
            case 5 ->
                showSeatStatus_forGuest();
            default ->
                System.out.println("잘못된 선택입니다. 다시 선택해주세요");
        }
    }

    private void createSeat() throws IOException {
        System.out.println("\n<좌석 종류>\n");
        System.out.println("1. 기본석 2. 게이밍석 3. 프린터석");
        System.out.print("선택 : ");
        int seatChoice = scanner.nextInt();
        scanner.nextLine(); // 입력 버퍼 정리

        System.out.println("\n<모니터 종류>\n");
        System.out.println("1. 기본 모니터 2. 와이드 모니터");
        System.out.print("선택 : ");
        int monitorChoice = scanner.nextInt();
        scanner.nextLine(); // 입력 버퍼 정리

        switch (seatChoice) {
            case 1 -> {
                switch (monitorChoice) {
                    case 1 -> {
                        Seat seat = seatCreator.orderCreate("기본석");
                        seat.monitorType = ("기본 모니터");
                        seatManager.addSeat(seat);
                        seat.setDrive();
                        System.out.println("---" + seat.getName() + " 생성 완료---");
                        Main_SeatSystem.GetInstance().Run_Admin_SeatSys();
                    }
                    case 2 -> {
                        Seat seat = seatCreator.orderCreate("기본석");
                        seat.monitorType = ("와이드 모니터");
                        seatManager.addSeat(seat);
                        seat.setDrive();
                        System.out.println("---" + seat.getName() + " 생성 완료---");
                        Main_SeatSystem.GetInstance().Run_Admin_SeatSys();
                    }
                    default ->
                        System.out.println("잘못된 선택입니다.");
                }
            }
            case 2 -> {
                switch (monitorChoice) {
                    case 1 -> {
                        Seat seat = seatCreator.orderCreate("게이밍석");
                        seat.monitorType = ("기본 모니터");
                        seatManager.addSeat(seat);
                        seat.setDrive();
                        System.out.println("---" + seat.getName() + " 생성 완료---");
                        Main_SeatSystem.GetInstance().Run_Admin_SeatSys();
                    }
                    case 2 -> {
                        Seat seat = seatCreator.orderCreate("게이밍석");
                        seat.monitorType = ("와이드 모니터");
                        seatManager.addSeat(seat);
                        seat.setDrive();
                        System.out.println("---" + seat.getName() + " 생성 완료---");
                        Main_SeatSystem.GetInstance().Run_Admin_SeatSys();
                    }
                    default ->
                        System.out.println("잘못된 선택입니다.");
                }
            }
            case 3 -> {
                switch (monitorChoice) {
                    case 1 -> {
                        Seat seat = seatCreator.orderCreate("프린터석");
                        seat.monitorType = ("기본 모니터");
                        seatManager.addSeat(seat);
                        seat.seatType = ("프린터석");
                        seat.setDrive();
                        System.out.println("---" + seat.getName() + " 생성 완료---");
                        Main_SeatSystem.GetInstance().Run_Admin_SeatSys();
                    }
                    case 2 -> {
                        Seat seat = seatCreator.orderCreate("프린터석");
                        seat.monitorType = ("와이드 모니터");
                        seatManager.addSeat(seat);
                        seat.seatType = ("프린터석");
                        seat.setDrive();
                        System.out.println("---" + seat.getName() + " 생성 완료---");
                        Main_SeatSystem.GetInstance().Run_Admin_SeatSys();
                    }
                    default ->
                        System.out.println("잘못된 선택입니다. 다시 선택해주세요");
                }
            }
            default ->
                System.out.println("잘못된 선택입니다. 다시 선택해주세요");
        }
    }

    private void removeSeat() throws IOException {
        scanner.nextLine();
        System.out.println("\n삭제할 좌석 이름을 입력하세요: ");
        String seatName = scanner.nextLine();
        boolean isRemoved = seatManager.removeSeat(seatName);
        if (isRemoved) {
            System.out.println("---" + seatName + " 삭제 완료---");
        } else {
            System.out.println("---" + seatName + "을 찾을 수 없습니다---");
        }
        Main_SeatSystem.GetInstance().Run_Admin_SeatSys();
    }

    public void showSeatStatus() throws IOException {
        System.out.println("\n============= 좌석 현황 ==============");
        for (Seat seat : seats) {
            String status = seat.isUse() ? "사용 중" : "사용 가능";
            System.out.println(seat.getName() + " - " + seat.getSeatType() + " - " + seat.getMonitorType() + " - " + status);
        }
        System.out.println("\n=======================");
        Main_SeatSystem.GetInstance().Run_Admin_SeatSys();
    }

    public void showSeatStatus_forGuest() throws IOException {
        System.out.println("\n============= 좌석 현황 ============= ");
        for (Seat seat : seats) {
            String status = seat.isUse() ? "사용 중" : "사용 가능";
            System.out.println(seat.getName() + " - " + seat.getSeatType() + " - " + seat.getMonitorType() + " - " + status);
        }
        System.out.println("--====================================");
    }

    private void exit() {
        System.out.println("\n<종료(뒤로가기로 대체)>");
    }

}

package deu.cse.pccafe_management_system.SeatSystem;

public class BasicSeat extends Seat{ // 기본석 구상 클래스
    
    public BasicSeat(){
        seatType = "기본석";
    }
    
    @Override
    public void setDrive() {
        System.out.println("기본석 설치 완료");
    }
    public void computerUse(){
        System.out.println("<기본석에서 컴퓨터를 사용했습니다.>");
    }
}
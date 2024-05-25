package deu.cse.pccafe_management_system.SeatSystem;

public class GamingSeat extends Seat{ // 게이밍석 구상 클래스
    
    public GamingSeat(){
        seatType = "게이밍석";
    }
    
    @Override
    public void setDrive() {
        System.out.println("게이밍석 설치 완료.");
    }
    
    public void computerUse(){
        System.out.println("<게이밍석에서 게임을 했습니다.>");
    }
}
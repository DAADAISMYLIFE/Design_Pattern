package deu.cse.pccafe_management_system.SeatSystem;

public abstract class Factory { // 좌석 생성 추상 클래스
    public abstract Seat createSeat(String type);
    
    public Seat orderCreate(String type){
        Seat seat = createSeat(type);
        System.out.println("\n---" + seat.getName() + " 생성 시작---"); // 좌석n 생성 시작
        seat.keyboard(); // 키보드 세팅
        seat.speaker(); // 스피커 세팅
        return seat;
    }  
}
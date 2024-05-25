package deu.cse.pccafe_management_system.SeatSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

// 좌석을 관리하는 클래스
public class SeatManager {
    private String name; // 좌석의 이름
    private List<Seat> seats; // 생성된 좌석을 저장할 리스트

    public SeatManager() {
        seats = new ArrayList<>();
        InitSeats();
    }

    // 좌석 리스트 반환
    public List<Seat> getSeat_List() {
        return seats;
    }
    // 좌석 이름 반환
    public String getName() {
        return name;
    }
    // 좌석 추가
    public void addSeat(Seat seat){
        seats.add(seat);
    }
    
    // 사전 생성 메소드
    private void InitSeats(){
    for(int i = 0; i < 5; i++){
        Seat seat = new SeatFactory().createSeat("기본석");
        seat.monitorType = "기본 모니터";
        this.addSeat(seat);
    }
    for(int i = 0; i < 5; i++){
        Seat seat = new SeatFactory().createSeat("게이밍석");
        seat.monitorType = "와이드 모니터";
        this.addSeat(seat);
    }
    Seat seat = new SeatFactory().createSeat("기본석");
        seat.monitorType = "기본 모니터";
        seat.setUse(true);
        this.addSeat(seat);
}
    // 좌석을 삭제하는 메서드 구현
    public boolean removeSeat(String seatName) {
        for (Iterator<Seat> iterator = seats.iterator(); iterator.hasNext(); ) {
            Seat seat = iterator.next();
            if (seat.getName().equals(seatName)) {
                iterator.remove();
                return true; // 삭제 성공
            }
        }
        return false; // 해당 이름을 가진 좌석을 찾지 못함
    }
    public Seat Set_Seat(String seatName, boolean set){
        for (Iterator<Seat> iterator = seats.iterator(); iterator.hasNext(); ) {
            Seat seat = iterator.next();
            if (seat.getName().equals(seatName)) {
                if(seat.isUse !=set){
                seat.setUse(set);
                return seat;
                }
            }
        } // 해당 이름을 가진 좌석을 찾지 못함
        return null;
    }
    
    public boolean Check_Seat(String seatName, boolean set){
        for (Iterator<Seat> iterator = seats.iterator(); iterator.hasNext(); ) {
            Seat seat = iterator.next();
            if (seat.getName().equals(seatName)) {
                seat.setUse(set);
                return true;
               // 삭제 성공
            }
        } // 해당 이름을 가진 좌석을 찾지 못함
        return false;
    }
    
}
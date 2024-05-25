package deu.cse.pccafe_management_system.SeatSystem;

public abstract class Seat { // 좌석 추상 클래스, 어댑터가 
    
    protected String name; // 좌석 이름
    public boolean isUse; // 좌석 사용 여부
    private static int seatNumber = 0; // 좌석 이름 만들때 사용할 정적 변수 ex) 좌석 "1, 2, ..." 
    protected String seatType; // 좌석 현황 출력에 사용될 좌석 종류
    protected String monitorType;
    
    public Seat(){
        this.isUse = false; // 좌석 생성 시 처음에는 사용 가능 상태
        seatNumber++;
        this.name = "좌석" + seatNumber; // 좌석 이름 설정
    }
    
    // 좌석현황에서 좌석 유형 출력하기 위한 메서드
    public String getSeatType(){
        return seatType;
    }
    
    // 좌석현황에서 모니터 유형 출력하기 위한 메서드
    public String getMonitorType(){
        return monitorType;
    }

    // 키보드 세팅 출력
    public void keyboard(){
        System.out.println("키보드 세팅 완료.");
    }
    
    // 스피커 세팅 출력
    public void speaker(){
        System.out.println("스피커 세팅 완료.");
    }
    // 장치 확인 출력용
    public void setDrive(){
    }
   
     // 좌석 이름 반환
    public String getName(){
        return name;
    }
    
    // 좌석을 사용 중인지 확인하는 메서드
    public boolean isUse() {
        return isUse;
    }

    // 좌석 사용 여부 설정하는 메서드
    public void setUse(boolean isUse) {
        this.isUse = isUse;
    }
    public void computerUse(){
    }
}
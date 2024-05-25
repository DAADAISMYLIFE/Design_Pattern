package deu.cse.pccafe_management_system.SeatSystem;

public class SeatFactory extends Factory{ // 기본석 생성 클래스
    
    @Override
    public Seat createSeat(String type) {
        switch (type) {
            case "기본석" -> {
                return new BasicSeat();
            }
            case "게이밍석" -> {
                return new GamingSeat();
            }
            case "프린터석" -> {
                Printer printer = new PrinterSeat();
                //Seat PrinterAdapter = new PrinterAdapter(printer);
                return new PrinterAdapter(printer);
            }
            default -> {
                return null;
            }
        }
    }
}
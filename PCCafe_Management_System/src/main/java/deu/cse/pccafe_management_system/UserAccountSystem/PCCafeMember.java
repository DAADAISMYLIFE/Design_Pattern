package deu.cse.pccafe_management_system.UserAccountSystem;

public class PCCafeMember extends Member {

    String user_password; // 회원 패스워드
    int user_age; //회원 나이
    int remaining_time = 0; // 피시방 남은 이용시간
    int totalCost=0;
    boolean is_using_PC = false; // 피시방 이용(접속) 상태

    public PCCafeMember(String user_ID, String user_password, String user_name, int user_age) {
        super(user_name, user_ID);
        this.user_password = user_password;
        this.user_age = user_age;
    }

    public String get_password() {
        return user_password;
    }

    public int get_age() {
        return user_age;
    }

    public int get_Remaining_time() {
        return remaining_time;
    }

    public boolean get_Is_using_PC() {
        return is_using_PC;
    }

}

package deu.cse.pccafe_management_system.UserAccountSystem;
import java.util.ArrayList;

// 회원 정보를 ArrayList 에 담아 관리하는 클래스
// 싱글턴으로 시스템 구현

public class PCCafeMemberManager {

    public ArrayList<PCCafeMember> member_list;
    MemberFactory factory;
    public static PCCafeMemberManager instance;
    
    PCCafeMemberManager() {
        member_list = new ArrayList<>(); //회원 정보를 담는 리스트
        Init_Member(); // 임의의 회원 2개 추가해놓는 메소드
        this.factory =  new MemberFactory(); // 회원팩토리 생성
    }
    
    // 싱글턴 PCCafeMemberManager 인스턴스를 리턴해주는 메소드
    public static synchronized PCCafeMemberManager GetInstance(){ 
        if(instance == null){
            instance = new PCCafeMemberManager();
        }
        return instance;
    }


    // 회원 추가
    public void Add_Member(String user_ID, String user_password, String user_name, int user_age) {
        PCCafeMember new_member = factory.Create_member(user_ID, user_password, user_name, user_age);
        member_list.add(new_member);
        System.out.println("회원 추가 완료.");
    }

    // 회원 삭제
    public void Remove_Member(PCCafeMember member) {
        // 리스트에서 회원 삭제 기능
    }

    public void Init_Member() {
        PCCafeMember member1 = new PCCafeMember("user1", "password1", "John", 25);
        PCCafeMember member2 = new PCCafeMember("user2", "password2", "Alice", 30);
        member_list.add(member1);
        member_list.add(member2);
    }
}

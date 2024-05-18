
package deu.cse.pccafe_management_system.UserAccountSystem;
import java.util.ArrayList;

public class PCCafeMemberManager {

    public ArrayList<PCCafeMember> memberList;
    public static PCCafeMemberManager instance;
    MemberFactory factory;

    PCCafeMemberManager() {
        memberList = new ArrayList<>();
        Init_Member();
        this.factory =  new MemberFactory();
    }

    public static synchronized PCCafeMemberManager getInstance() {
        if (instance == null) {
            instance = new PCCafeMemberManager();
        }
        return instance;
    }

    // 회원 추가
    public void Add_Member(String user_ID, String user_password, String user_name, int user_age) {
        PCCafeMember newMember = factory.Create_member(user_ID, user_password, user_name, user_age);
        memberList.add(newMember);
        System.out.println("회원 추가 완료.");
    }

    // 회원 삭제
    public void Remove_Member(PCCafeMember member) {

    }

    public void Init_Member() {
        PCCafeMember member1 = new PCCafeMember("user1", "password1", "John", 25);
        PCCafeMember member2 = new PCCafeMember("user2", "password2", "Alice", 30);
        memberList.add(member1);
        memberList.add(member2);
    }
}

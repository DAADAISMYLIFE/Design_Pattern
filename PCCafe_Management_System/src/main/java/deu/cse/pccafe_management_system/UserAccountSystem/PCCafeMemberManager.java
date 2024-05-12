package deu.cse.pccafe_management_system.UserAccountSystem;

import java.util.ArrayList;

// 회원 정보를 ArrayList 에 담아 관리하는 클래스
// 싱글턴으로 시스템 구현
public class PCCafeMemberManager {

    public static PCCafeMemberManager instance;
    MemberList member_list;

    PCCafeMemberManager() {
        this.member_list = new MemberList();

    }

    // 싱글턴 PCCafeMemberManager 인스턴스를 리턴해주는 메소드
    public static synchronized PCCafeMemberManager GetInstance() {
        if (instance == null) {
            instance = new PCCafeMemberManager();
        }
        return instance;
    }

    // 회원 추가
    public void Add_Member(String user_ID, String user_password, String user_name, int user_age) {
        PCCafeMember new_member = new PCCafeMember(user_ID, user_password, user_name, user_age);
        member_list.list.add(new_member);
        System.out.println("회원 추가 완료.");
    }

    // 회원 삭제
    public void Remove_Member(PCCafeMember member) {
        // 리스트에서 회원 삭제 기능
    }

    public boolean Check_Member(String input_ID, String input_password){
        Iterator member_Iterator = member_list.CreateIterator();
        while (member_Iterator.hasNext()) {
            PCCafeMember member =member_Iterator.Next();
            if(member.get_ID().equals(input_ID)&& member.get_password().equals(input_password)){
                return true;
            }  
        }
        return false;
    }
    
    public void Print_all_members() {
        Iterator member_Iterator = member_list.CreateIterator();
        System.out.println("===== 회원 리스트 =====");
        Print_Members(member_Iterator);
        System.out.println("======================");

    }

    private void Print_Members(Iterator iterator) {
        while (iterator.hasNext()) {
            PCCafeMember member =iterator.Next();
            System.out.println("----------------------------------------------");
            System.out.println("아이디: "+member.get_ID()+" | 비번: "+member.get_password());
            System.out.println("이름: "+member.user_name+" | 나이: "+member.get_age());
            System.out.println("----------------------------------------------");
        }

    }
}

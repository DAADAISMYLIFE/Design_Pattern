package deu.cse.pccafe_management_system.UserAccountSystem;

import java.util.ArrayList;

public class PCCafeMemberList implements MemberList{

    public ArrayList<Member> list;

    public PCCafeMemberList() {
        list = new ArrayList<>(); //회원 정보를 담는 리스트
        Init_Member(); // 임의의 회원 2개 추가해놓는 메소드
    }

    public Iterator CreateIterator() {
        return new MemberIterator(list);
    }


    public void Init_Member() {
        PCCafeMember member1 = new PCCafeMember("user1", "password1", "John", 25);
        PCCafeMember member2 = new PCCafeMember("123", "123", "Alice", 30);
        list.add(member1);
        list.add(member2);
    }

}

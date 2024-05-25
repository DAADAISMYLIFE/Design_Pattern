/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.pccafe_management_system.UserAccountSystem;

import java.util.ArrayList;

/**
 *
 * @author kgb69
 */
public class AdminMemberList implements MemberList{

    public ArrayList<AdminMember> list;

    public AdminMemberList() {
        list = new ArrayList<>(); //회원 정보를 담는 리스트
        Init_Member(); // 임의의 회원 2개 추가해놓는 메소드
    }


    public void Init_Member() {
        AdminMember member1 = new AdminMember("admin1","admin1");
        AdminMember member2 = new AdminMember("123", "123");
        list.add(member1);
        list.add(member2);
    }

    @Override
    public Iterator CreateIterator() {
        return null;
    }

}

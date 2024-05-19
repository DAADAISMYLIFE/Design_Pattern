/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.pccafe_management_system.UserAccountSystem;

/**
 *
 * @author kgb69
 */
public class AdminMemberManager {

    public static AdminMemberManager instance;
    public AdminMemberList admin_member_list;

    AdminMemberManager() {
        this.admin_member_list = new AdminMemberList();
    }

    // 싱글턴 AdminMemberManager 인스턴스를 리턴해주는 메소드
    public static synchronized AdminMemberManager GetInstance() {
        if (instance == null) {
            instance = new AdminMemberManager();
        }
        return instance;
    }

    public void Add_Member(AdminMember member) {
        admin_member_list.list.add(member);
        System.out.println("관리자 추가 완료.");
    }

    public boolean Check_Member(String input_ID) {
        for (AdminMember admin : admin_member_list.list) {
            if (admin.getMember_ID().equals(input_ID)) {
                System.out.println("관리자 인증 성공.");
                return true;
            }
        }
        return false;
    }

}

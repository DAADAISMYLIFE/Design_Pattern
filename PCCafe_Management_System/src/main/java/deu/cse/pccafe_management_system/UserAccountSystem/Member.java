/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.pccafe_management_system.UserAccountSystem;

/**
 *
 * @author kgb69
 */
public class Member {

    private String member_name;
    private String member_ID;

    public Member(String member_name, String member_ID) {
        this.member_name = member_name;
        this.member_ID = member_ID;
    }

    public String getMember_name() {
        return member_name;
    }

    public String getMember_ID() {
        return member_ID;
    }
}

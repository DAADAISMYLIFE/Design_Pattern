/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.pccafe_management_system.UserAccountSystem.Member_Creation;

import deu.cse.pccafe_management_system.UserAccountSystem.PCCafeMember;
import deu.cse.pccafe_management_system.UserAccountSystem.PCCafeMemberManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author kgb69
 */
public class PCcafeMember_Creation_Behavior implements MemberCreation_Behavior {

    @Override
    public void make_member() throws IOException {
        System.out.println("===== 회원 정보를 입력 =====");
        System.out.print("사용할 아이디: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input_ID = reader.readLine();
        System.out.print("사용할 비밀번호: ");
        reader = new BufferedReader(new InputStreamReader(System.in));
        String input_password = reader.readLine();
        System.out.print("이름: ");
        reader = new BufferedReader(new InputStreamReader(System.in));
        String input_name = reader.readLine();
        System.out.print("나이: ");
        reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        try {
            int input_age = Integer.parseInt(str);
            PCCafeMember new_member = new PCCafeMember(input_ID, input_password, input_name, input_age);
            PCCafeMemberManager.GetInstance().Add_Member(new_member);
        } catch (NumberFormatException ex) {
            System.out.println("숫자만 넣어라");
        }

    }

}

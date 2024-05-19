/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.pccafe_management_system.UserAccountSystem.Member_Creation;

import deu.cse.pccafe_management_system.UserAccountSystem.AdminMember;
import deu.cse.pccafe_management_system.UserAccountSystem.AdminMemberManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author kgb69
 */
public class AdminMember_Creation_Behavior implements MemberCreation_Behavior{

    @Override
    public void make_member() throws IOException {
       System.out.println("===== 관리자 정보를 입력 =====");
        System.out.print("관리자 이름: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input_name = reader.readLine();
        System.out.print("관리자 ID: ");
        reader = new BufferedReader(new InputStreamReader(System.in));
         String input_ID = reader.readLine();
         
        AdminMember new_member = new AdminMember(input_name, input_ID);
        AdminMemberManager.GetInstance().Add_Member(new_member);
    }
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.cse.pccafe_management_system.IntegratedSystems;

import deu.cse.pccafe_management_system.UserAccountSystem.PCCafeMember;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author kgb69
 */
public class Guest_IntegratedSystems {

    PCCafeMember cur_member;
    boolean is_running = true;

    public Guest_IntegratedSystems(PCCafeMember cur_member) {
        this.cur_member = cur_member;
    }

    public void Run_IntegratedSys() throws IOException {
        while (is_running) {
            System.out.println("1. 컴퓨터 사용하기");
            System.out.println("2. 음식 주문");
            System.out.println("3. 뒤로가기");
            // 유저 입력 ->
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String choice = reader.readLine();

            switch (choice) {
                case "1":
                    // 컴퓨터 사용
                    break;
                case "2":
                    // 손님용 음식 시스템 실행
                    break;
                case "3":
                    is_running = false;
                    break;
            }
        }
    }
}

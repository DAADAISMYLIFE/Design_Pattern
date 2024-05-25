
package deu.cse.pccafe_management_system;

import deu.cse.pccafe_management_system.UserAccountSystem.AdminAccountSys;
import deu.cse.pccafe_management_system.UserAccountSystem.UserAccountSys;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class PCCafe_Management_System {

    public static void main(String[] args) throws IOException {
        System.out.println("==================");
        System.out.println("1. 관리자");
        System.out.println("2. 손님");
        System.out.println("==================");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        int choice = Integer.parseInt(input);

        if (choice == 1) {
            AdminAccountSys.GetInstance().AdminAccountSys();
        } else if (choice == 2) {
            UserAccountSys.GetInstance().Run_UserAccountSys();
        }
    }
}


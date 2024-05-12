
package deu.cse.pccafe_management_system.UserAccountSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TestDrive { //손님 시스템
    
 
    public static void main(String[] args) throws IOException {
        
            System.out.println("==================");
            System.out.println("1. 관리자");
            System.out.println("2. 손님");
            System.out.println("==================");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input = reader.readLine();
            int choice = Integer.parseInt(input);
        
            if (choice == 2) {
                UserAccountSys.GetInstance().Run_UserAccountSys();
            }
    }
}

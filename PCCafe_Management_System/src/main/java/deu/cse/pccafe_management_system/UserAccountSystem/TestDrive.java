
package deu.cse.pccafe_management_system.UserAccountSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TestDrive { //손님 시스템
    
    private static UserAccountSys account_sys = UserAccountSys.getInstance();

 
    public static void main(String[] args) throws IOException {
        
            System.out.println("1. 관리자");
            System.out.println("2. 손님");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input = reader.readLine();
            System.out.println(input);
            int choice = Integer.parseInt(input);
        
            if (choice == 2) {
                account_sys.Run_UserAccountSys();
            }
    }
}


package deu.cse.pccafe_management_system.UserAccountSystem;

public class MemberFactory {
    
    public PCCafeMember Create_member(String user_ID, String user_password, String user_name, int user_age){
        PCCafeMember member = null;
        
        member = new PCCafeMember(user_ID, user_password, user_name, user_age);
        return member;
    }
    
}

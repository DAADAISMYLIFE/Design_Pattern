package deu.cse.pccafe_management_system.UserAccountSystem;

import java.util.ArrayList;

public class MemberIterator implements Iterator {

    ArrayList<PCCafeMember> members;
    int position = 0;

    public MemberIterator(ArrayList<PCCafeMember> members) {
        this.members = members;
    }

    public PCCafeMember Next() {
        PCCafeMember member = members.get(position);
        position += 1;
        return member;
    }
    
    public boolean hasNext(){
        if(position>=members.size()||members.get(position)==null){
            return false;
        }
        else{
            return true;
        }
    }
}

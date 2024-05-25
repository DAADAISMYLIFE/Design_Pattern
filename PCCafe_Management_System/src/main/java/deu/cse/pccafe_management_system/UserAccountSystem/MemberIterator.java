package deu.cse.pccafe_management_system.UserAccountSystem;

import java.util.ArrayList;

public class MemberIterator implements Iterator {

    ArrayList<Member> members;
    int position = 0;

    public MemberIterator(ArrayList<Member> members) {
        this.members = members;
    }

    public Member Next() {
        Member member = members.get(position);
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

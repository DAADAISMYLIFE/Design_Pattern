package cse.mavenproject1.Login;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author 박상현
 */

//User를 UserDB객체에 추가하는 역할
public class UserDB implements ObjectDB{
    private ArrayList<User> userDBList;
    private int dbSize;         //DB의 크기
    //생성자
    public UserDB(){
        userDBList = new ArrayList<>();
    }
    //User객체 추가
    public void AddUser(User Users){
        userDBList.add(Users);
    }
    //객체를 찾는 횟수??
    public int GetDBSize(){
        this.dbSize = userDBList.size();
        return this.dbSize;
    }
    //DB에 있는 객체 찾아서 전달
    public User GetUser(int Index){
        User TargetUser = userDBList.get(Index);
        return TargetUser;
    }
    
    //UserDB안에 User객체를 돌아다닐 Iterator 생성
    @Override
    public Iterator CreatIterator() {
        return new UserDBIterator(this);
    }
       
}

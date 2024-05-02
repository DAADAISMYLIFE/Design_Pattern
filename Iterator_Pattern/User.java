package cse.mavenproject1.Login;

/**
 *
 * @author 박상현
 */
public class User {
     private String id;             //아이디
    private String password;//비밀번호
    private String name;       //이름
     private int age;            //나이
    private String gender;    //성별
    private String address;  //주소
   
    private boolean isManager = false; //사용자 구분
    //생성자
    public User(String id, String password, String name, int age, String gender, String address, boolean isManager){
        this.id = id;
        this.password = password;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.isManager = isManager;
    }
    //아이디가 같은 유저를 찾기 위한 객체
    public User(String id){
        this.id = id;
    }
    
    //get함수들
    public String getUserID(){
        return id;
    }
    
    public String getUserPassword(){
        return password;
    }
    
    public String getUserName(){
        return name;
    }
    
    public String getUserGender(){
        return gender;
    }
    
    public String getUserAddress(){
        return address;
    }
    
    public String getUserAge(){
        String strAge = Integer.toString(age);
        return strAge;
    }
    
    public String getUserType(){
        String strType = Boolean.toString(isManager);
        return strType;
    }
    
    //User객체 속성값 수정
    public void  SetName(String newName){
    this.name = newName;
    }
    
    public void SetAge(int newAge){
        this.age = newAge;
    }
    
    public void SetAddress(String newAddress){
     this.address = newAddress;
    }
}

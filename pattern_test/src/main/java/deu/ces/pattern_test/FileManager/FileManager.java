/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.ces.pattern_test.FileManager;

import deu.ces.pattern_test.Users.Customer;
import deu.ces.pattern_test.Users.Seller;
import deu.ces.pattern_test.Users.User;
import deu.ces.pattern_test.Users.UserSystem;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author gka
 */
public class FileManager {

    private static FileManager instance;
    private static String basePath = System.getProperty("user.dir") + "\\data"; //파일 저장 경로

    // 외부에서 인스턴스를 생성하지 못하도록 private 생성자를 사용
    private FileManager() {
    }

    // 인스턴스에 접근할 수 있는 public static 메서드
    public static FileManager getInstance() {
        File baseFolder = new File(basePath);
        if (!baseFolder.exists()) {
            baseFolder.mkdir();
        }
        if (instance == null) {
            instance = new FileManager();
        }
        return instance;
    }

    public void createDBFile(String fileName) throws IOException {
        String createFilePath = basePath + "\\" + fileName;
        File createFile = new File(createFilePath);//File 객체 생성

        // 파일이 존재하지 않으면 파일 생성
        if (!createFile.exists()) {
            createFile.createNewFile();
        }
    }

    public void createDB(String fileName) throws IOException {
        ArrayList<String> fileContents = readDBFile(fileName);
        for (String fileContent : fileContents) {

            if (fileName.equals("user.txt")) {
                User newUser;
                String[] params = fileContent.split(";");
                if (params[0].equals("customer")) {
                    newUser = new Customer(params[1], params[2], params[3], params[4]);
                } else {
                    newUser = new Seller(params[1], params[2], params[3], params[4]);
                }
                System.out.println("생성됨");
                UserSystem.getInstance().registerUser(newUser);
            }
        }
    }

    public ArrayList<String> readDBFile(String fileName) throws IOException {
        String readFilePath = basePath + "\\" + fileName;
        File readFile;
        String fileContent;
        ArrayList<String> fileContents = new ArrayList<>();

        readFile = new File(readFilePath);
        BufferedReader br = new BufferedReader(new FileReader(readFile));
        while ((fileContent = br.readLine()) != null) {
            fileContents.add(fileContent);
            System.out.println(fileContent);
        }

        return fileContents;
    }

    public void writeDBFile(String fileName) throws IOException {
        String writeFilePath = basePath + "\\" + fileName;
        FileWriter write;
        write = new FileWriter(writeFilePath, false);

        if (fileName.equals("user.txt")) {
            String userType;
            String info;
            for (User u : UserSystem.getInstance().getUsers()) {
                if (u instanceof Customer) {
                    userType = "customer";
                    info = ((Customer) u).getAddress();
                } else {
                    userType = "seller";
                    info = ((Seller) u).getBrandName();
                }

                String context = userType + ';' + u.getId() + ';' + u.getPassword() + ';' + u.getName() + ';' + info + '\n';
                write.write(context);
            }
            write.flush();
            write.close();
        }

    }
}

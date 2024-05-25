/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.ces.pattern_test.Forms.FileManager;

import deu.ces.pattern_test.FileManager.StrategyFactory.FileStrategyFactory;
import deu.ces.pattern_test.FileManager.FileStrategy.FileStrategy;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gka
 */
public class FileManager {

    private static String basePath = System.getProperty("user.dir") + File.separator + "data"; //파일 저장 경로

    public FileManager() {
        File baseFolder = new File(basePath);
        if (!baseFolder.exists()) {
            baseFolder.mkdir();
        }
    }

    public static String getBasePath() {
        return basePath;
    }

    public void createDBFile(String fileName) {
        String createFilePath = basePath + File.separator + fileName;
        File createFile = new File(createFilePath);//File 객체 생성
        // 파일이 존재하지 않으면 파일 생성
        if (!createFile.exists()) {
            try {
                createFile.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

        public void createDB(String fileName) {
        try {
            ArrayList<String> fileContents = readDBFile(fileName);
            FileStrategy strategy = FileStrategyFactory.getStrategy(fileName);
            for (String fileContent : fileContents) {
                strategy.read(fileContent);
            }
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<String> readDBFile(String fileName) throws IOException {
        String readFilePath = basePath + File.separator + fileName;
        File readFile = new File(readFilePath);
        BufferedReader br = new BufferedReader(new FileReader(readFile));
        ArrayList<String> fileContents = new ArrayList<>();
        String fileContent;
        while ((fileContent = br.readLine()) != null) {
            fileContents.add(fileContent);
            System.out.println(fileContent);
        }
        return fileContents;
    }

    public void writeDBFile(String fileName) throws IOException {
        String writeFilePath = basePath + File.separator + fileName;
        FileWriter writer = new FileWriter(writeFilePath, false);
        FileStrategy strategy = FileStrategyFactory.getStrategy(fileName);
        strategy.write(writer);
        writer.flush();
        writer.close();
    }
}

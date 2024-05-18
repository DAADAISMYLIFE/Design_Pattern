/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package deu.ces.pattern_test.FileManager;

import deu.ces.pattern_test.FileManager.Command.FileCreateCommand;
import deu.ces.pattern_test.FileManager.Command.FileReadCommand;
import deu.ces.pattern_test.FileManager.Command.FileRemoteControl;
import deu.ces.pattern_test.FileManager.Command.FileWriteCommand;
import deu.ces.pattern_test.Product.Product;
import deu.ces.pattern_test.Product.ProductSystem;
import java.util.ArrayList;

/**
 *
 * @author gka
 */
public class RemoteLoader {

    private static RemoteLoader instance;
    FileRemoteControl fileRemote = new FileRemoteControl();
    FileManager fileManager = new FileManager();
    FileCreateCommand createCommand = new FileCreateCommand(fileManager);
    FileReadCommand readCommand = new FileReadCommand(fileManager);
    FileWriteCommand writeCommand = new FileWriteCommand(fileManager);

    private RemoteLoader() {
    }

    // 인스턴스에 접근할 수 있는 public static 메서드
    public static RemoteLoader getInstance() {
        if (instance == null) {
            instance = new RemoteLoader();
        }
        return instance;
    }

    public void setRemoteControl() {
        fileRemote.setCommand(0, createCommand);
        fileRemote.setCommand(1, readCommand);
        fileRemote.setCommand(2, writeCommand);
    }

    public FileRemoteControl getRemoteControl() {
        return fileRemote;
    }
}

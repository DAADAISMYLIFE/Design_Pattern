/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package deu.ces.pattern_test.FileManager.FileStrategy;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author gka
 */
public interface FileStrategy {

    void read(String fileContent);
    void write(FileWriter writer) throws IOException;
}

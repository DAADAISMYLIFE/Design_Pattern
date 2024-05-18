package deu.ces.pattern_test.FileManager.Command;

import deu.ces.pattern_test.FileManager.FileManager;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileWriteCommand implements FileCommand {

    private FileManager fileManager;

    public FileWriteCommand(FileManager fm) {
        this.fileManager = fm;
    }

    @Override
    public void execute(String fileName) {
        try {
            fileManager.writeDBFile(fileName);
        } catch (IOException ex) {
            Logger.getLogger(FileWriteCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

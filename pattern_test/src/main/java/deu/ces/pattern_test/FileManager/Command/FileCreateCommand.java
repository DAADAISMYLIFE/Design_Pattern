package deu.ces.pattern_test.FileManager.Command;

import deu.ces.pattern_test.FileManager.FileManager;

public class FileCreateCommand implements FileCommand {

    private FileManager fileManager;

    public FileCreateCommand(FileManager fm) {
        this.fileManager = fm;
    }

    @Override
    public void execute(String fileName) {
        fileManager.createDBFile(fileName);
        fileManager.createDB(fileName);
    }

}

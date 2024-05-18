package deu.ces.pattern_test.FileManager.Command;

public class FileRemoteControl {

    private FileCommand[] commands;

    public FileRemoteControl() {
        commands = new FileCommand[3];
    }

    public void setCommand(int slot, FileCommand command) {
        this.commands[slot] = command;
    }

    public void buttonWasPressed(int slot, String fileName) {
        commands[slot].execute(fileName);
    }

}

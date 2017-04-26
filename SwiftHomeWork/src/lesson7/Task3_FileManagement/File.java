package lesson7.Task3_FileManagement;

import java.time.LocalDateTime;

/**
 * Created by aizeeck on 22.04.17.
 */
public class File {
    private String name;
    private String location;
    private LocalDateTime creationDate;
    private boolean isDeleted;

    public File(String name, String location) {
        this.name = name;
        this.location = location;
        this.creationDate = LocalDateTime.now();
        this.isDeleted = false;
    }

    public void move(String newLocation) {
        location = newLocation;
    }

    public File copy(String newLocation) {
        if (this instanceof MediaContentFile) {
            MediaContentFile mediaContentFile = (MediaContentFile) this;
            return new MediaContentFile(mediaContentFile.getName(), newLocation, mediaContentFile.getContent());
        } else if (this instanceof DocumentContentFile) {
            DocumentContentFile documentContentFile = (DocumentContentFile) this;
            return new DocumentContentFile(documentContentFile.getName(), newLocation, documentContentFile.getContent());
        } else if (this instanceof ExecutableFile) {
            ExecutableFile executableFile = (ExecutableFile) this;
            return new ExecutableFile(executableFile.getName(), newLocation, executableFile.getRequiredResources());
        }
        return null;
    }

    public void delete() {
        isDeleted = true;
    }

    public void execute() {
        //NOP
    }

    public void info() {
        System.out.println(this.toString() + "\n");
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return location + "/" + name;
    }



    public boolean isDeleted() {
        return isDeleted;
    }

    @Override
    public String toString() {
        return "Name:" + this.location + "/" + this.name + (isDeleted ? " [DELETED]" : "") +
                "\nCreation date: " + creationDate;
    }
}

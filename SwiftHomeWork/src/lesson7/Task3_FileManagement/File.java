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

    }

    public void copy(String newLocation) {

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

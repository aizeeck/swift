package lesson7.Task3_FileManagement;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Created by aizeeck on 22.04.17.
 */
public class ExecutableFile extends File {
    private ArrayList<File> requiredResources = new ArrayList<>();
    private LocalDateTime lastExecutionDate;

    public ExecutableFile(String name, String location, ArrayList<File> requiredResources) {
        super(name, location);
        this.requiredResources = requiredResources;
    }

    @Override
    public void execute() {
        System.out.println("Executing " + getFullName() + "");

        for (File f : requiredResources) {
            if (f.isDeleted()) {break;}
            f.execute();
        }
        lastExecutionDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        String result = super.toString() +
                (lastExecutionDate == null ? "Last execution date: N/A" : "\nLast execution date: " + lastExecutionDate);

        result += "\nRequired resources:";
        for (File f : requiredResources) {
            result += "\n       " + f.getName();
        }

        return result;
    }
}
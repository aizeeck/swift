package lesson7.Task3_FileManagement;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Created by aizeeck on 22.04.17.
 */
public class ExecutableFile extends File {
    private ArrayList<File> requiredResources = new ArrayList<>();
    private LocalDateTime lastExecutionDate;

    public ExecutableFile(String name, String location, String... requiredResources) {
        super(name, location);
        addRequiredResources(requiredResources);
    }

    public void addRequiredResources(String[] requiredResources) {
        for (String res : requiredResources) {
            this.requiredResources.add(Task3_FileManagement.getFiles().get(res));
        }
    }

    @Override
    public void execute() {
        System.out.println("Executing " + fullName() + "");

        for (File f : requiredResources) {
            if (f.isDeleted()) {break;}

            if (f instanceof ContentFile) {
                System.out.println("♫♫♫" + f.fullName()
                + "\n" + ((MediaContentFile) f).getContent());
            } else if(f instanceof ExecutableFile) {
                f.execute();
            }
        }
        System.out.println();
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
package lesson9.Task1_FileStructure;

import java.util.Scanner;

/**
 * Created by aizeeck on 30.04.17.
 */
public class MainClass {
    private int linesExecuted = 0;
    private FolderObject buttonDemoProject = new FolderObject(null, "ButtonDemoProject", null);

    public static void main(String[] args) {
        MainClass mainClass = new MainClass();
        Scanner scanner = new Scanner(System.in);
        String line = "";

        while (!line.equals("END")) {
            String[] command = line.split(" ");
            mainClass.linesExecuted++;
            switch (command[0]) {
                case "mkdir":
                    mainClass.createFolder(command[1]);
                    break;
                case "touch":
                    mainClass.createFile(command[1]);
                    break;
            }
            line = scanner.nextLine();
        }
    }

    private void createFolder(String path) {
        String[] pathParts = path.split("/");
        FolderObject fd = this.buttonDemoProject;

        for (int i = 1; i < pathParts.length - 1; i++) {
            if (fd != null) {
                fd = checkExists(fd, pathParts[i], pathParts[i - 1]);
            } else {
                break;
            }
        }

        if (fd == null) {

            System.out.printf(linesExecuted + " - Directory does not exist.");
        } else {
            FolderObject newElement = new FolderObject(fd, pathParts[pathParts.length - 1], null);
            fd.addChildred(newElement);
        }
    }

    private FolderObject checkExists(FolderObject folderObject, String element, String parentElement) {
        for (FileSystemObject f : folderObject.getChildren()) {
            FolderObject folder = null;

            if (f instanceof FolderObject) {
                folder = (FolderObject) f;
            } else {
                return null;
            }

            if (folder.getName().equals(element) && folder.getParent().getName().equals(parentElement)) {
                return (FolderObject) folder;
            } else {
                continue;
            }
        }
        return null;
    }

    private void createFile(String path) {
        String[] pathParts = path.split("/");
        FolderObject fd = this.buttonDemoProject;

        for (int i = 1; i < pathParts.length - 1; i++) {
            if (fd != null) {
                fd = checkExists(fd, pathParts[i], pathParts[i - 1]);
            } else {
                break;
            }
        }

        if (fd == null) {
            System.out.printf(linesExecuted + " - Illegal operation.");
        } else {
            FileObject newElement = new FileObject(fd, pathParts[pathParts.length - 1]);
            fd.addChildred(newElement);
        }
    }
}

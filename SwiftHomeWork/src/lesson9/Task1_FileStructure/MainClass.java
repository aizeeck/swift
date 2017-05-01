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
        String line = scanner.nextLine();

        while (!line.equals("END")) {
            String[] command = line.split(" ");
            mainClass.linesExecuted++;
            if (!checkSymbols(command[1])) {
                System.out.println(mainClass.linesExecuted + " - Invalid name specified");
            }
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

            System.out.println(linesExecuted + " - Directory does not exist.");
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
            System.out.println(linesExecuted + " - Illegal operation.");
        } else {
            FileObject newElement = new FileObject(fd, pathParts[pathParts.length - 1]);
            fd.addChildred(newElement);
        }
    }

    private static boolean checkSymbols(String line) {
        String correctCharSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789()_!.&/";
        /*for (char c = 'a'; c <= 'z'; c++) {
            System.out.print(c);
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            System.out.print(c);
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(i);
        }*/
        for (char c : line.toCharArray()) {
            if (correctCharSet.contains(String.valueOf(c))){
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}

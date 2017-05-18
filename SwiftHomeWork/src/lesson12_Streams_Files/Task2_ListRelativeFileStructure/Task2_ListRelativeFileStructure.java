package lesson12_Streams_Files.Task2_ListRelativeFileStructure;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by aizeeck on 17.05.17.
 */
public class Task2_ListRelativeFileStructure {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String workingDirString = scanner.nextLine();
        File workingDirectory = new File(workingDirString);
        try {
            printFolderContentAsRelative(workingDirectory, workingDirectory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printFolderContentAsRelative(File workingDirectory, File workingDirectoryInitial) throws IOException {
        File[] childrenList = workingDirectory.listFiles();
        for (File file : childrenList) {
            if (file.isDirectory()) {
                printFolderContentAsRelative(file, workingDirectoryInitial);
            } else if (file.isFile()) {
                System.out.println(workingDirectoryInitial.toURI().relativize(file.toURI()));
            }
        }
    }
}
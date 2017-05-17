package lesson12_Streams_Files.Task1_ListFileStructure;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by aizeeck on 17.05.17.
 */
public class Task1_ListFileStructure {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String workingDirString = scanner.nextLine();
        File workingDirectory = new File(workingDirString);
        try {
            printFolderContent(workingDirectory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printFolderContent(File workingDirectory) throws IOException {
        File[] childrenList = workingDirectory.listFiles();
        for (File file : childrenList) {
            if (file.isFile()) {
                System.out.println(file.getCanonicalPath());
            } else if (file.isDirectory()) {
                printFolderContent(file);
            }
        }
    }
}
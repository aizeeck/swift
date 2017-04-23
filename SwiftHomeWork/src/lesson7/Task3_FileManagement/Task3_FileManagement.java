package lesson7.Task3_FileManagement;

import java.util.*;

/**
 * Created by aizeeck on 22.04.17.
 */
public class Task3_FileManagement {
    private static Map<String, File> files = new LinkedHashMap<>();

    public static void main(String[] args) {

        Task3_FileManagement fileManager = new Task3_FileManagement();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("END")) break;
            String[] command = line.split(" ");
            switch (command[0]) {
                case "MAKE":
                    if (command[3].contains("CONTENT") && (command[1].endsWith(".avi") || command[1].endsWith(".mp3"))) {
                        fileManager.files.put(command[1], new MediaContentFile(command[1], command[2], command[3]));
                    } else if (command[3].contains("CONTENT")) {
                        fileManager.files.put(command[1], new DocumentContentFile(command[1], command[2], command[3]));
                    } else {
                        String[] res = new String[command.length - 3];
                        System.arraycopy(command,3, res,0, command.length - 3);
                        fileManager.files.put(command[1], new ExecutableFile(command[1], command[2], res));
                    }
                    break;
                case "MOVE":

                    break;
                case "MOD":

                    break;
                case "COPY":

                    break;
                case "DEL":
                    fileManager.files.get(command[1]).delete();
                    break;
                case "EXEC":
                    fileManager.files.get(command[1]).execute();
                    break;
                case "INFO":
                    fileManager.files.get(command[1]).info();
                    break;
            }
        }

        //fileManager.files.forEach((k,v) -> System.out.println(v + "\n"));
    }

    public static Map<String, File> getFiles() {
        return files;
    }
}

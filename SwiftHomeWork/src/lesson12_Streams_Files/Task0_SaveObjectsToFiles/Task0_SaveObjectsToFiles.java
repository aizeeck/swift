package lesson12_Streams_Files.Task0_SaveObjectsToFiles;

import java.io.*;
import java.util.Scanner;

/**
 * Created by aizeeck on 17.05.17.
 */
public class Task0_SaveObjectsToFiles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String objectPath = scanner.nextLine();

        Movie movie = new Movie("The Silicon Valey", "Some Guy", new String[]{"Richard Hendrix", "Gilfoil"});
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(
                    new FileOutputStream(objectPath + "/" + movie.getTitle() + ".jmov"));
            outputStream.writeObject(movie);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Movie recoveredMovie = null;
        try {
            ObjectInputStream inputStream = new ObjectInputStream(
                    new FileInputStream(objectPath + "/" + movie.getTitle() + ".jmov"));
            recoveredMovie = (Movie) inputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(movie);
        System.out.println(recoveredMovie);
    }
}

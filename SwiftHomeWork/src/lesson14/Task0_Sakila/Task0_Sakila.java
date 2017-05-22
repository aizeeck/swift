package lesson14.Task0_Sakila;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by aizeeck on 21.05.17.
 */
public class Task0_Sakila {

    public static void main(String[] args) throws SQLException {

        //connect to db
        System.out.println("Please type your password for the database...");
        MySQLCredential mySQLCredential = new MySQLCredential(
                "jdbc:mysql://localhost:3306/sakila",
                "root",
                new Scanner(System.in).nextLine());

        //create DAO
        ActorDAO actorDAO = new ActorDAO(mySQLCredential);
        FilmDAO filmDAO = new FilmDAO(mySQLCredential);

        //request new actor name
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please type the actor first and last name in one line...");
        String namesString = scanner.nextLine();
        String[] names = namesString.split(" ");

        //insert the actor to db and get the last insert id
        int newActorId = actorDAO.insertIntoActor(names[0], names[1]);

        //get film id by film name
        System.out.println("Please type the film name...");
        String filmName = scanner.nextLine();
        int filmId = filmDAO.getFilmIdByName(filmName);

        //insert film_actor
        actorDAO.assignActorToFilm(newActorId, filmId);

        //get an old actor and an old film and assign
        int oldActorName = actorDAO.getActorIdByName(names[0], names[1]);
        System.out.println("Please type the film name...");
        filmName = scanner.nextLine();
        filmId = filmDAO.getFilmIdByName(filmName);
        actorDAO.assignActorToFilm(oldActorName, filmId);
    }
}

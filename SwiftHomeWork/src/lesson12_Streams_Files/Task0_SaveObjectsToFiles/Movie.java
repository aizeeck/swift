package lesson12_Streams_Files.Task0_SaveObjectsToFiles;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by aizeeck on 17.05.17.
 */
public class Movie implements Serializable {
    private String title;
    private String director;
    private String[] actors;

    public Movie(String title, String director, String[] actors) {
        this.title = title;
        this.director = director;
        this.actors = actors;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public String[] getActors() {
        return actors;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", actors=" + Arrays.toString(actors) +
                '}';
    }
}

package ch.norwin.rest.util;

import ch.norwin.rest.entities.Song;
import com.google.gson.Gson;

import java.util.List;

public final class Json {
    private static final Gson g = new Gson();

    private Json() {

    }

    public static String asJson(Song song) {
        return g.toJson(song);
    }

    public static Song toJson(String song) {
        return g.fromJson(song, Song.class);
    }

    public static String listToJson(List<Song> songs) {
        return g.toJson(songs);
    }
}

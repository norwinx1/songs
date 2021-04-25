package ch.norwin.rest.util;

import ch.norwin.rest.entities.Song;

import java.util.List;

public final class Readable {
    private Readable() {

    }

    public static String listAsString(List<Song> songList) {
        StringBuilder s = new StringBuilder();
        for (Song song :
                songList) {
            s.append(song.toString()).append(" | ");
        }
        return s.toString();
    }
}

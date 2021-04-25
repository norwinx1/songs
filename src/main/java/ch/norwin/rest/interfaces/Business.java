package ch.norwin.rest.interfaces;

import ch.norwin.rest.entities.Song;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Business {
    private final List<Song> songList = new ArrayList<>();

    public Business() {
        addSong(new Song("Father", "Diamond Eyes", "C:\\Users\\norwi\\IdeaProjects\\rest\\src\\main\\resources\\static\\songs\\Diamond Eyes - Father [NCS Release].mp3"));
        addSong(new Song("Cetus", "Lensko", "C:\\Users\\norwi\\IdeaProjects\\rest\\src\\main\\resources\\static\\songs\\Lensko - Cetus [NCS Release].mp3"));
        addSong(new Song("Practical Heart", "Unkown", "C:\\Users\\norwi\\IdeaProjects\\rest\\src\\main\\resources\\static\\songs\\Practical Heart.mp3"));
    }

    public void addSong(Song song) {
        song.setId(songList.size());
        songList.add(song);
    }

    public void addSong(String name, String interpreter, String path) {
        Song song = new Song(name, interpreter, path);
        song.setId(songList.size());
        songList.add(song);
    }

    public void removeSong(int id) {
        songList.removeIf(song -> song.getId() == id);
    }

    public Song getSongByID(int id) {
        for (Song song :
                songList) {
            if (song.getId() == id) {
                return song;
            }
        }
        return null;
    }

    public List<Song> getSong(String searchValue) {
        List<Song> songs = new ArrayList<>();
        for (Song song :
                songList) {
            if (song.containsValue(searchValue)) {
                songs.add(song);
            }
        }
        return songs;
    }

    public List<Song> getAllSongs() {
        return songList;
    }
}

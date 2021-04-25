package ch.norwin.rest;

import ch.norwin.rest.entities.Song;
import ch.norwin.rest.interfaces.Business;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class BusinessTest {
    @Test
    public void getSongByIDTest() {
        Business business = new Business();
        Song expectedSong = new Song("Father", "Diamond Eyes", "C:\\Users\\norwi\\IdeaProjects\\rest\\src\\main\\resources\\static\\songs\\Diamond Eyes - Father [NCS Release].mp3");
        expectedSong.setId(0);
        Song actualSong = business.getSongByID(0);
        Assertions.assertEquals(expectedSong, actualSong);
    }
}

package ch.norwin.rest.interfaces;

import ch.norwin.rest.entities.Song;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static ch.norwin.rest.util.Json.asJson;
import static ch.norwin.rest.util.Json.listToJson;

@RestController
@CrossOrigin(maxAge = 1)
public class Controller {
    private final Business business = new Business();

    @GetMapping("/")
    public String home() {
        return listToJson(business.getAllSongs());
    }

    @GetMapping("/search/{value}")
    public String search(@PathVariable String value) {
        List<Song> songs = business.getSong(value);
        if (songs == null) {
            return "";
        }
        return listToJson(songs);
    }

    @GetMapping("/getSong/{id}")
    public String play(@PathVariable String id) {
        Song song = business.getSongByID(Integer.parseInt(id));
        if (song == null) {
            return "";
        }
        return asJson(song);
    }

    @GetMapping("/play/{id}")
    public ResponseEntity<byte[]> getSong(@PathVariable String id, HttpServletResponse response) {
        try {
            Path path = Paths.get(business.getSongByID(Integer.parseInt(id)).getPath());
            response.setContentType("audio/mp3");
            response.setContentLength((int) Files.size(path));
            Files.copy(path, response.getOutputStream());
            response.flushBuffer();
        } catch (Exception ignored) {

        }
        return null;
    }
}

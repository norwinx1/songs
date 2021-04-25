package ch.norwin.rest.entities;

public class Song {
    private int id;
    private String name;
    private String interpreter;
    private String path;

    public Song(String name, String interpreter, String path) {
        this.name = name;
        this.interpreter = interpreter;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInterpreter() {
        return interpreter;
    }

    public void setInterpreter(String interpreter) {
        this.interpreter = interpreter;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean containsValue(String value) {
        return this.name.contains(value) || this.interpreter.contains(value);
    }

    public String toString() {
        return this.name + ", " + this.interpreter + ", " + this.id;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (object instanceof Song) {
            Song song = (Song) object;
            return this.name.equals(song.name) && this.interpreter.equals(song.interpreter) && this.path.equals(song.path) && this.id == song.id;
        }
        return false;
    }
}

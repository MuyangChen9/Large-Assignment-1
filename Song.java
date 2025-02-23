import java.util.ArrayList;
import java.util.Scanner;

public class Song {
    private String title;
    private String artist;
    private String album;
    private String genre;
    private int year;
    private String content;

    public Song(String title, String artist, String album, String genre, int year) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.genre = genre;
        this.year = year;
        content = "";
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }
    
    public String getGenre() {
    	return genre;
    }
    
    public int getYear() {
    	return year;
    }
    
    public String getcontent() {
    	return content;
    }
    public Song(String songName) {
        Scanner scanner = new Scanner(songName);
        String [] getName = songName.split("_");
        String songTitle = getName[0];

        String firstLine = scanner.nextLine();
        String[] data = firstLine.split(",");
        String getAlbum = data[0].trim();
        String getArtist = data[1].trim();
        String getGenre = data[2].trim();
        int getYear = Integer.parseInt(data[3].trim());
        new Song(songTitle, getArtist, getAlbum, getGenre, getYear);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            content+=line;
            content+="\n";
        }

        scanner.close();
    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class Song {
    private String title;
    private String artist;
    private String album;
    private String genre;
    private int year;
    private String content;
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
    //read the file,get the information and the content for the song
    public Song(String songName) {
        Scanner scanner = new Scanner(songName);
        String [] getName = songName.split("_");
        String title = getName[0];

        String firstLine = scanner.nextLine();
        String[] data = firstLine.split(",");
        String album = data[0].trim();
        String artist = data[1].trim();
        String genre = data[2].trim();
        int year = Integer.parseInt(data[3].trim());
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.genre = genre;
        this.year = year;
        content = "";
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            content+=line;
            content+="\n";
        }

        scanner.close();
    }
}

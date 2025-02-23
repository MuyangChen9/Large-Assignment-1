import java.util.ArrayList;
import java.util.Scanner;

public class MusicStore {
    private ArrayList<Albums> album;

    private void readAlbums(String albums) {
        Scanner scanner = new Scanner(albums);

        String firstLine = scanner.nextLine();
        String[] data = firstLine.split(",");
        String albumTitle = data[0].trim();
        String artist = data[1].trim();
        String genre = data[2].trim();
        int year = Integer.parseInt(data[3].trim());

        ArrayList<Song> song = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String songTitle = scanner.nextLine().trim();
            song.add(new Song(songTitle, artist, albumTitle));
        }
        album.add(new Albums(albumTitle, artist, genre, year, song));
        scanner.close();
    }

    public ArrayList<Albums> getAlbums() {
        return album;
    }
    public ArrayList<Song> searchSongByTitle(String title) {
        ArrayList<Song> result = new ArrayList<>();
        for (Albums a : album) {
            if (a.getTitle().equals(title)) {
                result.addAll(a.getSongs());
            }
        }
        return result;
    }

    public ArrayList<Song> searchSongByArtist(String artist) {
        ArrayList<Song> result = new ArrayList<>();
        for (Albums a : album) {
            if (a.getArtist().equals(artist)) {
            	result.addAll(a.getSongs());
            }
        }
        return result;
    }

    public ArrayList<Albums> searchAlbumByTitle(String title) {
        ArrayList<Albums> result = new ArrayList<>();
        for (Albums a : album) {
            if (a.getTitle().equals(title)) {
                result.add(a);
            }
        }
        return result;
    }

    public ArrayList<Albums> searchAlbumByArtist(String artist) {
        ArrayList<Albums> result = new ArrayList<>();
        for (Albums a : album) {
            if (a.getArtist().equals(artist)) {
                result.add(a);
            }
        }
        return result;
    }
}

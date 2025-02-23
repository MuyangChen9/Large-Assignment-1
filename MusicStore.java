import java.util.ArrayList;
import java.util.Scanner;

public class MusicStore {
    private ArrayList<Albums> album;
    private ArrayList<Song> songList;
    
    
    
    
    private void readAlbums(String albums) {
    	Scanner scanner = new Scanner(albums);
        while (scanner.hasNextLine()) {
        String line = scanner.nextLine().trim();
        String [] content = line.split(",");
        String albumsName = content[0];
        String singerName = content[1];
        }
            
        scanner.close();
    }

    public ArrayList<Albums> getAlbums() {
        return album;
    }
    
    public ArrayList<Song> searchSongByTitle(String title) {
        ArrayList<Song> result = new ArrayList<>();
        for (Song s : songList) {
        	if(s.getTitle().equals(title)){
        		result.add(s);
        	}
        }
        return result;
    }

    public ArrayList<Song> searchSongByArtist(String artist) {
        ArrayList<Song> result = new ArrayList<>();
        for (Song s : songList) {
            if (s.getArtist().equals(artist)) {
            	result.add(s);
            }
        }
        return result;
    }

    public ArrayList<Albums> searchAlbumByTitle(String title) {
        ArrayList<Albums> result = new ArrayList<>();
        for (Albums a : album) {
            if (a.getSongList().containsKey(title)) {
                result.add(a);
            }
        }
        return result;
    }

    public ArrayList<Albums> searchAlbumByArtist(String artist) {
        ArrayList<Albums> result = new ArrayList<>();
        for (Albums a : album) {
            if (a.getSongList().equals(artist)) {
                result.add(a);
            }
        }
        return result;
    }


    public void addSong(String songName) {
    	Song newSong = new Song(songName);
    	songList.add(newSong);
    }
    
    public void addAlbums(String albumsName) {
    	Albums newAlbum = new Albums(albumsName);
    	album.add(newAlbum);
    }
}

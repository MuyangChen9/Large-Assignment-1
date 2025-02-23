import java.util.ArrayList;
import java.util.Scanner;

public class MusicStore {
    private ArrayList<Albums> album;
    private ArrayList<Song> songList;
    
    
//getter
    public ArrayList<Albums> getAlbums() {
        return album;
    }
    
    public ArrayList<Song> getSongList(){
    	return songList;
    }
    //search song by title
    public ArrayList<Song> searchSongByTitle(String title) {
        ArrayList<Song> result = new ArrayList<>();
        for (Song s : songList) {
        	if(s.getTitle().equals(title)){
        		result.add(s);
        	}
        }
        return result;
    }
//search song by artist
    public ArrayList<Song> searchSongByArtist(String artist) {
        ArrayList<Song> result = new ArrayList<>();
        for (Song s : songList) {
            if (s.getArtist().equals(artist)) {
            	result.add(s);
            }
        }
        return result;
    }
//search album by title
    public ArrayList<Albums> searchAlbumByTitle(String title) {
        ArrayList<Albums> result = new ArrayList<>();
        for (Albums a : album) {
            if (a.getSongList().containsKey(title)) {
                result.add(a);
            }
        }
        return result;
    }
//search album by artist
    public ArrayList<Albums> searchAlbumByArtist(String artist) {
        ArrayList<Albums> result = new ArrayList<>();
        for (Albums a : album) {
            if (a.getSongList().equals(artist)) {
                result.add(a);
            }
        }
        return result;
    }
    //read file, andr put the data into list
    public void addSong(String songName) {
    	Song newSong = new Song(songName);
    	songList.add(newSong);
    }
    
    public void addAlbums(String albumsName) {
    	Albums newAlbum = new Albums(albumsName);
    	album.add(newAlbum);
    }
}

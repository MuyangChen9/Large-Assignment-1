import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class LibraryModel {
    private String username;
    private ArrayList<Song> songList;
    private ArrayList<Albums> albumsList;
    private HashSet<Song> favoriteSongs;
    private HashMap<Song, Rate> songRatings;
    private HashMap<String, ArrayList<Song>> playLists;
    private MusicStore musicStore;

    public LibraryModel(String username, MusicStore musicStore) {
        this.username = username;
        this.songList = new ArrayList<>();
        this.albumsList = new ArrayList<>();
        this.favoriteSongs = new HashSet<>();
        this.songRatings = new HashMap<>();
        this.playLists = new HashMap<>();
        this.musicStore = musicStore;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<Song> searchSongByTitle(String title) {
        ArrayList<Song> result = new ArrayList<>();
        for (Song s : songList) {
            if (s.getTitle().equals(title)) {
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
        for (Albums a : albumsList) {
            if (a.getTitle().equals(title)) {
                result.add(a);
            }
        }
        return result;
    }

    public ArrayList<Albums> searchAlbumByArtist(String artist) {
        ArrayList<Albums> result = new ArrayList<>();
        for (Albums a : albumsList) {
            if (a.getArtist().equals(artist)) {
                result.add(a);
            }
        }
        return result;
    }
    
    
    public ArrayList<Song> searchPlayList(String name){
    	ArrayList<Song> result = new ArrayList<>();
    	if (playLists.containsKey(name)) {
    		result = playLists.get(name);
    	}
    	else {
    		System.out.println("Nothing found");
    		return result;
    		
    	}
    	if (result.size() == 0) {
    		System.out.println("Nothing found");
    		return result;
    	}
    	for (Song s : result) {
    		System.out.print("title :");
    		System.out.print(s.getTitle());
    		System.out.print("   artist: ");
    		System.out.println(s.getArtist());
    		
    	}
    	return result;
    }
    
    public boolean addPlaylist(String name) {
    	if(!playLists.containsKey(name)) {
    		return false;
    	}
    	playLists.put(name, new ArrayList<Song>());
    	
    	return true;
    }
    
    
    public boolean removePlaylist(String name) {
    	if(!playLists.containsKey(name)) {
    		return false;
    	}
    	playLists.remove(name)
    	
    	return true;
    }
    
    
}



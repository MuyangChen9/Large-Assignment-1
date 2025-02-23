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
            if (a.getSongList().equals(title)) {
                result.add(a);
            }
        }
        return result;
    }

    public ArrayList<Albums> searchAlbumByArtist(String artist) {
        ArrayList<Albums> result = new ArrayList<>();
        for (Albums a : albumsList) {
            if (a.getSongList().equals(artist)) {
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
    		System.out.print( "title:");
    		System.out.print(s.getTitle());
    		System.out.print("   artist: ");
    		System.out.println(s.getArtist());
    		System.out.println("\n");
    		
    		
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
    	playLists.remove(name);
    	
    	return true;
    }
    
    public boolean addPlayListSong(String playList, String song) {
    	if(!playLists.containsKey(playList)) {
    		return false;
    	}
    	ArrayList<Song> newSong = musicStore.searchSongByTitle(song);
    	if (newSong.size() == 0) {
    		return false;
    	}
    	Song addSong = newSong.get(0);
    	ArrayList<Song> newPlayList = playLists.get(playList);
    	newPlayList.add(addSong);
    	playLists.put(playList,newPlayList);
    	return true; 	
    	
    }
    
    public boolean removePlayListSong(String playList, String song) {
    	if(!playLists.containsKey(playList)) {
    		return false;
    	}
    	ArrayList<Song> newPlayList = playLists.get(playList);
    	if(!newPlayList.contains(song)) {
    		return false;
    	}
    	newPlayList.remove(song);

    	playLists.put(playList,newPlayList);
    	return true; 	
    	
    }
    
    
    public boolean addSongToLibrary(String song) {
    	ArrayList<Song> newSong = musicStore.searchSongByTitle(song);
    	if (newSong.size() == 0) {
    		return false;
    	}
    	songList.addAll(newSong);
    	return true;
    }
    
    
    public boolean addAlbumToLibrary(String albumsName) {
    	ArrayList<Albums> newSong = musicStore.searchAlbumByTitle(albumsName);
    	if (newSong.size() == 0) {
    		return false;
    	}
    	for (Albums a :albumsList) {
    		for (Song s : musicStore.getSongList()) {
    			if (a.equals(s.getTitle())){
    				songList.add(s);
    			}
    		}
    	}
    	return true;
    }
    
    public boolean markFavorite(String song) {
    	ArrayList<Song> newSong = musicStore.searchSongByTitle(song);
    	if (newSong.size() == 0) {
    		return false;
    	}
    	favoriteSongs.addAll(newSong);
    	return true;
    	
    }
    
    public boolean rateSong(int rate, String song) {
    	if (rate<0 && rate>5) {
    		return false;
    	}
    	ArrayList<Song> newSong = musicStore.searchSongByTitle(song);
    	if (newSong.size() == 0) {
    		return false;
    	}
    	Song addSong = newSong.get(0);
    	songRatings.put(addSong, new Rate(rate));
    	if (rate==5) {
    		favoriteSongs.add(addSong);
    	}
    	return true;
    }
    
    public ArrayList<Song> getSongByTitle(String title){
    	ArrayList<Song> result = new ArrayList<>();
    	for (Song s: songList) {
    		if (s.getTitle() == title) {
    			result.add(s);
    		}
    	}
    	return result;
    	
    }
    
    
    public ArrayList<Song> getSongByArtist(String artists){
    	ArrayList<Song> result = new ArrayList<>();
    	for (Song s: songList) {
    		if (s.getArtist() == artists) {
    			result.add(s);
    		}
    	}
    	return result;
    	
    }
    
    
    public ArrayList<Song> getSongByAlbums(String albums){
    	ArrayList<Song> result = new ArrayList<>();
    	for (Song s: songList) {
    		if (s.getAlbum() == albums) {
    			result.add(s);
    		}
    	}
    	return result;
    	
    }
    
    
    
    public ArrayList<Song> getPlayList(String playList){
    	ArrayList<Song> result = new ArrayList<>();
    	if(!playLists.containsKey(playList)){
    		return result;
    	}
    	else{
    		return playLists.get(playList);
    	}
    	
    }
    
    public static String getString(ArrayList<Song> songList) {
    	String result = "";
    	for (Song s : songList) {
    		result += "Title: ";
    		result += s.getTitle();
    		result += "  Album: ";
    		result += s.getAlbum();
    		result += "  Artist";
    		result += s.getArtist();
    		result += ("\n");
    	}
    	return result;
    }
}



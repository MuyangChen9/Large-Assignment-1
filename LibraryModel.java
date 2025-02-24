package model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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
    //search by title
    public ArrayList<Song> searchSongByTitle(String title) {
        ArrayList<Song> result = new ArrayList<>();
        for (Song s : songList) {
            if (s.getTitle().equals(title)) {
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
//search album by titel
    public ArrayList<Albums> searchAlbumByTitle(String title) {
        ArrayList<Albums> result = new ArrayList<>();
        for (Albums a : albumsList) {
            if (a.getAlbumsName().equals(title)) {
                result.add(a);
            }
        }
        return result;
    }
//search album by artist
    public ArrayList<Albums> searchAlbumByArtist(String artist) {
        ArrayList<Albums> result = new ArrayList<>();
        for (Albums a : albumsList) {
            if (a.getArtist().equals(artist)) {
                result.add(a);
            }
        }
        return result;
    }
    
    //seach a playlist
    public ArrayList<Song> searchPlayList(String name){
    	ArrayList<Song> result = new ArrayList<>();
    	if (playLists.containsKey(name)) {
    		result = playLists.get(name);	
    	}
    	return result;
    }
    //add playlist
    public boolean addPlaylist(String name) {
    	if(playLists.containsKey(name)) {
    		return false;
    	}
    	playLists.put(name, new ArrayList<Song>());
    	
    	return true;
    }
    
    //remove rhe playlist
    public boolean removePlaylist(String name) {
    	if(!playLists.containsKey(name)) {
    		return false;
    	}
    	playLists.remove(name);
    	
    	return true;
    }
    //add the song into playlist
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
    //remove the song in playlist
    public boolean removePlayListSong(String playList, String song) {
    	if(!playLists.containsKey(playList)) {
    		return false;
    	}
    	ArrayList<Song> newPlayList = playLists.get(playList);
    	for(int i = 0; i<newPlayList.size(); i++) {
    		if(!newPlayList.get(0).getTitle().contains(song)) {
        		return false;
        	}
    	}
    	
    	newPlayList.remove(song);

    	playLists.put(playList,newPlayList);
    	return true; 	
    	
    }
    
    //add song to library
    public boolean addSongToLibrary(String song) {
    	ArrayList<Song> newSong = musicStore.searchSongByTitle(song);
    	if (newSong.size() == 0) {
    		return false;
    	}
    	songList.addAll(newSong);
    	return true;
    }
    
    //add ablum to library
    public boolean addAlbumToLibrary(String albumsName) {
    	ArrayList<Albums> newSong = musicStore.searchAlbumByTitle(albumsName);
    	if (newSong.size() == 0) {
    		return false;
    	}
        if (!albumsList.contains(albumsName)) {
    		albumsList.addAll(newSong);
    	}
    	Albums newAlbum = newSong.get(0);
    		for (Song s: newAlbum.getSongList()) {
    			songList.add(s);
    		}
    	
    	return true;
    }
    // mark favorite song
    public boolean markFavorite(String song) {
    	ArrayList<Song> newSong = musicStore.searchSongByTitle(song);
    	if (newSong.size() == 0) {
    		return false;
    	}
    	favoriteSongs.addAll(newSong);
    	return true;
    	
    }
    //rate song
    public boolean rateSong(int rate, String song) {
    	if (rate<0 || rate>5) {
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
    
    //get all titles' name
    public ArrayList<String> getAllTitles(){
    	ArrayList<String> result = new ArrayList<String>();
    	for (Song s: songList) {
    		result.add(s.getTitle());
    	}
    	return result;
    }
    //get all artists' name
    public ArrayList<String> getAllArtist(){
    	ArrayList<String> result = new ArrayList<String>();
    	for (Song s: songList) {
    		if(!result.contains(s.getArtist()));
    			result.add(s.getArtist());
    	}
    	return result;
    }
    //get all albums' name
    public ArrayList<String> getAllAlbums(){
    	ArrayList<String> result = new ArrayList<String>();
    	for (Albums a: albumsList) {
    		result.add(a.getAlbumsName());
    	}
    	return result;
    }
    //get all playlists' name
    public ArrayList<String> getAllPlayList(){
    	ArrayList<String> result = new ArrayList<String>();
    	Set<String> keys = playLists.keySet();
    	for(String s : keys) {
    		result.add(s);
    	}
    	return result;
    }
    //get favorite songs' list
    public ArrayList<String> getAllFavorite(){
    	ArrayList<String> result = new ArrayList<String>();
    	for (Song s : favoriteSongs) {
    		result.add(s.getTitle());
    	}
    	return result;
    }
//get String
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

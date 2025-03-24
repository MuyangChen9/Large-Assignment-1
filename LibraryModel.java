package model;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
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
    private Map<Song, Integer> playCounts;
    private ArrayList<Song> recentPlayedSongs;
    
    

    public LibraryModel(String username, MusicStore musicStore) {
        this.username = username;
        this.songList = new ArrayList<>();
        this.albumsList = new ArrayList<>();
        this.favoriteSongs = new HashSet<>();
        this.songRatings = new HashMap<>();
        this.playLists = new HashMap<>();
        this.musicStore = musicStore;
        this.playCounts = new HashMap<>();
    }
    
    
    //new
   public boolean playSong(String title) {
    	ArrayList<Song> results = searchSongByTitle(title);
    	if (results.isEmpty()) {
    		return false;
    	}
    	Song song = results.get(0);
    	if (!playCounts.containsKey(song)) {
    		playCounts.put(song,0);
    	}
    	playCounts.put(song,playCounts.get(song) + 1);
    	if (recentPlayedSongs.size() == 10) {
    		recentPlayedSongs.remove(recentPlayedSongs.size() - 1);  	    
    	}
    	recentPlayedSongs.add(0, song);
    	return true;
    }
    //new
    public ArrayList<Song> getSongList() {
        return songList;
    }
  //new
    public void addSong(Song song) {
        songList.add(song);
    }
    //new
    public ArrayList<Song> getRecentPlayedSongs() {
        return new ArrayList<>(recentPlayedSongs);
    }
    //new
    public ArrayList<Song> getTenMost(){
    	ArrayList<Song> songs = new ArrayList<Song>(playCounts.keySet());
    	if (songs.size() <= 10) {
            return songs;
        }
    	ArrayList<Song> topSongs = new ArrayList<>();
    	ArrayList<Song> candidates = new ArrayList<>(songs);
    	while (topSongs.size() < 10 && !candidates.isEmpty()) {
    		Song maxSong = candidates.get(0);
    		for (Song s : candidates) {
                if (playCounts.get(s) > playCounts.get(maxSong)) {
                    maxSong = s;
                }
    		}
    		topSongs.add(maxSong);
            candidates.remove(maxSong);
    	}
    	return topSongs;
    }
    
    //new
    public void saveLibrary()throws IOException {
    	String fileName = username + "_library.txt";
    	BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
    	for (Song song : songList) {
            String line = song.getTitle() + "," 
                    + song.getArtist() + "," 
                    + song.getAlbum() + "," 
                    + song.getYear() + "," 
                    + song.getGenre();
            writer.write(line);
            writer.newLine();
        }
    }
    
    //new
    public void savePlayCounts() throws IOException{
    	String fileName = username + "_playCounts.txt";
    	BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
    	for (Map.Entry<Song, Integer> entry : playCounts.entrySet()) {
    		Song song = entry.getKey();
            int count = entry.getValue();
            String line = song.getTitle() + "," 
                    + song.getArtist() + "," 
                    + song.getAlbum() + "," 
                    + song.getYear() + "," 
                    + song.getGenre() + "," 
                    + count;
            writer.write(line);
            writer.newLine();
    	}
    }
    
    //new
    public void saverecentPlayedSongs() throws IOException{
    	String fileName = username + "_recentPlayed.txt";
    	BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
    	for (Song song : recentPlayedSongs) {
            String line = song.getTitle() + "," 
                    + song.getArtist() + "," 
                    + song.getAlbum() + "," 
                    + song.getYear() + "," 
                    + song.getGenre();
            writer.write(line);
            writer.newLine();
        }
    }
    
    //new 
    public void savedata() throws IOException{
    	saverecentPlayedSongs();
    	savePlayCounts();
    	saveLibrary();
    	
    	
    }
    
    //new
    public Map<Song, Integer> getPlayCounts(){
    	return playCounts;
    }
    
    //new
    public ArrayList<Song> getrecentPlayedSongs(){
    	return recentPlayedSongs;
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
//search album by title
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
    
    //remove the playlist
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
    		if(!result.contains(s.getArtist())) {
    			result.add(s.getArtist());
    		}
    	}
    	return result;
    }
    //get all albums' name
    public ArrayList<String> getAllAlbums(){
    	ArrayList<String> result = new ArrayList<String>();
    	for (Albums a: albumsList) {
    		if(!result.contains(a.getAlbumsName())) {
    			result.add(a.getAlbumsName());
    		}
    		
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
}

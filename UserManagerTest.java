package model;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
    private HashMap<String, PlayList> playLists;
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
        this.recentPlayedSongs = new ArrayList<>();
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
    	writer.close();
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
    	writer.close();
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
    	writer.close();
    }
    
    //new 
    public void savedata() throws IOException{
    	saverecentPlayedSongs();
    	savePlayCounts();
    	saveLibrary();
    	saveSongRatings();
    	
    	
    }
    
    //new
    public Map<Song, Integer> getPlayCounts(){
    	return playCounts;
    }
    
    //new
    public ArrayList<Song> getrecentPlayedSongs(){
    	return recentPlayedSongs;
    }


    //partc a
    public ArrayList<Song> getSongsSortedByTitle() {
    	ArrayList<Song> sortedList = new ArrayList<>(songList);
        Collections.sort(sortedList, Comparator.comparing(Song::getTitle));
        return sortedList;
    }
    
    public ArrayList<Song> getSongsSortedByArtist() {
    	ArrayList<Song> sortedList = new ArrayList<>(songList);
        Collections.sort(sortedList, Comparator.comparing(Song::getArtist));
        return sortedList;
    }
    
    public ArrayList<Song> getSongsSortedByRating(){
    	ArrayList<Song> unsortedList = new ArrayList<>(songList);
        ArrayList<Song> sortedList = new ArrayList<>();
        while (unsortedList.size() > 0) {
        	Song maxSong = unsortedList.get(0);
            int maxRating;
            if (songRatings.containsKey(maxSong)) {
                maxRating = songRatings.get(maxSong).getRate();
            } else {
                maxRating = 0;
            }
            int maxIndex = 0;
            int index = 1;
            while (index < unsortedList.size()) {
            	Song currentSong = unsortedList.get(index);
                int currentRating;
                if (songRatings.containsKey(currentSong)) {
                    currentRating = songRatings.get(currentSong).getRate();
                } else {
                    currentRating = 0;
                }
                if (currentRating > maxRating) {
                    maxSong = currentSong;
                    maxRating = currentRating;
                    maxIndex = index;
                }
                index++;
            }
            sortedList.add(maxSong);
            unsortedList.remove(maxIndex);
        }
        return sortedList;
    }
    
    public HashMap<Song, Rate> getSongRatings() {
    	return songRatings;
    }
    
    
    public void saveSongRatings() throws IOException{
    	String fileName = username + "_ratings.txt";
    	BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
    	for (Map.Entry<Song, Rate> entry : songRatings.entrySet()) {
            Song song = entry.getKey();
            Rate rate = entry.getValue();
            String line = song.getTitle() + "," 
                    + song.getArtist() + "," 
                    + song.getAlbum() + "," 
                    + song.getYear() + "," 
                    + song.getGenre() + "," 
                    + rate.getRate();
            writer.write(line);
            writer.newLine();
            writer.close();
        }
    }
    
    //partc b
    public boolean removeSong(String title) {
        boolean removed = false;
        int index = 0;
        while (index < songList.size()) {
            Song song = songList.get(index);
            if (song.getTitle().equalsIgnoreCase(title)) {
            	songList.remove(index);
                removed = true;
            if (playCounts.containsKey(song)) {
                playCounts.remove(song);
            }
            recentPlayedSongs.remove(song);
            if (songRatings.containsKey(song)) {
                songRatings.remove(song);
            }
        }else {
        	index++;
        }
        }
        return removed;
    }
    
    
    
    public boolean removeAlbum(String albumName) {
    	boolean removed = false;
        int index = 0;
        while (index < songList.size()) {
        	Song song = songList.get(index);
        	if (song.getAlbum().equalsIgnoreCase(albumName)) {
                songList.remove(index);
                removed = true;
                if (playCounts.containsKey(song)) {
                    playCounts.remove(song);
                }
                recentPlayedSongs.remove(song);
                if (songRatings.containsKey(song)) {
                    songRatings.remove(song);
                }
        	}else {
        		index++;
        	}
        }
        return removed;
    }
    
    public ArrayList<Song> shuffle() {
    	Collections.shuffle(songList);
    	return songList;
    }
    
    //d
    public String getAlbumInfoForSong(String songTitle) {
    	ArrayList<Song> foundSongs = musicStore.searchSongByTitle(songTitle);
    	if (foundSongs.size() == 0) {
    		return "No information found for this song.";
    	}
    	Song song = foundSongs.get(0);
        String albumName = song.getAlbum();
        ArrayList<Albums> foundAlbums = musicStore.searchAlbumByTitle(albumName);
        if (foundAlbums.size() == 0) {
        	return "No album information found for this song.";
        }
        Albums album = foundAlbums.get(0);
        boolean inUserLibrary = false;
        int i = 0;
        while (i < albumsList.size()) {
            Albums userAlbum = albumsList.get(i);
            if (userAlbum.getAlbumsName().equalsIgnoreCase(albumName)) {
                inUserLibrary = true;
                break;
            }
            i++;
        }
        String result = "Name:  " + album.getAlbumsName() + '\n' + "Artist:  " + album.getArtist() + "\n" +
        "Number of songs:  " +  album.getSongList().size();
        return result;
    }
    
    //e
    public boolean addSongToLibrary(String songTitle) {
    	ArrayList<Song> results = musicStore.searchSongByTitle(songTitle);
    	 if (results.size() == 0) {
    		 return false;
    	 }
    	 Song song = results.get(0);
    	 songList.add(song);
    	 boolean albumFound = false;
    	    for (int i = 0; i < albumsList.size(); i++) {
    	        Albums album = albumsList.get(i);
    	        if (album.getAlbumsName().equalsIgnoreCase(song.getAlbum())) {
    	            albumFound = true;
    	            if (!album.getSongList().contains(song)) {
    	                album.getSongList().add(song);
    	            }
    	            break;
    	        }
    	    }
    	    if (!albumFound) {
    	        Albums newAlbum = new Albums(song.getAlbum(), song.getArtist());
    	        newAlbum.getSongList().add(song);
    	        albumsList.add(newAlbum);
    	    }
    	    return true;
    }
    
    
    //f
    public ArrayList<Song> searchSongsByGenre(String genre){
    	ArrayList<Song> result = new ArrayList<>();
        int i = 0;
        while (i < songList.size()) {
        	Song currentSong = songList.get(i);
        	if (currentSong.getGenre().equalsIgnoreCase(genre)) {
                result.add(currentSong);
            }
            i++;
        }
        return result;
    }
        	
    

    //g
    public ArrayList<Song> getTopRatedSongs(){
    	ArrayList<Song> topRated = new ArrayList<>();
        int i = 0;
        while (i < songList.size()) {
        	Song song = songList.get(i);
            int rating = 0;
            if (songRatings.containsKey(song)) {
                rating = songRatings.get(song).getRate();
            }
            if (rating >= 4) {
                topRated.add(song);
            }
            i++;
        }
        return topRated;
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
    public PlayList searchPlayList(String name){
    	PlayList result = new PlayList(name);
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
    	PlayList playlist = new PlayList(name);
    	playLists.put(playlist.getName(), playlist);
    	
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

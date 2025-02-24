package model;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MusicStore {
    private ArrayList<Albums> album;
    private ArrayList<Song> songList;
    
    public MusicStore() {
    	ArrayList<Albums> album = new ArrayList<>();
    	ArrayList<Song> songList = new ArrayList<>();
    	this.album = album;
    	this.songList = songList;
    			
    }
    
    
    
    public ArrayList<Albums> getAlbums() {
        return album;
    }
    
    public ArrayList<Song> getSongList(){
    	return songList;
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
            if (a.getAlbumsName().equals(title)) {
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
    
  
    public void putAllSongin(){
    	for(Albums a :album) {
    		for (Song s: a.getSongList()) {
    			songList.add(s);
    		}
    	}
    }
    
    public void addAlbums(String albumsName) throws FileNotFoundException{
    	Albums newAlbum = new Albums(albumsName);
    	album.add(newAlbum);
    }
}

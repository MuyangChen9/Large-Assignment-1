package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Albums {
    private ArrayList<Song> songList;
    private String albumsName;
    private String artist;

    public ArrayList<Song> getSongList() {
    	return songList;
    }
    
    public String getAlbumsName() {
    	return albumsName;
    }
    public String getArtist() {
    	return artist;
    }
    
    public Albums(String albums)  throws FileNotFoundException{
    	ArrayList<Song> songList = new ArrayList<>();
    	File file = new File(albums);
    	Scanner scanner = new Scanner(file);
    	
    	
    	String firstLine = scanner.nextLine();
        String[] data = firstLine.split(",");
        String album = data[0].trim();
        String artist = data[1].trim();
        String genre = data[2].trim();
        int year = Integer.parseInt(data[3].trim());
        while(scanner.hasNextLine()) {
        	String title = scanner.nextLine().trim();
        	Song newSong = new Song(title,artist,album,year,genre);
        	songList.add(newSong);
        }
        this.songList = songList;
        this.albumsName = album;
        this.artist = artist;
            
        scanner.close();
    }
}

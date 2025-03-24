package model;

public class Song {
	
    private String title;
    private String artist;
    private String album;
    private int year;
    private String genre;

	

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    
    public String getAlbum() {
        return album;
    }
    
    public String getGenre() {
    	return genre;
    }
    
    public int getYear() {
    	return year;
    }
    
    
    public Song(String title, String artist,String album, int year, String genre){
    	this.title = title;
    	this.artist = artist;
    	this.album = album;
    	this.year = year;
    	this.genre =genre;
    }
        
}

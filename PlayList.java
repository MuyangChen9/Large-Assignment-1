import java.util.ArrayList;
import java.util.Collections;

public class PlayList {
	private ArrayList<Song> songs;
	
	public PlayList() {
        songs = new ArrayList<>();
    }
	
	public void addSong(Song song) {
        songs.add(song);
    }
	
	public void removeSong(Song song) {
        songs.remove(song);
    }
	public void shuffle() {
        Collections.shuffle(songs);
    }
	public ArrayList<Song> getSongs() {
        return songs;
    }

	
}

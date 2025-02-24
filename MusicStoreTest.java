package model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class MusicStoreTest {

	@Test
	void testMusicStore() throws FileNotFoundException {
		MusicStore musicStore = new MusicStore();
		musicStore.addAlbums("/Users/bryanfrank/Desktop/LA 1/albums/19_Adele.txt");
		musicStore.putAllSongin();
		
		ArrayList<Albums> album = musicStore.getAlbums();
		assertEquals(album.get(0).getAlbumsName(), "19");
		ArrayList<Song> album2 = musicStore.getSongList();
		assertEquals(album2.get(0).getTitle(), "Daydreamer");
		
		ArrayList<Song> songs = musicStore.searchSongByTitle("Daydreamer");
		assertEquals(songs.get(0).getTitle(), "Daydreamer");
		
		ArrayList<Song> songs2 = musicStore.searchSongByArtist("Adele");
		assertEquals(songs2.size(), 12);
		
		ArrayList<Song> songs3 = musicStore.searchSongByArtist("Adel");
		assertEquals(songs3.size(), 0);
		
		ArrayList<Albums> albums = musicStore.searchAlbumByTitle("19");
		assertEquals(albums.size(), 1);
		
		ArrayList<Albums> albums2 = musicStore.searchAlbumByTitle("18");
		assertEquals(albums2.size(), 0);
		
		ArrayList<Albums> albums3 = musicStore.searchAlbumByArtist("Adele");
		assertEquals(albums3.size(), 1);
		
		ArrayList<Albums> albums4 = musicStore.searchAlbumByArtist("Dele");
		assertEquals(albums4.size(), 0);
	}

}

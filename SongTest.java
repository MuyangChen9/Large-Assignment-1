package model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

class SongTest {

	@Test
	void testSong() throws FileNotFoundException {
		Song song = new Song("Best for Last", "Adele","19",2008,"Pop");
		assertEquals(song.getTitle(), "Best for Last");
		assertEquals(song.getArtist(),"Adele");
		assertEquals(song.getAlbum(), "19");
		
	}

}

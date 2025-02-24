package model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

class AlbumsTest {

	@Test
	void addAlbum() throws FileNotFoundException {
		String filePath = "/Users/bryanfrank/Desktop/LA 1/albums/19_Adele.txt";
		Albums album = new Albums(filePath);
		album.getSongList();
		assertEquals(album.getAlbumsName(), "19");
		assertEquals(album.getArtist(), "Adele");
	}

}

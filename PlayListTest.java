package model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class PlayListTest {
	@Test
	void PlayListTest() throws IOException {
		PlayList playlist = new PlayList();
		Song song = new Song("Tired","Adele","19",2008,"Pop");
		playlist.addSong(song);
		playlist.shuffle();
		assertEquals(playlist.getSongs().size(), 1);
		playlist.removeSong(song);
		assertEquals(playlist.getSongs().size(), 0);
	}
}

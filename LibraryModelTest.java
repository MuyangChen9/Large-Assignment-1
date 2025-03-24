package model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class LibraryModelTest {

	@Test
	void testLibraryModel() throws IOException {
		MusicStore musicStore = new MusicStore();
		musicStore.addAlbums("/Users/bryanfrank/Desktop/LA 1/albums/19_Adele.txt");
		musicStore.addAlbums("/Users/bryanfrank/Desktop/LA 1/albums/Sons_The Heavy.txt");
		musicStore.putAllSongin();
		
		LibraryModel account = new LibraryModel("Octio",musicStore);
		account.setUsername("Octiosling");
		assertEquals(account.getUsername(),"Octiosling");
		
		assertEquals(account.addSongToLibrary("Ice"), false);
		assertEquals(account.addSongToLibrary("Fire"), true);
		
		assertEquals(account.addAlbumToLibrary("19"), true);
		assertEquals(account.addAlbumToLibrary("18"), false);
		
		ArrayList<Song> songs = account.searchSongByTitle("Fire");
		assertEquals(songs.size(), 1);
		
		ArrayList<Song> songs2 = account.searchSongByArtist("The Heavy");
		assertEquals(songs2.size(), 1);
		
		ArrayList<Albums> albums = account.searchAlbumByTitle("19");
		assertEquals(albums.size(), 1);
		
		ArrayList<Albums> albums2 = account.searchAlbumByTitle("17");
		assertEquals(albums2.size(), 0);
		
		ArrayList<Albums> albums3 = account.searchAlbumByArtist("Adele");
		assertEquals(albums3.size(), 1);
		
		ArrayList<Albums> albums4 = account.searchAlbumByArtist("Adela");
		assertEquals(albums4.size(), 0);
		
		assertEquals(account.addPlaylist("My Playlist"), true);
		assertEquals(account.addPlaylist("My Playlist"), false);
		
		assertEquals(account.addPlayListSong("My Playlist", "Fire"), true);
		assertEquals(account.addPlayListSong("My Playlist", "Ice"), false);
		assertEquals(account.addPlayListSong("Me Playlist", "Fire"), false);
		
		ArrayList<Song> playlist = account.searchPlayList("My Playlist");
		assertEquals(playlist.size(), 1);
		
		ArrayList<Song> playlist2 = account.searchPlayList("Me Playlist");
		assertEquals(playlist2.size(), 0);
		
		assertEquals(account.removePlayListSong("Me Playlist", "Fire"), false);
		assertEquals(account.removePlayListSong("My Playlist", "Ice"), false);
		assertEquals(account.removePlayListSong("My Playlist", "Fire"), true);
		
		assertEquals(account.removePlaylist("Me Playlist"), false);
		assertEquals(account.removePlaylist("My Playlist"), true);
		
		assertEquals(account.markFavorite("Ice"), false);
		assertEquals(account.markFavorite("Fire"), true);
		
		assertEquals(account.rateSong(-5, "Tired"), false);
		assertEquals(account.rateSong(10, "Tired"), false);
		assertEquals(account.rateSong(4, "Tired"), true);
		assertEquals(account.rateSong(4, "Awake"), false);
		assertEquals(account.rateSong(5, "Tired"), true);
		
		ArrayList<String> allSongs = account.getAllTitles();
		assertEquals(allSongs.size(), 13);
		
		ArrayList<String> allArtists = account.getAllArtist();
		assertEquals(allArtists.size(), 2);
		
		ArrayList<String> allAlbums = account.getAllAlbums();
		assertEquals(allAlbums.size(), 2);
 		
		account.addPlaylist("Playlist 1");
		account.addPlaylist("Playlist 2");
		ArrayList<String> allPlaylists = account.getAllPlayList();
		assertEquals(allPlaylists.size(), 2);
		
		ArrayList<String> allFavorites = account.getAllFavorite();
		assertEquals(allFavorites.size(), 2);
		
		assertEquals(account.playSong("Fire"), true);
		
		assertEquals(account.getTenMost().size(), 1);
		
		assertEquals(account.playSong("Ice"), false);
		assertEquals(account.playSong("Daydreamer"), true);
		assertEquals(account.playSong("Daydreamer"), true);
		
		assertEquals(account.getTenMost().size(), 2);
		
		assertEquals(account.playSong("Best for Last"), true);
		assertEquals(account.playSong("Chasing Pavements"), true);
		assertEquals(account.playSong("Cold Shoulder"), true);
		assertEquals(account.playSong("Crazy for You"), true);
		assertEquals(account.playSong("Melt My Heart to Stone"), true);
		assertEquals(account.playSong("First Love"), true);
		assertEquals(account.playSong("Right as Rain"), true);
		assertEquals(account.playSong("My Same"), true);
		assertEquals(account.playSong("Tired"), true);
		
		assertEquals(account.getrecentPlayedSongs().size(), 10);
		
		assertEquals(account.getTenMost().size(), 10);
		
		account.savedata();
		
		assertEquals(account.getRecentPlayedSongs().size(), 10);
		
		assertEquals(account.getSongsSortedByTitle().size(), 13);
		
		assertEquals(account.getSongsSortedByArtist().size(), 13);
		
		assertEquals(account.getSongsSortedByRating().size(), 13);
		
		assertEquals(account.rateSong(5, "Fire"), true);
		assertEquals(account.removeSong("Fire"),true);
		assertEquals(account.removeSong("Ice"),false);
		
		assertEquals(account.getAlbumInfoForSong("T"), "No information found for this song.");
		
		account.getPlayCounts();
		
		account.getAlbumInfoForSong("Tired");
		assertEquals(account.addSongToLibrary("Heavy for You"), true);
		
		assertEquals(account.searchSongsByGenre("Rock").size(), 1);
		
		assertEquals(account.getTopRatedSongs().size(), 1);
		
		assertEquals(account.removeAlbum("19"), true);
		assertEquals(account.removeAlbum("18"), false);
	}

}

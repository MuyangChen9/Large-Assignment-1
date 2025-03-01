package view;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import model.Albums;
import model.LibraryModel;
import model.MusicStore;
import model.Rate;
import model.Song;

public class MusicUI extends Application{
	//Creates music store and library classes
	MusicStore store = new MusicStore();
	LibraryModel account = new LibraryModel("Octio", store);
	
	//Create UI elements
	private Label label1 = new Label("Search Music Store for Album by Title");
	private Label label2 = new Label("Search Music Store for Album by Artist");
	private Label label3 = new Label("Search Music Store for Song by Title");
	private Label label4 = new Label("Search Music Store for Song by Artist");
	private Label label5 = new Label("Search Library for Album by Title");
	private Label label6 = new Label("Search Library for Album by Artist");
	private Label label7 = new Label("Search Library for Song by Title");
	private Label label8 = new Label("Search Library for Song by Artist");
	private Label label9 = new Label("Search Playlist by Name");
	private Label label10 = new Label("Add Song to Library");
	private Label label11 = new Label("Add Album to Library");
	private Label label12 = new Label("Get List of Songs in Library");
	private Label label13 = new Label("Get List of Artists in Library");
	private Label label14 = new Label("Get List of Albums in Library");
	private Label label15 = new Label("Get List of Playlists in Library");
	private Label label16 = new Label("Get List of Favorites in Library");
	private Label label17 = new Label("Create Playlist");
	private Label label18 = new Label("Add Song to Playlist (Write playlist first then song, separated by a comma)");
	private Label label19 = new Label("Remove Song from Playlist (Write playlist first then song, separated by a comma)");
	private Label label20 = new Label("Mark Song as Favorite");
	private Label label21 = new Label("Rate Song (Write rating as number then song to rate, separated by a comma)");
	private Label label22 = new Label("Add Album to Store (Add filepaths here)");
	
	private Label return1 = new Label("");
	private Label return2 = new Label("");
	private Label return3 = new Label("");
	private Label return4 = new Label("");
	private Label return5 = new Label("");
	private Label return6 = new Label("");
	private Label return7 = new Label("");
	private Label return8 = new Label("");
	private Label return9 = new Label("");
	private Label return10 = new Label("");
	private Label return11 = new Label("");
	private Label return12 = new Label("");
	private Label return13 = new Label("");
	private Label return14 = new Label("");
	private Label return15 = new Label("");
	private Label return16 = new Label("");
	private Label return17 = new Label("");
	private Label return18 = new Label("");
	private Label return19 = new Label("");
	private Label return20 = new Label("");
	private Label return21 = new Label("");
	private Label return22 = new Label("");
	
	private TextField line1 = new TextField();
	private TextField line2 = new TextField();
	private TextField line3 = new TextField();
	private TextField line4 = new TextField();
	private TextField line5 = new TextField();
	private TextField line6 = new TextField();
	private TextField line7 = new TextField();
	private TextField line8 = new TextField();
	private TextField line9 = new TextField();
	private TextField line10 = new TextField();
	private TextField line11 = new TextField();
	private Button line12 = new Button();
	private Button line13 = new Button();
	private Button line14 = new Button();
	private Button line15 = new Button();
	private Button line16 = new Button();
	private TextField line17 = new TextField();
	private TextField line18 = new TextField();
	private TextField line19 = new TextField();
	private TextField line20 = new TextField();
	private TextField line21 = new TextField();
	private TextField line22 = new TextField();
	
	private Label songList = new Label();
	
	@Override
	//Create the UI
	public void start(Stage stage) {
		stage.setTitle("WildCat Music");
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.add(label1, 1, 1);
		grid.add(label2, 1, 2);
		grid.add(label3, 1, 3);
		grid.add(label4, 1, 4);
		grid.add(label5, 1, 5);
		grid.add(label6, 1, 6);
		grid.add(label7, 1, 7);
		grid.add(label8, 1, 8);
		grid.add(label9, 1, 9);
		grid.add(label10, 1, 10);
		grid.add(label11, 1, 11);
		grid.add(label12, 1, 12);
		grid.add(label13, 1, 13);
		grid.add(label14, 1, 14);
		grid.add(label15, 1, 15);
		grid.add(label16, 1, 16);
		grid.add(label17, 1, 17);
		grid.add(label18, 1, 18);
		grid.add(label19, 1, 19);
		grid.add(label20, 1, 20);
		grid.add(label21, 1, 21);
		grid.add(label22, 1, 22);
		
		grid.add(line1, 2, 1);
		grid.add(line2, 2, 2);
		grid.add(line3, 2, 3);
		grid.add(line4, 2, 4);
		grid.add(line5, 2, 5);
		grid.add(line6, 2, 6);
		grid.add(line7, 2, 7);
		grid.add(line8, 2, 8);
		grid.add(line9, 2, 9);
		grid.add(line10, 2, 10);
		grid.add(line11, 2, 11);
		grid.add(line12, 2, 12);
		grid.add(line13, 2, 13);
		grid.add(line14, 2, 14);
		grid.add(line15, 2, 15);
		grid.add(line16, 2, 16);
		grid.add(line17, 2, 17);
		grid.add(line18, 2, 18);
		grid.add(line19, 2, 19);
		grid.add(line20, 2, 20);
		grid.add(line21, 2, 21);
		grid.add(line22, 2, 22);
		
		grid.add(return1, 3, 1);
		grid.add(return2, 3, 2);
		grid.add(return3, 3, 3);
		grid.add(return4, 3, 4);
		grid.add(return5, 3, 5);
		grid.add(return6, 3, 6);
		grid.add(return7, 3, 7);
		grid.add(return8, 3, 8);
		grid.add(return9, 3, 9);
		grid.add(return10, 3, 10);
		grid.add(return11, 3, 11);
		grid.add(return12, 3, 12);
		grid.add(return13, 3, 13);
		grid.add(return14, 3, 14);
		grid.add(return15, 3, 15);
		grid.add(return16, 3, 16);
		grid.add(return17, 3, 17);
		grid.add(return18, 3, 18);
		grid.add(return19, 3, 19);
		grid.add(return20, 3, 20);
		grid.add(return21, 3, 21);
		grid.add(return22, 3, 22);
		
		grid.add(songList, 4, 1,1,20);
		songList.setMaxHeight(Double.MAX_VALUE);
		Scene scene = new Scene(grid, 2000, 1100);
		stage.setScene(scene);

		stage.show();
		//Initialize UI functionality
		line1.setOnAction(new TextFieldHandler1());
		line2.setOnAction(new TextFieldHandler2());
		line3.setOnAction(new TextFieldHandler3());
		line4.setOnAction(new TextFieldHandler4());
		line5.setOnAction(new TextFieldHandler5());
		line6.setOnAction(new TextFieldHandler6());
		line7.setOnAction(new TextFieldHandler7());
		line8.setOnAction(new TextFieldHandler8());
		line9.setOnAction(new TextFieldHandler9());
		line10.setOnAction(new TextFieldHandler10());
		line11.setOnAction(new TextFieldHandler11());
		line12.setOnAction(new TextFieldHandler12());
		line13.setOnAction(new TextFieldHandler13());
		line14.setOnAction(new TextFieldHandler14());
		line15.setOnAction(new TextFieldHandler15());
		line16.setOnAction(new TextFieldHandler16());
		line17.setOnAction(new TextFieldHandler17());
		line18.setOnAction(new TextFieldHandler18());
		line19.setOnAction(new TextFieldHandler19());
		line20.setOnAction(new TextFieldHandler20());
		line21.setOnAction(new TextFieldHandler21());
		line22.setOnAction(new TextFieldHandler22());
	}
	//Search music store for album by title
	private class TextFieldHandler1 implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent arg0) {
			String input = line1.getText();
			ArrayList<Albums> result = store.searchAlbumByTitle(input);
			if(result.size() == 0) {
				return1.setText("Album Not Found");
				songList.setText("");
			}
			else {
				String stri = "";
				for(int i = 0;i<result.size();i++){
					stri = stri + result.get(i).getAlbumsName() + ", " + result.get(i).getArtist() + "\n";
				}
				return1.setText(stri);
				
				String str = "";
				for(int j = 0;j<result.size();j++) {
					ArrayList<Song> songs = result.get(j).getSongList();
					for(int k = 0;k<songs.size();k++) {
						str = str + songs.get(k).getTitle() + "\n";
					}
				}
				songList.setText(str);
			}

		}
	}
	//Search music store for album by artist
	private class TextFieldHandler2 implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent arg0) {
			String input = line2.getText();
			ArrayList<Albums> result = store.searchAlbumByArtist(input);
			if(result.size() == 0) {
				return2.setText("Album Not Found");
			}
			else {
				String stri = "";
				for(int i = 0;i<result.size();i++) {
					stri = stri + result.get(i).getAlbumsName() + ", " + result.get(i).getArtist() + "\n";
				}
				return2.setText(stri);
				
				String str = "";
				for(int j = 0;j<result.size();j++) {
					ArrayList<Song> songs = result.get(j).getSongList();
					for(int k = 0;k<songs.size();k++) {
						str = str + songs.get(k).getTitle() + "\n";
					}
				}
				songList.setText(str);
				
			}

		}
	}
	//Search music store for song by title
	private class TextFieldHandler3 implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent arg0) {
			String input = line3.getText();
			ArrayList<Song> result = store.searchSongByTitle(input);
			if(result.size() == 0) {
				return3.setText("Song Not Found");
			}
			else {
				String stri = "";
				for(int i = 0;i<result.size();i++) {
					stri = stri + result.get(0).getTitle() + ", " + result.get(0).getArtist() + ", " + result.get(0).getAlbum() + "\n";
				}
				return3.setText(stri);
			}
		}
	}
	//Search song by artist
	private class TextFieldHandler4 implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent arg0) {
			String input = line4.getText();
			ArrayList<Song> result = store.searchSongByArtist(input);
			if(result.size() == 0) {
				return4.setText("Song Not Found");
			}
			else {
				String str = "";
				for(int i = 0; i<result.size();i++) {
					str = str + result.get(i).getTitle() + ", " + result.get(i).getArtist() + ", " + result.get(i).getAlbum() + "\n";
				}
				songList.setText(str);
			}
		}
	}
	//Search library for album by title
	private class TextFieldHandler5 implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent arg0) {
			String input = line5.getText();
			ArrayList<Albums> result = account.searchAlbumByTitle(input);
			if(result.size() == 0) {
				return5.setText("Album Not Found");
			}
			else {
				String stri = "";
				for(int i = 0;i<result.size();i++) {
					stri = stri + result.get(i).getAlbumsName() + ", " + result.get(i).getArtist() + "\n";
				}
				return5.setText(stri);
				
				String str = "";
				for(int j = 0;j<result.size();j++) {
					ArrayList<Song> songs = result.get(0).getSongList();
					for(int k = 0;k<songs.size();k++) {
						str = str + songs.get(k).getTitle() + "\n";
					}
				}
				songList.setText(str);
			}

		}
	}
	//Search library for album by artist
	private class TextFieldHandler6 implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent arg0) {
			String input = line6.getText();
			ArrayList<Albums> result = account.searchAlbumByArtist(input);
			if(result.size() == 0) {
				return6.setText("Album Not Found");
			}
			else {
				String stri = "";
				for(int i = 0;i<result.size();i++) {
					stri = stri + result.get(i).getAlbumsName() + ", " + result.get(i).getArtist() + "\n";
				}
				return6.setText(stri);
				
				String str = "";
				for(int j = 0;j<result.size();j++) {
					ArrayList<Song> songs = result.get(0).getSongList();
					for(int k = 0;k<songs.size();k++) {
						str = str + songs.get(k).getTitle() + "\n";
					}
				}
				songList.setText(str);
			}

		}
	}
	//Search library for song by title
	private class TextFieldHandler7 implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent arg0) {
			String input = line7.getText();
			ArrayList<Song> result = account.searchSongByTitle(input);
			if(result.size() == 0) {
				return7.setText("Song Not Found");
			}
			else {
				String str = "";
				for(int i = 0;i<result.size();i++) {
					str = str + result.get(i).getTitle() + ", " + result.get(i).getArtist() + ", " + result.get(i).getAlbum() + "\n";
				}
				return7.setText(str);
			}
		}
	}
	//Search library for song by artist
	private class TextFieldHandler8 implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent arg0) {
			String input = line8.getText();
			ArrayList<Song> result = account.searchSongByArtist(input);
			if(result.size() == 0) {
				return8.setText("Song Not Found");
			}
			else {
				String str = "";
				for(int i = 0; i<result.size();i++) {
					str = str + result.get(i).getTitle() + ", " + result.get(i).getArtist() + ", " + result.get(i).getAlbum() + "\n";
				}
				songList.setText(str);
			}
		}
	}
	//Search library for playlist
	private class TextFieldHandler9 implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent arg0) {
			String input = line9.getText();
			ArrayList<Song> result = account.searchPlayList(input);
			if(result.size() == 0) {
				return9.setText("Playlist Not Found");
			}	
			else {
				String str = "";
				for(int i = 0; i<result.size();i++) {
					str = str + result.get(i).getTitle() + ", " + result.get(i).getArtist() + ", " + "\n";
				}
				songList.setText(str);
			}
		}
	}
	//Add song to library
	private class TextFieldHandler10 implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent arg0) {
			String input = line10.getText();
			boolean result = account.addSongToLibrary(input);
			if(result == true) {
				return10.setText("Song Added to Library");
			}
			else {
				return10.setText("Song Not Added");
			}
		}
	}
	//Add album to library
	private class TextFieldHandler11 implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent arg0) {
			String input = line11.getText();
			boolean result = account.addAlbumToLibrary(input);
			if(result == true) {
				return11.setText("Album Added to Library");
			}
			else {
				return11.setText("Album Does Not Exist");
			}
		}
	}
	//Get all titles
	private class TextFieldHandler12 implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent arg0) {
			ArrayList<String> songs = account.getAllTitles();
			if(songs.size() == 0) {
				songList.setText("No songs");
			}
			else {
				String str = "";
				for(int i = 0;i<songs.size();i++) {
					str = str + songs.get(i) + "\n";
				}
				songList.setText(str);
			}
		}
	}
	//Get all artists
	private class TextFieldHandler13 implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent arg0) {
			ArrayList<String> artists = account.getAllArtist();
			if(artists.size() == 0) {
				songList.setText("No artists");
			}
			else {
				String str = "";
				for(int i = 0;i<artists.size();i++) {
					str = str + artists.get(i) + "\n";
				}
				songList.setText(str);
			}
		}
	}
	//Get all albums
	private class TextFieldHandler14 implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent arg0) {
			ArrayList<String> albums = account.getAllAlbums();
			if(albums.size() == 0) {
				songList.setText("No albums");
			}
			else {
				String str = "";
				for(int i = 0;i<albums.size();i++) {
					str = str + albums.get(i) + "\n";
				}
				songList.setText(str);
			}
		}
	}
	//Get all playlists
	private class TextFieldHandler15 implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent arg0) {
			ArrayList<String> playlist = account.getAllPlayList();
			if(playlist.size() == 0) {
				songList.setText("No playlists");
			}
			else {
				String str = "";
				for(int i = 0;i<playlist.size();i++) {
					str = str + playlist.get(i) + "\n";
				}
				songList.setText(str);
			}
		}
	}
	//Get all favorites
	private class TextFieldHandler16 implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent arg0) {
			ArrayList<String> favorite = account.getAllFavorite();
			if(favorite.size() == 0) {
				songList.setText("No favorites");
			}
			else {
				String str = "";
				for(int i = 0;i<favorite.size();i++) {
					str = str + favorite.get(i) + "\n";
				}
				songList.setText(str);
			}
		}
	}
	//Add playlist
	private class TextFieldHandler17 implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent arg0) {
			String input = line17.getText();
			
			boolean result = account.addPlaylist(input);
			
			if(result == false) {
				return17.setText("Playlist creation failed");
			}
			else {
				return17.setText(input + " created");
			}
		}
	}
	//Add song to playlist
	private class TextFieldHandler18 implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent arg0) {
			String input = line18.getText();
			if(!input.contains(",")) {
				return18.setText("Invalid input");
				
			}
			else {
				String[] ins = input.split(",", 2);
				boolean result = account.addPlayListSong(ins[0], ins[1]);
				if(result == false) {
					return18.setText("Song addition failed");
				}
				else {
					return18.setText("Song added to playlist: " + ins[0]);
				}
			}
		}
	}
	//Remove song from playlist
	private class TextFieldHandler19 implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent arg0) {
			String input = line19.getText();
			if(!input.contains(",")) {
				return19.setText("Invalid input");
				
			}
			else {
				String[] ins = input.split(",", 2);
				boolean result = account.removePlayListSong(ins[0], ins[1]);
				if(result == false) {
					return19.setText("Song removal failed");
				}
				else {
					return19.setText("Song removed from playlist: " + ins[0]);
				}
			}
		}
	}
	//Mark favorite
	private class TextFieldHandler20 implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent arg0) {
			String input = line20.getText();
			
			boolean result = account.markFavorite(input);
			
			if(result == false) {
				return20.setText("Favorite failed");
			}
			else {
				return20.setText(input + " set as favorite");
			}
		}
	}
	//Rate song
	private class TextFieldHandler21 implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent arg0) {
			String input = line21.getText();
			if(!input.contains(",")) {
				return21.setText("Invalid input");
				
			}
			else {
				String[]ins = input.split(",", 2);
				int firstVal = Integer.parseInt(ins[0]);
				
				boolean result = account.rateSong(firstVal, ins[1]);
				
				if(result == false) {
					return21.setText("Song rating failed");
				}
				else {
					return21.setText("Rated " + ins[1] + " a " + firstVal);
				}
			}
		}
	}
	//Import album to store
	private class TextFieldHandler22 implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent arg0){
			String input = line22.getText();
			try {
				store.addAlbums(input);
				store.putAllSongin();
				return22.setText("Added " + input);
			}
			catch(Exception e){
				return22.setText("Album does not exist");
			}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		launch(args);
	}
}

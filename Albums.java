import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Albums {
    private HashMap<String, String> songList;

    public HashMap<String, String> getSongList() {
    	return songList;
    }
    
    public Albums(String albums) {
        //read the file for album
    	Scanner scanner = new Scanner(albums);
    	HashMap<String, String> songList = new HashMap<>();
        while (scanner.hasNextLine()) {
        String line = scanner.nextLine().trim();
        String [] content = line.split(",");
        String albumsName = content[0];
        String singerName = content[1];
        
        
        songList.put(albumsName, singerName);
        }
        this.songList = songList;
            
        scanner.close();
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Albums {
    private HashMap<String, String> songList;

    public HashMap<String, String> getSongList() {
    	return songList;
    }
    
    public Albums(String albums)  throws FileNotFoundException{
    	File file = new File(albums);
    	Scanner scanner = new Scanner(file);
    	HashMap<String, String> songList = new HashMap<>();
        while (scanner.hasNextLine()) {
        String line = scanner.nextLine().trim();
        String [] content = line.split(",");
        String songName = content[0];
        String singerName = content[1];
        
        
        songList.put(songName, singerName);
        }
        this.songList = songList;
            
        scanner.close();
    }
}

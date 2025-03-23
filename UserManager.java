import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class UserManager {
	private Map<String, Userdata> userMap;
    private final String userdatafile = "users.txt";
    private static final int ITERATIONS = 10000;
    private static final int KEY_LENGTH = 256;
    
    public UserManager()  throws FileNotFoundException{
        userMap = new HashMap<>();
        loadUsers();
    }
    
    
    private String getNextSalt() {
        byte[] salt = new byte[16];
        SecureRandom sr = new SecureRandom();
        sr.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }
    
    
    private String hashPassword(char[] password, String salt) {
    	PBEKeySpec spec = new PBEKeySpec(password, Base64.getDecoder().decode(salt), ITERATIONS, KEY_LENGTH);
        Arrays.fill(password, Character.MIN_VALUE);
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hashed = skf.generateSecret(spec).getEncoded();
            return Base64.getEncoder().encodeToString(hashed);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException("Error while hashing a password: " + e.getMessage(), e);
        } finally {
            spec.clearPassword();
        }
    }
    
    private void saveUsers() throws IOException {

			BufferedWriter userdata;
				userdata = new BufferedWriter(new FileWriter(userdatafile));
				for (Userdata user : userMap.values()) {
					userdata.write(user.toCSV());
					userdata.newLine();
				}
    }
    
    
    private void loadUsers()  throws FileNotFoundException{
    	File file = new File(userdatafile);
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
	            String line = scanner.nextLine();
	            Userdata user = Userdata.fromCSV(line);
	    	}
    }
    
    public boolean register (String name, String password) throws IOException {
    	if (userMap.containsKey(name)) {
    		return false;
    	}
    	String salt = getNextSalt();
        String hashedPassword = hashPassword(password.toCharArray(), salt);
        Userdata newUser = new Userdata(name, salt, hashedPassword);
        userMap.put(name, newUser);
        saveUsers();
        createUserLibraryFile(name);
        return true;
    }
    
    
    public boolean login (String name, String password) {
    	if (!userMap.containsKey(name)) {
    		return false;
    	}
    	Userdata user = userMap.get(name);
    	String salt = user.getSalt();
        String expectedHash = user.getPasswordHash();
        String inputHash = hashPassword(password.toCharArray(), salt);
    if (inputHash.equals(expectedHash)) {
    	return true;
    }
    return false;
    }
    
    private void createUserLibraryFile(String username) {
        String libraryFile = username + "_library.txt";
        File file = new File(libraryFile);
    }
    
    
    public LibraryModel loadUserLibrary(String username)  throws FileNotFoundException{
    	 LibraryModel library = new LibraryModel(username, new MusicStore());
         String libraryFile = username + "_library.txt";
         File file = new File(libraryFile);
         if (!file.exists()) {
        	 return library;
         }
         Scanner scanner = new Scanner(file);
         while (scanner.hasNextLine()) {
         String line = scanner.nextLine();
         String[] parts = line.split(",");
         String title = parts[0].trim();
         String artist = parts[1].trim();
         String album = parts[2].trim();
         int year = Integer.parseInt(parts[3].trim());
         String genre = parts[4].trim();
         Song song = new Song(title, artist, album, year, genre);
         library.addSong(song);
         }
         return library;
    }
}
    

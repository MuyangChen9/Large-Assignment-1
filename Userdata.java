import java.io.*;
import java.security.SecureRandom;
import java.util.HashMap;



public class Userdata {
	private String username;
    private String salt;
    private String passwordHash;
    
    
    public Userdata(String username, String salt, String passwordHash) {
        this.username = username;
        this.salt = salt;
        this.passwordHash = passwordHash;
    }
	
    public String getUsername() {
        return username;
    }
    
    public String getSalt() {
        return salt;
    }
    
    public String getPasswordHash() {
        return passwordHash;
    }
    
    public String toCSV() {
        return username + "," + salt + "," + passwordHash;
    }
    
    
    public static Userdata fromCSV(String csvLine) {
        String[] parts = csvLine.split(",");
        return new Userdata(parts[0], parts[1], parts[2]);
        
    }

}

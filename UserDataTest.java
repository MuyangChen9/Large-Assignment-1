package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class userDataTest {
	@Test
	void UserData() {
		Userdata user = new Userdata("Octiosling", "#$%^&$#@!", "1234567890");
		assertEquals(user.getUsername(), "Octiosling");
		assertEquals(user.getSalt(), "#$%^&$#@!");
		assertEquals(user.getPasswordHash(), "1234567890");
		assertEquals(user.toCSV(), "Octiosling,#$%^&$#@!,1234567890");
		Userdata.fromCSV("Octiosling,#$%^&$#@!,1234567890");
	}
}

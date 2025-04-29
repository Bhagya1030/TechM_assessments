package day2;

public class AuthenticationSystem {
	public static void main(String[] args) {
        Authenticator auth = new Authenticator();
        
        // Test cases
        auth.login("admin123"); // Correct password
        auth.login("wrongPass"); // Incorrect password
    }
}

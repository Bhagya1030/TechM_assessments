package day2;

public class Authenticator {
	private String correctPassword = "admin123"; // Stored password

    // Inner class for validation (private)
    private class Validator {
        // Method to check if the given password matches
        private boolean isValid(String password) {
            return correctPassword.equals(password);
        }
    }

    // Public method to handle login
    public void login(String password) {
        Validator validator = new Validator(); // Create instance of Validator inside Authenticator
        if (validator.isValid(password)) {
            System.out.println("Login Successful!");
        } else {
            System.out.println("Incorrect Password.");
        }
    }
}

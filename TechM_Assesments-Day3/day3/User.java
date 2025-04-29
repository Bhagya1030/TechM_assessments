package day2;

class User {
    private String username;
    private String password;

    // Constructor
    public User(String username, String password) {
        this.username = username;
        setPassword(password); // Ensures security criteria are met
    }

    // Getter for username
    public String getUsername() {
        return username;
    }

    // No getter for password to ensure security

    // Setter for password with security validation
    public void setPassword(String password) {
        if (password.length() >= 8) {
            this.password = password;
        } else {
            throw new IllegalArgumentException("Password must be at least 8 characters long.");
        }
    }

    // Method to display user info (without exposing the password)
    public void displayUserInfo() {
        System.out.println("Username: " + username);
    }

    public static void main(String[] args) {
        try {
            User user1 = new User("john_doe", "sPass123");
            user1.displayUserInfo();

            // Attempt to set an invalid password
            user1.setPassword("sPass12345"); // This will throw an exception
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

package day1;
public class immutableclass {
	private final String databaseUrl;
    private final String username;
    private final String password;
    public immutableclass(String databaseUrl, String username, String password) {
        this.databaseUrl = databaseUrl;
        this.username = username;
        this.password = password;
    }
    public String getDatabaseUrl() {
        return databaseUrl;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public static void main(String[] args) {
        immutableclass config = new immutableclass("jdbc:mysql://localhost", "admin", "password123");
        System.out.println("Database URL: " + config.getDatabaseUrl());
        System.out.println("Username: " + config.getUsername());
        System.out.println("Password: " + config.getPassword());
    }
}
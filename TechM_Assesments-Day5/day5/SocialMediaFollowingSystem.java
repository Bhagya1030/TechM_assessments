package day5;
import java.util.*;

class SocialMediaUser {
    String username;
    HashSet<String> followers; // Stores unique followers

    // Constructor
    public SocialMediaUser(String username) {
        this.username = username;
        this.followers = new HashSet<>();
    }

    // Add a follower
    public void addFollower(String follower) {
        followers.add(follower);
    }

    // Display followers in alphabetical order using TreeSet
    public void displayFollowers() {
        TreeSet<String> sortedFollowers = new TreeSet<>(followers);
        System.out.println(username + "'s Followers (Alphabetical Order): " + sortedFollowers);
    }

    // Suggest friends (Mutual followers)
    public static void suggestFriends(SocialMediaUser user1, SocialMediaUser user2) {
        HashSet<String> mutualFollowers = new HashSet<>(user1.followers);
        mutualFollowers.retainAll(user2.followers); // Find common followers

        HashSet<String> user1Exclusive = new HashSet<>(user1.followers);
        user1Exclusive.removeAll(user2.followers); // Followers unique to user1

        HashSet<String> user2Exclusive = new HashSet<>(user2.followers);
        user2Exclusive.removeAll(user1.followers); // Followers unique to user2

        System.out.println("\nMutual Followers between " + user1.username + " & " + user2.username + ": " + mutualFollowers);
        System.out.println(user1.username + "'s Unique Followers: " + user1Exclusive);
        System.out.println(user2.username + "'s Unique Followers: " + user2Exclusive);
    }

    // Traverse followers using Iterator
    public void iterateFollowers() {
        System.out.println("\nIterating through " + username + "'s Followers:");
        Iterator<String> iterator = followers.iterator();
        while (iterator.hasNext()) {
            System.out.println("- " + iterator.next());
        }
    }
}

// Main Class
public class SocialMediaFollowingSystem {
    public static void main(String[] args) {
        // Create users
        SocialMediaUser alice = new SocialMediaUser("Alice");
        SocialMediaUser bob = new SocialMediaUser("Bob");

        // Add followers
        alice.addFollower("David");
        alice.addFollower("Charlie");
        alice.addFollower("Eve");

        bob.addFollower("Charlie");
        bob.addFollower("Frank");
        bob.addFollower("Eve");

        // Display followers alphabetically
        alice.displayFollowers();
        bob.displayFollowers();

        // Suggest new friends based on mutual and unique followers
        SocialMediaUser.suggestFriends(alice, bob);

        // Traverse followers using Iterator
        alice.iterateFollowers();
        bob.iterateFollowers();
    }
}

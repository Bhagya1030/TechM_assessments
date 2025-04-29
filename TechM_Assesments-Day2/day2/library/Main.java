package day2.library;
import day2.library.books.Book;
import day2.library.members.Member;
import static day2.library.utils.Utility.generateId; // Static import for calling generateId() directly

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", generateId());
        Member member1 = new Member("Alice Johnson", generateId());

        book1.displayBookInfo();
        member1.displayMemberInfo();
    }
}
import java.util.List;
import java.util.ArrayList;

public class User {
    private List<Book> books;

    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Checking if two users are identical
    public boolean equals(User user) {
        if(username.equals(user.getUsername()) && password.equals(user.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean rentBook(Library library, Book book){
        // if there is at least one amount of the book, then we can lend it
        if(library.isEnoughBook(book)) {
            books.add(book);
            library.decreaseBook(book, 1);
            return true;
        } else {
            return false;
        }
    }

    public void returnBook(Library library, Book book){
        books.remove(book);
        library.increaseBook(book, 1);
    }
}

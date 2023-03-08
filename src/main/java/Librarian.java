public class Librarian {
    private String username;
    private String password;

    public Librarian(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Checking if two librarians are identical
    public boolean equals(Librarian librarian) {
        if(username.equals(librarian.getUsername()) && password.equals(librarian.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

    // Librarians have permission to modify or access some parts of the library

    // User-related operations
    public void addUser(Library library, User user) {
        library.addUser(user);
    }

    public void removeUser(Library library, User user) {
        library.removeUser(user);
    }

    public void updateUser(Library library, User outdatedUser, User updatedUser) {
        library.updateUser(outdatedUser, updatedUser);
    }

    public User searchUser(Library library, String username) {
        return library.searchUser(username);
    }

    // Librarian-related operations
    public void addLibrarian(Library library, Librarian librarian) {
        library.addLibrarian(librarian);
    }

    public void removeLibrarian(Library library, Librarian librarian) {
        library.removeLibrarian(librarian);
    }

    public void updateLibrarian(Library library, Librarian outdatedLibrarian, Librarian updatedLibrarian) {
        library.updateLibrarian(outdatedLibrarian, updatedLibrarian);
    }

    public Librarian searchLibrarian(Library library, String username) {
        return library.searchLibrarian(username);
    }

    // Book-related operations
    public void addBook(Library library, Book book, int amount) {
        library.addBook(book, amount);
    }

    public void removeBook(Library library, Book book) {
        library.removeBook(book);
    }

    public void updateBook(Library library, Book outdatedBook, Book updatedBook) {
        library.updateBook(outdatedBook, updatedBook);
    }
    public Book searchBook(Library library, String bookName) {
        return library.searchBook(bookName);
    }
}

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Library {

    private List<Book> books;
    private HashMap<Integer, Integer> booksAmount;
    private List<Librarian> librarians;
    private List<User> users;

    public Library() {
        books = new ArrayList<Book>();
        booksAmount = new HashMap<Integer, Integer>();
        librarians = new ArrayList<Librarian>();
        users = new ArrayList<User>();
    }

    // book-related methods
    public void addBook(Book book, int amount){
        if(!doesBookExist(book)) {
            books.add(book);
            booksAmount.put(book.getISBN(), amount);
        }
    }

    public void removeBook(Book book){
        if(doesBookExist(book)) {
            books.remove(book);
            booksAmount.remove(book.getISBN());
        }
    }

    public Book searchBook(String bookName){
        for(Book candidateBook : books) {
            if(candidateBook.getName().equals(bookName)) {
                return candidateBook;
            }
        }
        return null;
    }

    public void updateBook(Book outdatedBook, Book updatedBook) {
        if(doesBookExist(outdatedBook)) {
            books.remove(outdatedBook);
            books.add(updatedBook);
            int amount = booksAmount.get(outdatedBook.getISBN());
            booksAmount.remove(outdatedBook.getISBN());
            booksAmount.put(updatedBook.getISBN(), amount);
        }
    }

    public boolean doesBookExist(Book book){
        for(Book candidateBook : books) {
            if(candidateBook.equals(book)) {
                return true;
            }
        }
        return false;
    }

    // check if there are at least one copy of a given book
    public boolean isEnoughBook(Book book) {
        if(doesBookExist(book)) {
            if(booksAmount.get(book.getISBN()) > 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void increaseBook(Book book, int amount){
        if(doesBookExist(book)) {
            int existedAmount = booksAmount.get(book.getISBN());
            booksAmount.put(book.getISBN(), existedAmount+amount);
        }
    }

    public void decreaseBook(Book book, int amount){
        if(doesBookExist(book)) {
            int existedAmount = booksAmount.get(book.getISBN());
            if(existedAmount >= amount) {
                booksAmount.put(book.getISBN(), existedAmount-amount);
            }
        }
    }

    // user-related functions

    public void addUser(User user){
        users.add(user);
    }

    public void removeUser(User user){
        users.remove(user);
    }

    public User searchUser(String username){
        for(User candidateUser : users) {
            if(candidateUser.getUsername().equals(username)) {
                return candidateUser;
            }
        }
        return null;
    }

    public void updateUser(User outdatedUser, User updatedUser){
        if(doesUserExist(outdatedUser)) {
            users.remove(outdatedUser);
            users.add(updatedUser);
        }
    }

    public boolean doesUserExist(User user){
        for(User candidateUser : users) {
            if(candidateUser.equals(user)) {
                return true;
            }
        }
        return false;
    }

    public boolean doesUsernameExist(String username) {
        for(User candidateUser : users) {
            String candidateUsername = candidateUser.getUsername();
            if(username.equals(candidateUsername)) {
                return true;
            }
        }
        for(Librarian candidateLibrarian : librarians) {
            String candidateUsername = candidateLibrarian.getUsername();
            if(username.equals(candidateUsername)) {
                return true;
            }
        }
        return false;
    }

    //librarian-related functions

    public void addLibrarian(Librarian librarian){
        librarians.add(librarian);
    }

    public void removeLibrarian(Librarian librarian){
        librarians.remove(librarian);
    }

    public Librarian searchLibrarian(String username){
        for(Librarian candidateLibrarian : librarians) {
            if(candidateLibrarian.getUsername().equals(username)) {
                return candidateLibrarian;
            }
        }
        return null;
    }

    public void updateLibrarian(Librarian outdatedLibrarian, Librarian updatedLibrarian){
        if(doesLibrarianExist(outdatedLibrarian)) {
            librarians.remove(outdatedLibrarian);
            librarians.add(updatedLibrarian);
        }
    }

    public boolean doesLibrarianExist(Librarian librarian){
        for(Librarian candidateLibrarian : librarians) {
            if(candidateLibrarian.equals(librarian)) {
                return true;
            }
        }
        return false;
    }
}

import java.util.Scanner;


public class Main {
    private static final String seperator = "-------------------------------------------";

    public static void main(String[] args) {
        runMenu();
    }
 
    public static void runMenu(){
        Scanner scanner = new Scanner(System.in);
        Library library = createInitialLibrary();

        System.out.println(seperator);
        System.out.println("Welcome to our Library!");
        boolean runner = true;
        while(runner) {
            printInitialOptions();
            int option = scanner.nextInt();
            scanner.nextLine();
            System.out.println(seperator);
            switch(option) {
                case 1:
                    User currentUser = logInUser(library);
                    if(currentUser != null) {
                        doUserOperations(library, currentUser);
                    }
                    break;
                case 2:
                    registerUser(library);
                    break;
                case 3:
                    Librarian currentLibrarian = logInLibrarian(library);
                    if(currentLibrarian != null) {
                        doLibrarianOperations(library, currentLibrarian);
                    }
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    System.out.println(seperator);
                    runner = false;
                    break;
            }
            
        }
        scanner.close();
    }

    public static void printInitialOptions() {
        System.out.println("Choose an option:");
        System.out.println("1: Log in as a user");
        System.out.println("2: Register as a user");
        System.out.println("3: Log in as a librarian");
        System.out.println("4: Exit");
    }

    public static Library createInitialLibrary() {
        Library library = new Library();
        Librarian initialLibrarian = new Librarian("admin", "admin");
        library.addLibrarian(initialLibrarian);
        return library;
    }

    public static void registerUser(Library library) {
        Scanner scanner = new Scanner(System.in);
        String username = "";
        String password = "";
        boolean usernameExists = true;
        while(usernameExists) {
            System.out.print("Choose a username: ");
            username = scanner.nextLine();
            if(library.doesUsernameExist(username)) {
                System.out.println("Username already  in use! Try another one.");
            } else {
                usernameExists = false;
            }
        }
        System.out.print("Choose a password: ");
        password = scanner.nextLine();
        User newUser = new User(username, password);
        library.addUser(newUser);

        System.out.println(seperator);
        System.out.println("Account created successfully! Now you can log in.");
        System.out.println(seperator);
    }

    public static User logInUser(Library library) {
        Scanner scanner = new Scanner(System.in);
        String username = "";
        String password = "";

        while(true) {
            System.out.print("Enter your username(or type 1 to exit): ");
            username = scanner.nextLine();
    
            if(username.equals("1")) {
                return null;
            }



            User currentUser = library.searchUser(username);

            if(currentUser == null) {
                System.out.println("No such username!");
                continue;
            }

            System.out.print("Enter your password: ");
            password = scanner.nextLine();
            if(currentUser.getPassword().equals(password)) {
                System.out.println("Logged in successfully!");
                System.out.println(seperator);
                return currentUser;
            } else {
                System.out.println("Wrong password.");
                System.out.println(seperator);
                continue;
            }
        }
    }

    public static void doUserOperations(Library library, User user) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        String bookName = "";
        Book currentBook;
        System.out.println("Welcome " + user.getUsername());
        while(running) {
            System.out.println("Choose an operation: ");
            System.out.println("1: Rent a Book");
            System.out.println("2: Return a Book");
            System.out.println("3: Log Out");
            int operation = scanner.nextInt();
            scanner.nextLine();
            System.out.println(seperator);
            switch(operation) {
                case 1:
                    System.out.println("Enter the book's name: ");
                    bookName = scanner.nextLine();
                    currentBook = library.searchBook(bookName);
                    if(currentBook != null) {
                        if(!user.rentBook(library, currentBook)) {
                            System.out.println("No copy remains!");
                        }
                    } else {
                        System.out.println("No such book exists!");
                    }
                    break;
                case 2:
                    System.out.println("Enter the book's name: ");
                    bookName = scanner.nextLine();
                    currentBook = library.searchBook(bookName);
                    if(currentBook != null) {
                        user.returnBook(library, currentBook);
                    } else {
                        System.out.println("No such book exists!");
                    }
                    break;

                case 3:
                    running = false;
                    System.out.println("Good Bye " + user.getUsername());
                    break;
            }
            System.out.println(seperator);
        }

        
    }

    public static void registerLibrarian(Library library) {
        Scanner scanner = new Scanner(System.in);
        String username = "";
        String password = "";
        boolean usernameExists = true;
        while(usernameExists) {
            System.out.print("Choose a username: ");
            username = scanner.nextLine();
            if(library.doesUsernameExist(username)) {
                System.out.println("Username already  in use! Try another one.");
            }
        }
        System.out.print("Choose a password: ");
        password = scanner.nextLine();
        Librarian newLibrarian = new Librarian(username, password);
        library.addLibrarian(newLibrarian);

        System.out.println(seperator);
        System.out.println("Account created successfully!");
        System.out.println(seperator);
    }

    public static Librarian logInLibrarian(Library library) {
        Scanner scanner = new Scanner(System.in);
        String username = "";
        String password = "";

        while(true) {
            System.out.print("Enter your username(or type 1 to exit): ");
            username = scanner.nextLine();
    
            if(username.equals("1")) {
                return null;
            }

            Librarian currentLibrarian = library.searchLibrarian(username);

            if(currentLibrarian == null) {
                System.out.println("No such username!");
                continue;
            }

            System.out.print("Enter your password: ");
            password = scanner.nextLine();
            if(currentLibrarian.getPassword().equals(password)) {
                System.out.println("Logged in successfully!");
                System.out.println(seperator);
                return currentLibrarian;
            } else {
                System.out.println("Wrong password.");
                System.out.println(seperator);
                continue;
            }
        }
    }

    public static void doLibrarianOperations(Library library, Librarian librarian) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome " + librarian.getUsername());
        while(running) {
            System.out.println("Choose an operation: ");
            System.out.println("1: Add User");
            System.out.println("2: Remove User");
            System.out.println("3: Update User");
            System.out.println("4: Add Librarian");
            System.out.println("5: Remove Librarian");
            System.out.println("6: Update Librarian");
            System.out.println("7: Add Book");
            System.out.println("8: Remove Book");
            System.out.println("9: Update Book");
            System.out.println("10: Log Out");
            int operation = scanner.nextInt();
            scanner.nextLine();

            String username = "";
            String updatedUsername = "";
            boolean userNameExists = true;
            String password = "";
            User currentUser;
            Librarian currentLibrarian;
            Book currentBook;
            String bookName;
            String author;
            int year;
            int ISBN;
            int amount;

            switch(operation) {
                case 1:
                    while(userNameExists) {
                        System.out.println("Choose a username(or exit with 1): ");
                        username = scanner.nextLine();
                        if(username.equals("1")) {
                            break;
                        }
                        if(library.doesUsernameExist(username)) {
                            System.out.println("Username already exists!");
                        } else {
                            userNameExists = false;
                        }
                    }

                    if(userNameExists) {
                        break;
                    }
                    System.out.println("Choose a password: ");
                    password = scanner.nextLine();
                    User newUser = new User(username, password);

                    library.addUser(newUser);
                    System.out.println("User created successfully!");
                    break;

                case 2:
                    System.out.println("Choose a username(or exit with 1): ");
                    username = scanner.nextLine();
                    currentUser = library.searchUser(username);
                    if(currentUser == null) {
                        System.out.println("No such user exists!");
                        break;
                    }

                    library.removeUser(currentUser);
                    System.out.println("User removed successfully!");
                    break;

                case 3:
                    System.out.println("Choose a username(or exit with 1): ");
                    username = scanner.nextLine();
                    currentUser = library.searchUser(username);
                    if(currentUser == null) {
                        System.out.println("No such user exists!");
                        break;
                    }

                    while(userNameExists || !updatedUsername.equals(username)) {
                        System.out.println("Choose the updated username(or exit with 1): ");
                        updatedUsername = scanner.nextLine();
                        if(updatedUsername.equals("1")) {
                            break;
                        }
                        if(library.doesUsernameExist(updatedUsername) && !updatedUsername.equals(username)) {
                            System.out.println("Username already exists!");
                        } else {
                            userNameExists = false;
                        }
                    }

                    if(userNameExists || !updatedUsername.equals(username)) {
                        break;
                    }
                    
                    System.out.println("Choose a password for the updated user: ");
                    password = scanner.nextLine();
                    
                    User updatedUser = new User(updatedUsername, password);

                    library.updateUser(currentUser, updatedUser);
                    System.out.println("User updated successfully!");
                    break;

                case 4:
                    while(userNameExists) {
                        System.out.println("Choose a username(or exit with 1): ");
                        username = scanner.nextLine();
                        if(username.equals("1")) {
                            break;
                        }
                        if(library.doesUsernameExist(username)) {
                            System.out.println("Username already exists!");
                        } else {
                            userNameExists = false;
                        }
                    }

                    if(userNameExists) {
                        break;
                    }
                    System.out.println("Choose a password: ");
                    password = scanner.nextLine();
                    Librarian newLibrarian = new Librarian(username, password);

                    library.addLibrarian(newLibrarian);
                    System.out.println("Librarian created successfully!");
                    break;

                case 5:
                    System.out.println("Choose a username(or exit with 1): ");
                    username = scanner.nextLine();
                    currentLibrarian = library.searchLibrarian(username);
                    if(currentLibrarian == null) {
                        System.out.println("No such user exists!");
                        break;
                    }

                    library.removeLibrarian(currentLibrarian);
                    System.out.println("Librarian removed successfully!");
                    break;

                case 6:
                    System.out.println("Choose a username(or exit with 1): ");
                    username = scanner.nextLine();
                    currentLibrarian = library.searchLibrarian(username);
                    if(currentLibrarian == null) {
                        System.out.println("No such user exists!");
                        break;
                    }

                    while(userNameExists || !updatedUsername.equals(username)) {
                        System.out.println("Choose the updated username(or exit with 1): ");
                        updatedUsername = scanner.nextLine();
                        if(updatedUsername.equals("1")) {
                            break;
                        }
                        if(library.doesUsernameExist(updatedUsername) && !updatedUsername.equals(username)) {
                            System.out.println("Username already exists!");
                        } else {
                            userNameExists = false;
                        }
                    }

                    if(userNameExists || !updatedUsername.equals(username)) {
                        break;
                    }
                    
                    System.out.println("Choose a password for the updated user: ");
                    password = scanner.nextLine();
                    
                    Librarian updatedLibrarian = new Librarian(updatedUsername, password);

                    library.updateLibrarian(currentLibrarian, updatedLibrarian);
                    System.out.println("Librarian updated successfully!");
                    break;

                case 7:

                    System.out.println("Type the book's name: ");
                    bookName = scanner.nextLine();

                    System.out.println("Type the author's name: ");
                    author = scanner.nextLine();

                    System.out.println("Type the year of the publish: ");
                    year = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Type book's ISBN:  ");
                    ISBN = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Type book's available copies:  ");
                    amount = scanner.nextInt();
                    scanner.nextLine();

                    currentBook = new Book(bookName, author, year, ISBN);

                    library.addBook(currentBook, amount);
                    System.out.println("Book added successfully!");
 
                    break;

                case 8:

                    System.out.println("Type the book's name: ");
                    bookName = scanner.nextLine();

                    System.out.println("Type the author's name: ");
                    author = scanner.nextLine();

                    System.out.println("Type the year of the publish: ");
                    year = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Type book's ISBN:  ");
                    ISBN = scanner.nextInt();
                    scanner.nextLine();

                    currentBook = new Book(bookName, author, year, ISBN);

                    library.removeBook(currentBook);
                    System.out.println("Book removed successfully!");

                    break;

                case 9:

                    System.out.println("Type the book's name: ");
                    bookName = scanner.nextLine();

                    System.out.println("Type the author's name: ");
                    author = scanner.nextLine();

                    System.out.println("Type the year of the publish: ");
                    year = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Type the book's ISBN:  ");
                    ISBN = scanner.nextInt();
                    scanner.nextLine();

                    currentBook = new Book(bookName, author, year, ISBN);

                    if(!library.doesBookExist(currentBook)) {
                        System.out.println("No such book exists!");
                        break;
                    }

                    System.out.println("Type the book's new name: ");
                    String newBookName = scanner.nextLine();

                    System.out.println("Type the author's name: ");
                    String newAuthor = scanner.nextLine();

                    System.out.println("Type the year of the publish: ");
                    int newYear = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Type the new book's ISBN:  ");
                    int newISBN = scanner.nextInt();
                    scanner.nextLine();

                    Book updatedBook = new Book(newBookName, newAuthor, newYear, newISBN);

                    library.updateBook(currentBook, updatedBook);

                    break;

                case 10:
                    running = false;
                    System.out.println("Good Bye " + librarian.getUsername());
                    break;
            }
            System.out.println(seperator);
        }
    }
}
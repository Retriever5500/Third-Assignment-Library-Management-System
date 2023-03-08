public class Book {
    private String name;
    private String author;
    private int yearOfPublish;
    // Unique number assigned to each book
    private int ISBN;

    public Book(String name, String author, int yearOfPublish, int ISBN) {
        this.name = name;
        this.author = author;
        this.yearOfPublish = yearOfPublish;
        this.ISBN = ISBN;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return yearOfPublish;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.yearOfPublish = year;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    // Checking if two books are identical
    public boolean equals(Book book) {
        if(name.equals(book.getName()) && author.equals(book.getAuthor()) &&
           yearOfPublish == book.getYear() && ISBN == book.getISBN()) {
            return true;
        } else {
            return false;
        }
    }
}

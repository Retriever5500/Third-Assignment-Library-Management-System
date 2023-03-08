![SBU](https://raw.githubusercontent.com/Retriever5500/Third-Assignment-Library-Management-System/dev/res/SBU.png)




# 3rd Assignment Report

# Ali Sawari 401222077



[^1]: Spring 2023



# Introduction:

The purpose of the assignment is to get to know and use classes and OOP in our code.

In this assignment we are meant to create a library which consists of books, users and librarians. To do so we abstract each of these and create a class for them.

In a nutshell, classes were made for **Library**, **Book**, **User** and **Librarian**. **Library** is basically a collection of books, users, librarians and also some methods to manipulate these data. What **Book** holds are book name, author, year of publish and ISBN(a unique number assigned to each book). A **User**, which consists of a username, password and a list of books, can rent or return a given book. A **Librarian** also has a username and password but has some other permissions like adding, removing and updating books/users/other librarians.

Bonus Objectives that have been done:
1: Encapsulation
2: Input Validation (partially)

# Design and Implementation

To make each of these, we create an initial library of class **Library** and create lists of users, books and librarians. Also, to keep an account of how many copies we have of a given book, we create a hash map that corresponds a book's ISBN to it's available amount of copies.

For **User**, we create a list of books and two strings for username and password and methods for returning and renting books. **Librarian** also has two strings for username and password but also has methods for adding, removing and updating books/users/other librarians from a given library. For **Books**, we create two strings for its name and author; plus two integers to store its yearof publish and ISBN.

# Testing
TODO

# Conclusion
The difference between private and public properties are the fact that you can only access private properties inside the methods of a the class, whilist that you can access the public ones anywhere you want. The private approach is usually better to ensure that the user doesn't accidently change the values of a given property.

We also learned how to break down our code to smaller bits and abstract some structures.

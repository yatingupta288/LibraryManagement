package com.LibraryManagement.Service;

import com.LibraryManagement.dto.Books;
import com.LibraryManagement.dto.User;

public interface LibraryService {
    void addBooks(Books book);
    void addUser(User user);
    void issueBook(Books book, User user);
    void returnBook(Books book, User user);
    Books mostPopularBook();
    User userWithMostBooks();
}

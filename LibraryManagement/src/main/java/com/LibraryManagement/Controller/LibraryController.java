package com.LibraryManagement.Controller;

import com.LibraryManagement.Service.LibraryService;
import com.LibraryManagement.dto.Books;
import com.LibraryManagement.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LibraryController {
    @Autowired
    LibraryService libser;

    @PostMapping(value = "/addbook", produces = "application/json")
    public void add(@RequestBody Books books){
        libser.addBooks(books);
    }

    @PostMapping(value = "/adduser", produces = "application/json")
    public void adduser(@RequestBody User users){
        libser.addUser(users);
    }

    @PostMapping(value = "/issuebook" , produces = "application/json")
    public void issuebook(@RequestBody Books book, @RequestBody User user){
        libser.issueBook(book, user);
    }

    @PutMapping(value = "/returnbook" , produces = "application/json")
    public void returnbook(@RequestBody Books book, @RequestBody User user){
        libser.returnBook(book, user);
    }

    @GetMapping(value = "/mostPopBook", produces = "application/json")
    public Books mostPopBook(){
        return libser.mostPopularBook();
    }

    @GetMapping(value = "/userwithMPBook", produces = "application/json")
    public User userMostBooks(){
        return libser.userWithMostBooks();
    }
}

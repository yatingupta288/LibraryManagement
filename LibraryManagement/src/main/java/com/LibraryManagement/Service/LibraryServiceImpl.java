package com.LibraryManagement.Service;

import com.LibraryManagement.Entity.BooksEntity;
import com.LibraryManagement.Entity.UserBookHistoryEntity;
import com.LibraryManagement.Entity.UserEntity;
import com.LibraryManagement.Repository.BooksRepo;
import com.LibraryManagement.Repository.UserBookHistoryDetails;
import com.LibraryManagement.Repository.UserRepo;
import com.LibraryManagement.dto.Books;
import com.LibraryManagement.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.HashMap;
import java.util.Map;

@Service
public class LibraryServiceImpl implements LibraryService{

    @Autowired
    BooksRepo booksRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    UserBookHistoryDetails userBookHistoryDetails;


    @Override
    public void addBooks(Books book){
        booksRepo.save(new BooksEntity(book.getId(), book.getName(), book.getWriter(),book.getSummary(),book.getCategory()));
    }

    public void addUser(User user){
        userRepo.save(new UserEntity(user.getId(), user.getName(), user.getAddress(), user.getPhoneNumber()));
    }

    public void issueBook(Books book, User user){
        Iterable<UserBookHistoryEntity> userBookHistorieslist = userBookHistoryDetails.findAll();
        for(UserBookHistoryEntity userhistory :  userBookHistorieslist){
            if(userhistory.getBookid() == book.getId()){
                if(userhistory.getStartdate() != null && userhistory.getEnddate() == null){
                    System.out.println("Not able to issue");
                    return;
                }
                LocalDate myobj = LocalDate.now();
                userBookHistoryDetails.save(new UserBookHistoryEntity(user.getId(), book.getId(), myobj.toString(), userhistory.getEnddate()));
            }
        }
    }

    public void returnBook(Books book, User user){
        Iterable<UserBookHistoryEntity> userBookHistorieslist = userBookHistoryDetails.findAll();
        for(UserBookHistoryEntity userhistory :  userBookHistorieslist){
            if(userhistory.getBookid() == book.getId() && userhistory.getUserId() == user.getId() && userhistory.getStartdate() != null){
                LocalDate myobj = LocalDate.now();
                userBookHistoryDetails.save(new UserBookHistoryEntity(user.getId(), book.getId(), userhistory.getStartdate(), myobj.toString()));
            }
        }
    }

    public Books mostPopularBook(){
        Iterable<UserBookHistoryEntity> listForMax = userBookHistoryDetails.findAll();
        Map<Long, Integer> map = new HashMap<>();
        for(UserBookHistoryEntity Book1: listForMax){
            map.put(Book1.getBookid(), map.getOrDefault(Book1.getBookid(), 0) + 1);
        }

        int maxId = 0;
        Long getMaxBookId = 0L;
        for(Long Bookid : map.keySet()){
            if(map.get(Bookid) > maxId){
                maxId = map.get(Bookid);
                getMaxBookId = Bookid;
            }
        }

        Iterable<BooksEntity> listToGetPopBook = booksRepo.findAll();
        for(BooksEntity books : listToGetPopBook){
            if(getMaxBookId==books.getId()){
                return new Books(books.getId(), books.getName(),books.getWriter(),books.getSummary(),books.getCategory());
            }
        }
        return null;
    }

    public User userWithMostBooks(){
        Iterable<UserBookHistoryEntity> listForMax = userBookHistoryDetails.findAll();
        Map<Long, Integer> map = new HashMap<>();
        for(UserBookHistoryEntity user1: listForMax){
            map.put(user1.getUserId(), map.getOrDefault(user1.getUserId(), 0) + 1);
        }

        int maxId = 0;
        Long getMaxUserId = 0L;
        for(Long Userid : map.keySet()){
            if(map.get(Userid) > maxId){
                maxId = map.get(Userid);
                getMaxUserId = Userid;
            }
        }

        Iterable<UserEntity> listToGetPopBook = userRepo.findAll();
        for(UserEntity users : listToGetPopBook){
            if(getMaxUserId==users.getId()){
                return new User(users.getId(),users.getName(),users.getAddress(),users.getPhoneNumber());
            }
        }

        return null;
    }
}

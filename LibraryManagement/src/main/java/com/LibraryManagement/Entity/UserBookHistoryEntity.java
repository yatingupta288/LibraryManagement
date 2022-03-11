package com.LibraryManagement.Entity;

import javax.persistence.*;

//@ManyToOne


@Entity
@Table(name = "history")
public class UserBookHistoryEntity {

    @Id
//    @Column(name="id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UserId;
    private Long bookid;
    private String startdate;
    private String enddate;

    public UserBookHistoryEntity(Long userId, Long bookid, String startdate, String enddate) {
        UserId = userId;
        this.bookid = bookid;
        this.startdate = startdate;
        this.enddate = enddate;
    }

    public UserBookHistoryEntity() {
    }

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        this.UserId = userId;
    }

    public Long getBookid() {
        return bookid;
    }

    public void setBookid(Long bookid) {
        this.bookid = bookid;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }
}

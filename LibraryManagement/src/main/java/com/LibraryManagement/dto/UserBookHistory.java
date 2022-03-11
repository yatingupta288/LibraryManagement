package com.LibraryManagement.dto;

public class UserBookHistory {
    private Long UserId;
    private Long bookid;
    private String startdate;
    private String enddate;

    public UserBookHistory(Long userId, Long bookid, String startdate, String enddate) {
        UserId = userId;
        this.bookid = bookid;
        this.startdate = startdate;
        this.enddate = enddate;
    }

    public UserBookHistory() {
    }

    public Long getUserId() {
        return UserId;
    }

    public void setUserId(Long userId) {
        UserId = userId;
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

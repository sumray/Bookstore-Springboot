package com.zq.bookstore.book.pojo;

import java.util.Date;

public class BookComment {
    private String commentId;

    private String mainUserid;

    private String secondUserid;

    private String commentContent;

    private Date commentTime;

    private String bid;

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId == null ? null : commentId.trim();
    }

    public String getMainUserid() {
        return mainUserid;
    }

    public void setMainUserid(String mainUserid) {
        this.mainUserid = mainUserid == null ? null : mainUserid.trim();
    }

    public String getSecondUserid() {
        return secondUserid;
    }

    public void setSecondUserid(String secondUserid) {
        this.secondUserid = secondUserid == null ? null : secondUserid.trim();
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid == null ? null : bid.trim();
    }
}
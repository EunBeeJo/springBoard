package com.github.bee.board.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Board {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long seq;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String writer;

    private int hits;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private String content;

    public Board() {
        hits = 0;
    }


    // getter setter

    public Long getSeq() {
        return seq;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

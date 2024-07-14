package com.example.demo.dto;

public class BookDto {

    private Long bookId;

    private String title;

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "BookDto[" +
                "bookId='" + bookId +
                "', title='" + title + "']";
    }
}

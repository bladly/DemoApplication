package com.example.demo.vm;

public class BookVM {

    private String title;
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "BookVM[" +
                "title='" + title + "']";
    }
}

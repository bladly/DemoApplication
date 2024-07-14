package com.example.demo.vm;

public class PageVM {

    private Integer page;

    private Integer size;

    public Integer getPage() {
        return page == null ? 0 : page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size == null ? 10 : size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "PageVM[" +
                "page='" + page +
                "', size='" + size + "']";
    }
}

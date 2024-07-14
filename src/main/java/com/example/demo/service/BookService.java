package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookDAO;

@Service
public class BookService {

    @Autowired
    private BookDAO bookDAO;

    @Transactional
    public Book findById(Long bookId) {
        return bookDAO.findById(bookId).orElse(null);
    }

    public List<Book> findAll(int page, int size) {
        return bookDAO.findAll(PageRequest.of(page, size)).getContent();
    }

    @Transactional
    public Book save(Book book) {
        return bookDAO.save(book);
    }
}
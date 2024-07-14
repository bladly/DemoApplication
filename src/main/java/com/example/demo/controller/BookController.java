package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BookDto;
import com.example.demo.entity.Book;
import com.example.demo.mapper.BookMapper;
import com.example.demo.service.BookService;
import com.example.demo.vm.BookVM;
import com.example.demo.vm.PageVM;
import com.example.demo.webclient.DemoThirdPartyAPIService;

@RestController
@RequestMapping("/books")
public class BookController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private DemoThirdPartyAPIService demoThirdPartyAPIService;

    @GetMapping("/test-api")
    public ResponseEntity<?> testThirdPartyCall() {
        logger.info("[START] testThirdPartyCall");
        String result = demoThirdPartyAPIService.getPosts();
        logger.info("[END] testThirdPartyCall: response {}", result);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<?> findById(@PathVariable("bookId") Long bookId) {
        logger.info("[START] findById: bookId {}", bookId);

        Book book = bookService.findById(bookId);
        if (book == null) {
            return badRequest("Invalid Book ID");
        }
        BookDto dto = bookMapper.toDto(book);

        logger.info("[END] findById: response {}", dto);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping
    public ResponseEntity<?> findAll(@RequestBody PageVM vm) {
        logger.info("[START] findAll: request {}", vm);

        if (vm.getPage() < 0) {
            return badRequest("Page number must be greater than or equal to zero");
        } else if (vm.getSize() < 1) {
            return badRequest("Page size must be greater than zero");
        }
        List<Book> books = bookService.findAll(vm.getPage(), vm.getSize());
        List<BookDto> booksDto = bookMapper.toDtoList(books);

        logger.info("[END] findAll: response {}", booksDto);
        return ResponseEntity.ok().body(booksDto);
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody BookVM vm) {
        logger.info("[START] insert: request {}", vm);

        if (vm.getTitle() == null || vm.getTitle().isBlank()) {
            return badRequest("Book Title is required");
        }
        Book book = bookMapper.toEntity(vm);
        book = bookService.save(book);
        BookDto dto = bookMapper.toDto(book);

        logger.info("[END] insert: response {}", dto);
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<?> update(@PathVariable("bookId") Long bookId, @RequestBody BookVM vm) {
        logger.info("[START] update: request {}", vm);

        if (vm.getTitle() == null || vm.getTitle().isBlank()) {
            return badRequest("Book Title is required");
        }
        Book book = bookService.findById(bookId);
        if (book == null) {
            return badRequest("Invalid Book ID");
        }
        bookMapper.toEntity(vm, book);
        book = bookService.save(book);
        BookDto dto = bookMapper.toDto(book);

        logger.info("[END] update: response {}", dto);
        return ResponseEntity.ok().body(dto);
    }

}

package com.zyh.controller;

import com.zyh.entity.Book;
import com.zyh.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public boolean save(@RequestBody Book book){
        boolean save = bookService.save(book);
        return save;
    }

    @PutMapping
    public boolean update(@RequestBody Book book){
        boolean update = bookService.update(book);
        return update;
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable Integer id){
        boolean delete = bookService.delete(id);
        return delete;
    }

    @GetMapping("{id}")
    public Book get(@PathVariable Integer id){
        Book byId = bookService.getById(id);
        return byId;
    }

    @GetMapping
    public List<Book> getAll(){
        List<Book> all = bookService.getAll();
        return all;
    }
}

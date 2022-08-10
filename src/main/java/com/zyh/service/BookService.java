package com.zyh.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zyh.entity.Book;

import java.util.List;

public interface BookService {
    boolean save(Book book);
    Book getById(Integer id);
    boolean update(Book book);
    boolean delete(Integer id);
    List<Book> getAll();
}

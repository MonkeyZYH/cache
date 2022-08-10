package com.zyh.service.Impl;

import com.zyh.entity.Book;
import com.zyh.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
@Service
public class BookService implements com.zyh.service.BookService {

    @Autowired
    private BookMapper bookMapper;

    private HashMap<Integer,Book> cache=new HashMap<Integer,Book>();

    @Override
    public Book getById(Integer id) {
        //如果当前缓存中没有本次要查询的数据，则进行查询，否则直接从缓存中获取数据返回
        Book book = cache.get(id);
        if (book==null){
            Book selectById = bookMapper.selectById(id);
            cache.put(id,selectById);
            return selectById;
        }
        return cache.get(id);
    }

    @Override
    public boolean save(Book book) {
        int insert = bookMapper.insert(book);
        if (insert>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean update(Book book) {
        int updateById = bookMapper.updateById(book);
        if (updateById>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean delete(Integer id) {
        int deleteById = bookMapper.deleteById(id);
        if (deleteById>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Book> getAll() {
        List<Book> selectList = bookMapper.selectList(null);
        return selectList;
    }
}

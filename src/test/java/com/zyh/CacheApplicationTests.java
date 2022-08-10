package com.zyh;

import com.zyh.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CacheApplicationTests {

    @Autowired
    private BookService bookService;
    @Test
    void contextLoads() {
        System.out.println(bookService.getById(1));
    }


}

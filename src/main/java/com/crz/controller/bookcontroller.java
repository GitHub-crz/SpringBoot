package com.crz.controller;

import com.crz.mapper.BookMapper;
import com.crz.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@Controller
public class bookcontroller {
    @Autowired
    private BookMapper bookMapper;

    @RequestMapping("/bookshow")
    String booklist(Model model,String username,String password){
        List<Book> bookList=bookMapper.queryAllBook();
        System.out.println(bookList);
        model.addAttribute("list",bookList);
        return "booklist";
    }

}

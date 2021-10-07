package com.crz.controller;

import com.crz.mapper.BookMapper;
import com.crz.mapper.UserMapper;
import com.crz.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@Controller
public class logincontroller {
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/login")
    public String login(Model model, String username, String password, HttpSession httpSession){
        if(!Objects.equals(password, userMapper.verify(username))){
            model.addAttribute("msg","password error!!!");
            System.out.println("密码错误");
            return "index";
        }
        else{
            httpSession.setAttribute("loginUser",username);
            List<Book> bookList=bookMapper.queryAllBook();
            System.out.println(bookList);
            model.addAttribute("list",bookList);
            return "booklist";
        }

    }
}

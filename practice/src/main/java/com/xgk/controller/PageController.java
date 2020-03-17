package com.xgk.controller;

import com.xgk.domain.Bill;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author CLAY
 * @version 1.1
 * @data 2020/3/6 16:15
 */
@Controller
@RequestMapping("/page")
public class PageController {

    @RequestMapping("/login")
    public String toLogin(){
        return "login";
    }
}

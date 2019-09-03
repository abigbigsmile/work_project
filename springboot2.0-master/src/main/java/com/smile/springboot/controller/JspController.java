package com.smile.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspController {

    @RequestMapping("/jspHello")
    public String jspHello(){
        return "hello";
    }
}

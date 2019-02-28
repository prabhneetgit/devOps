package com.example.devops.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @RequestMapping("/")
    public String welcome(Model model){
        model.addAttribute("course","DevOps");
        return "index";
    }
}

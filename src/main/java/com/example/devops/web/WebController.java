package com.example.devops.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/")
    public String welcome(Model model) {
        logger.info("Processing index request");
        model.addAttribute("course", "DevOps");
        return "index";
    }
}

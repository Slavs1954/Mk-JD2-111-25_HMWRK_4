package by.it_academy.jd2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexServlet {

    @GetMapping(path = {"/", ""})
    public String redirect() {
        return "redirect:/ui/index";
    }

    @GetMapping("/ui/index")
    public String showIndex() {
        return "index";
    }
}

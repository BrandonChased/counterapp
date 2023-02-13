package com.brandon.counterapp.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String index(HttpSession session) {
        if (session.getAttribute("count") == null) {
            session.setAttribute("count", 0);
        } else {
            // increment the count by 1 using getAttribute and setAttribute
            session.setAttribute("count", (int) session.getAttribute("count") + 1);
        }

        return "index.jsp";
    }

    @RequestMapping("/counter")
    public String showCount(HttpSession session, Model model) {
        Integer currentCount = (Integer) session.getAttribute("count");
        model.addAttribute("countToShow", currentCount);
        return "showCount.jsp";
    }

}

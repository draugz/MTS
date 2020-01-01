package com.start.mts.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminPageController {
    @RequestMapping(value = "/adminPage", method = RequestMethod.GET)
    public String records(Model model) {
        return "adminPage";
    }
}

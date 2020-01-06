package com.start.mts.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StaticDataController {
    @RequestMapping(value = "/staticData", method = RequestMethod.GET)
    public String get(Model model) {
        return "staticData";
    }
}

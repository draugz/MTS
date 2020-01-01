package com.start.mts.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NewRecordController {
    @RequestMapping(value = "/newRecord", method = RequestMethod.POST)
    public String addNEwRecord(Model model,
                               @RequestParam(value = "env", required = true) String env,
                               @RequestParam(value = "name", required = true) String name,
                               @RequestParam(value = "ticketNumber", required = true) String ticketNumber,
                               @RequestParam(value = "type", required = true) String type,
                               @RequestParam(value = "object", required = true) String object,
                               @RequestParam(value = "action", required = true) String action) {
        model.addAttribute("success", true);
        return "addNewRecord";
    }

    @RequestMapping(value = "/newRecord", method = RequestMethod.GET)
    public String addNEwRecord(Model model) {
        return "addNewRecord";
    }
}

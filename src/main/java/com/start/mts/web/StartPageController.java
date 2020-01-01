package com.start.mts.web;

import com.start.mts.db.RecordRepository;
import com.start.mts.domain.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StartPageController {

    @Autowired
    RecordRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getRecords(@RequestParam(required = false, defaultValue = "") String filter1,
                             @RequestParam(required = false, defaultValue = "") String filter2,
                             Model model) {

        List<Record> records;
        if (filter1 != null && !filter1.isEmpty()) {
            records = repository.findByTicketNumber(filter1);
        } else if (filter2 != null && !filter2.isEmpty()) {
            records = repository.findByObjectName(filter2);
        } else {
            records = repository.findAll();
        }
        model.addAttribute("filter1", filter1);
        model.addAttribute("filter2", filter2);
        model.addAttribute("records", records);
        return "startPage";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String addNewRecord(Model model,
                               @RequestParam(value = "env", required = true) String env,
                               @RequestParam(value = "name", required = true) String name,
                               @RequestParam(value = "ticketNumber", required = true) String ticketNumber,
                               @RequestParam(value = "type", required = true) String type,
                               @RequestParam(value = "object", required = true) String object,
                               @RequestParam(value = "action", required = true) String action) {
        model.addAttribute("success", true);
        return "addNewRecord";
    }
}

package com.start.mts.web;

import com.start.mts.db.RecordRepository;
import com.start.mts.RecordService;
import com.start.mts.domain.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class StartPageController {

    @Autowired
    RecordService recordService;

    @Autowired
    RecordRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAllRecords(Model model) {
        List<Record> records = repository.findAll();
        model.addAttribute("records", records);
        return "startPage";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String getRecordsByFilters(Model model, @RequestParam(value = "ticketNumber", required = false) String ticketNumber) {
        return "startPage";
    }

}

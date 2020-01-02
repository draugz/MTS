package com.start.mts.web;

import com.start.mts.RecordService;
import com.start.mts.db.RecordRepository;
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
    RecordService service;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getRecords(@RequestParam(required = false) String filterTicketId,
                             @RequestParam(required = false) String filterObjectType,
                             @RequestParam(required = false) String filterObjectName,
                             @RequestParam(required = false) String filterName,
                             @RequestParam(required = false) String filterRefEnv,
                             Model model) {

        List<Record> records = service.findByCriteria(filterTicketId,
                filterObjectType,
                filterObjectName,
                filterName,
                filterRefEnv);
        model.addAttribute("records", records);
        return "startPage";
    }

//TODO
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

package com.start.mts.web;

import com.start.mts.RecordService;
import com.start.mts.db.RecordRepository;
import com.start.mts.domain.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class StartPageController {
    @Autowired
    RecordService service;
    @Autowired
    RecordRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getRecords(@RequestParam(required = false) String filterTicketId,
                             @RequestParam(required = false) String filterObjectType,
                             @RequestParam(required = false) String filterObjectName,
                             @RequestParam(required = false) String filterName,
                             @RequestParam(required = false) String filterRefEnv,
                             Model model) {
        List<String> existingTickets = service.getExistingTicketNumbers();
        model.addAttribute("existingTickets", existingTickets);

        List<String> validObjectTypes = service.getObjectTypes();
        model.addAttribute("validObjectTypes", validObjectTypes);

        Actions[] actions = Actions.values();
        model.addAttribute("actions", actions);

        List<String> referenceEnvs = service.getReferenceEnvironments();
        model.addAttribute("referenceEnvs", referenceEnvs);

        List<String> names = service.getNames();
        model.addAttribute("names", names);


//TODO filterObjectName find LIKE
        List<Record> records = service.findByCriteria(filterTicketId,
                filterObjectType,
                filterObjectName,
                filterName,
                filterRefEnv);
        model.addAttribute("records", records);
        return "startPage";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String addNewRecord(Model model,
                               @RequestParam(value = "refEnv", required = true) String refEnv,
                               @RequestParam(value = "name", required = true) String name,
                               @RequestParam(value = "ticketNumber", required = true) String ticketNumber,
                               @RequestParam(value = "objectType", required = true) String objectTypeStr,
                               @RequestParam(value = "objectName", required = true) String objectName,
                               @RequestParam(value = "action", required = true) String action) {

        model.addAttribute("success", false);
        if (StringUtils.isEmpty(ticketNumber) || StringUtils.isEmpty(objectName)){
            String error = "all fields must be filled";
            model.addAttribute("error", error);
            return "startPage";
        }
        if (action.contains(",")){
            action = action.replace(",", "");
        }

        Record record = new Record(name, refEnv, ticketNumber.toUpperCase(), objectTypeStr, objectName, action, null);
        Record recordSaved = repository.save(record);
        if (recordSaved.getRecordId() != 0) {
            model.addAttribute("success", true);
        }

        return "startPage";
    }


}

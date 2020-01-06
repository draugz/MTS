package com.start.mts.web;

import com.start.mts.RecordService;
import com.start.mts.db.EnvDeployRepository;
import com.start.mts.db.RecordRepository;
import com.start.mts.domain.Actions;
import com.start.mts.domain.EnvDeploy;
import com.start.mts.domain.Record;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Controller
public class AdminPageController {
    @Autowired
    RecordService service;
    @Autowired
    EnvDeployRepository envDeployRepository;
    @Autowired
    RecordRepository repository;

    @RequestMapping(value = "/adminPage", method = RequestMethod.GET)
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

        List<String> envs = service.getAllEnvironments();
        model.addAttribute("envs", envs);

        List<String> referenceEnvs = service.getReferenceEnvironments();
        model.addAttribute("referenceEnvs", referenceEnvs);

        List<String> names = service.getNames();
        model.addAttribute("names", names);

        List<Record> records = service.findByCriteria(filterTicketId,
                filterObjectType,
                filterObjectName,
                filterName,
                filterRefEnv);

        model.addAttribute("records", records);
        return "adminPage";
    }

    @RequestMapping(value = "/adminPage", method = RequestMethod.POST)
    public String addNewDeploy(Model model,
                               @RequestParam(value = "env", required = true) String env,
                               @RequestParam(value = "ticketNumber", required = true) String ticketNumber,
                               @RequestParam(value = "date", required = false) String dateStr) {

        if (StringUtils.isEmpty(env) || StringUtils.isEmpty(ticketNumber)) {
            model.addAttribute("error", "Missing field values");
            model.addAttribute("success", false);
            return "adminPage";
        }

        Date date;
        try {
            date = getDate(dateStr);
        } catch (ParseException e) {
            model.addAttribute("error", "Error parsing date");
            model.addAttribute("success", false);
            e.printStackTrace();
            return "adminPage";
        }

        List<Record> existingRecords = repository.findByTicketNumber(ticketNumber.toUpperCase());

        try {
            deployAll(env, date, existingRecords);
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("success", false);
        }

        model.addAttribute("success", true);
        return "adminPage";
    }

    private void deployAll(String env, Date date, List<Record> existingRecords) throws Exception {
        for (Record record : existingRecords) {
            EnvDeploy deploy = new EnvDeploy(env, date, record);
            addToRecordAndSave(record, deploy);
        }
    }

    private void addToRecordAndSave(Record record, EnvDeploy deploy) throws Exception {
        List<EnvDeploy> list = record.getEnvs();
        list.add(deploy);
        record.setEnvs(list);
        save(deploy);
    }

    private Date getDate(@RequestParam(value = "date", required = false) String dateStr) throws ParseException {
        Date date;
        if (StringUtils.isEmpty(dateStr)) {
            date = new Date();
        } else {
            date = DateFormat.getInstance().parse(dateStr);
        }
        return date;
    }

    private void save(EnvDeploy deploy) throws Exception {
        EnvDeploy saved = envDeployRepository.save(deploy);
        if (saved.getId() == 0) {
            throw new Exception("error saving deploy");
        }
    }

}

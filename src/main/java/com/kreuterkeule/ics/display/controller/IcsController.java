package com.kreuterkeule.ics.display.controller;

import com.kreuterkeule.ics.display.service.IcsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/ics")
@CrossOrigin("*")
public class IcsController {

    @Autowired
    IcsService icsService;

    @Autowired
    Environment env;

    @GetMapping("getIcs")
    public String getIcs() {
        try {
            return icsService.downloadIcs(env.getProperty("ics.url"));
        } catch (IOException e) {
            e.printStackTrace();
            return "[ERROR] failed downloading ics";
        }
    }

}

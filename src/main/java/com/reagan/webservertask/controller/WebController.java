package com.reagan.webservertask.controller;

import com.reagan.webservertask.service.CalcServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {


    @GetMapping(path = "get", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getJson(@RequestBody CalcServiceImpl calcService) {
        return calcService.getRESPONSE();
    }

    @PostMapping(path = "post", consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public String postOperation(@RequestBody CalcServiceImpl calcService) {
        return calcService.getJSON_RESPONSE_STARTING() + calcService.getSLACK_USERNAME() + calcService.getRESULT_STRING()
                + calcService.getResult() + calcService.getOPERATION_TYPE_STRING()
                + calcService.getOperation_type().toLowerCase() +  "\n" + calcService.getJSON_RESPONSE_ENDING();
    }

}

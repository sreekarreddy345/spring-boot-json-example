package com.jsonexample.controller;


import com.jsonexample.service.AsyncService;
import com.jsonexample.service.JsonService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/home")
public class JsonController {

    @Autowired
    @Qualifier("jsonserviceclass")
    private JsonService jsonService;


    @Autowired
    private AsyncService asyncService;

    @Value("${spring.message}")
    private String message;

    @RequestMapping(value = {"/", "getJsonString"}, method = RequestMethod.GET)
    public JSONArray getJson() {
        return jsonService.readJson();
    }

    @PostMapping(value = "/addJson", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addJson(@RequestBody JSONObject empObj) {
        JSONArray jsonArray = jsonService.readJson();
        return jsonService.writeJsonService(empObj, jsonArray);
    }

    @RequestMapping(value = "/async", method = RequestMethod.GET)
    public String callAsyncMethod() {
        asyncService.asyncMethod();
        return "method called";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String getProfileValue() {
        return message;
    }
}

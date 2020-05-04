package com.jsonexample.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.UUID;

@Component
@Lazy
@SuppressWarnings("unchecked")
@Qualifier("jsonserviceclass")
public class JsonService {

    public JSONArray readJson() {
        JSONArray employeeList = null;
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("./src/main/resources/json/file.json")) {
            Object obj = jsonParser.parse(reader);
            employeeList = (JSONArray) obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    public String writeJsonService(JSONObject empObj, JSONArray jsonArray) {
        JSONObject employeeObject1 = new JSONObject();
        employeeObject1.put("employee", empObj);
        jsonArray.add(employeeObject1);
        String random = "";
        boolean isJsonWrittenToFile = writeJsonIntoFile(jsonArray);
        if (isJsonWrittenToFile) {
            random = UUID.randomUUID().toString().replace("-", "");
        } else {
            random = "JSON not written into the file";
        }
        return random;
    }

    public boolean writeJsonIntoFile(JSONArray jsonArrayList) {
        boolean isFileWrittenSuccessful = false;
        try {
            FileWriter fileWriter = new FileWriter("./src/main/resources/json/file.json");
            fileWriter.write(jsonArrayList.toJSONString());
            fileWriter.flush();
            isFileWrittenSuccessful = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isFileWrittenSuccessful;
    }

}

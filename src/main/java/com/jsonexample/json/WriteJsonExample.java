package com.jsonexample.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;

@SuppressWarnings("unchecked")
public class WriteJsonExample {
    public static void main(String[] args) {

        JSONObject employeeDetails = new JSONObject();
        JSONObject employeeObject = new JSONObject();

        employeeDetails.put("firstName", "sreekar");
        employeeDetails.put("age", 25);
        employeeDetails.put("website", "sreekar.com");
        employeeObject.put("employee", employeeDetails);

        JSONObject employeeDetails1 = new JSONObject();
        employeeDetails1.put("firstName", "prathyusha");
        employeeDetails1.put("age", 25);
        employeeDetails1.put("website", "prathyusha.com");

        JSONObject employeeObject1 = new JSONObject();
        employeeObject1.put("employee", employeeDetails1);

        JSONArray jsonArrayList = new JSONArray();
        jsonArrayList.add(employeeObject);
        jsonArrayList.add(employeeObject1);

        try {
            FileWriter fileWriter = new FileWriter("./src/main/resources/json/file.json");
            fileWriter.write(jsonArrayList.toJSONString());
            fileWriter.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}


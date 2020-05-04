/*
package com.jsonexample.json;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.List;

public class ReadJSONExample {
    public static void main(String[] args) {
        List<?> json = getJson();
//        System.out.println(json);

    }

    public static List<?> getJson() {

        JSONParser jsonParser = new JSONParser();
        JSONArray employeeList = null;
        try (FileReader reader = new FileReader("./src/main/resources/json/file.json")) {
            Object obj = jsonParser.parse(reader);
            employeeList = (JSONArray) obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeList;
    }
}
*/

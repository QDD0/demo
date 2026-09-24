package org.example.Task3;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import java.util.List;
import java.util.Scanner;

class Tests {
    public Integer id;
    public String title;
    public String value;
    public List<Tests> values;

    public List<Tests> getValues() {
        return values;
    }
}

class Values {
    public Integer id;
    public String value;
}

class Response {
    public List<Values> values;
    public List<Tests> tests;
}

public class Task3 {
    public static void main(String[] args) {
        Gson g = new Gson();

        Scanner inputValues = new Scanner(System.in);
        System.out.print("values.json = ");
        String readPathValues = inputValues.nextLine();

        Scanner inputTests = new Scanner(System.in);
        System.out.print("tests.json = ");
        String readPathTests = inputTests.nextLine();

        Scanner inputReport = new Scanner(System.in);
        System.out.print("report.json = ");
        String readPathReport = inputReport.nextLine();

        try (FileReader reader = new FileReader(readPathValues);
             FileReader readerTest = new FileReader(readPathTests)) {
            Response response = g.fromJson(reader, Response.class);
            Response responseTest = g.fromJson(readerTest, Response.class);

            Map<Integer, String> mapValues = new HashMap<>();
            for (Values v : response.values) {
                mapValues.put(v.id, v.value);
            }

            for (Tests t : responseTest.tests) {
                if (mapValues.containsKey(t.id)) {
                    t.value = mapValues.get(t.id);
                }

                if (t.values != null) {
                    t.value = mapValues.get(t.values);
                }
            }

            try (FileWriter fileWriter = new FileWriter(readPathReport)) {
                g.toJson(responseTest, fileWriter);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

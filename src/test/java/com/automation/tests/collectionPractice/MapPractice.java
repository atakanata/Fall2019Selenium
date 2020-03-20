package com.automation.tests.collectionPractice;

import java.util.HashMap;
import java.util.Map;

public class MapPractice {
    public static void main(String[] args) {

        Map<String, String> nameStatePair = new HashMap<>(); // LinkedHashMap for keeping insertion order
        nameStatePair.put("Fatih", "FL");
        nameStatePair.put("Vlad", "SC");
        nameStatePair.put("Hasan", "NY");
        nameStatePair.put("Abdullo", "NY");
        nameStatePair.put("Atakan", "GA");
        System.out.println("nameStatePair = " + nameStatePair);
    }
}

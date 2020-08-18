package javacolectionframework.thuc_hanh;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestMap {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Smith", 30);
        hashMap.put("Anderson", 31);
        hashMap.put("Lewis", 28);
        hashMap.put("Cook", 29);
        System.out.println("Display entries in HashMap");
        System.out.println(hashMap + "\n");


        Map<String, Integer> treeMap = new TreeMap<>();
        System.out.println("Display entries in ascending order of key");
        treeMap.put("Smith", 30);
        treeMap.put("Anderson", 30);
        treeMap.put("Lewis", 29);
        treeMap.put("Cook", 29);
        System.out.println(treeMap);

        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Smith", 30);
        linkedHashMap.put("Anderson", 31);
        linkedHashMap.put("Lewis", 29);
        linkedHashMap.put("Cook", 29);
//        System.out.println("\nThe age for " + "Lewis is " + linkedHashMap.get("Lewis"));
//        System.out.println("\nThe age for " + "Smith " + linkedHashMap.get("Smith"));
        System.out.println("-------------------");
        System.out.println(linkedHashMap);

    }
}

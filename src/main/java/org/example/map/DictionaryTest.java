package org.example.map;

public class DictionaryTest {
    public static void main(String[] args) {
        var dict = new Dictionary<String, String>();
        System.out.println(dict.put("java", "Java"));
        System.out.println(dict.put("go", "Go"));
        System.out.println(dict.put("go", "GoGo"));
    }
}

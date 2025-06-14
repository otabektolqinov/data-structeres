package org.example.map;

public class SimpleDictionaryTest {
    public static void main(String[] args) {
        var dict = new SimpleDictionary<String, String>();

        dict.put("cat", "mushuk");
        dict.put("dog", "kuchuk");
        dict.put("hello", "salom");

        System.out.println(dict);

        System.out.println(dict.get("cat"));
    }
}

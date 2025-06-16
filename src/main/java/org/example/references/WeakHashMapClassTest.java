package org.example.references;

import java.util.WeakHashMap;

public class WeakHashMapClassTest {
    public static void main(String[] args) {
        var whm = new WeakHashMap<String, String>();
        String key = new String("1");
        whm.put(key, "Java");
        whm.put("2", "Groovy");
        whm.put("3", "Scala");
        key = null;
        System.gc();
        whm.forEach((k, v)-> System.out.println(k + "=" + v));
    }
}

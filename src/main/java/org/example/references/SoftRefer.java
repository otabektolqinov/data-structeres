package org.example.references;

import java.lang.ref.SoftReference;

public class SoftRefer {
    public static void main(String[] args) {

        String language = "english";
        String name = "a";
        SoftReference<String> softReference = new SoftReference<>(language);

        language = null;

        System.gc();

        String s = softReference.get();
        System.out.println(s);
    }
}

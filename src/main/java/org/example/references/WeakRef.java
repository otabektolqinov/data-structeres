package org.example.references;

import java.lang.ref.WeakReference;

public class WeakRef {
    public static void main(String[] args) {
        String language = "russian";
        WeakReference<String> weakReference = new WeakReference<>(language);
        language = null;
        System.gc();
        String s = weakReference.get();
        System.out.println(s);
    }
}

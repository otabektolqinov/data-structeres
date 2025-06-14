package org.example.queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        var patients = new PriorityQueue<Patient>(Comparator.comparingInt(Patient::getPriority).reversed());

        patients.add(new Patient("John Nou", 2));
        patients.add(new Patient("Loi pku", 3));
        patients.add(new Patient("Loi pku", 5));

        System.out.println(patients);
        System.out.println(patients.poll());

    }
}

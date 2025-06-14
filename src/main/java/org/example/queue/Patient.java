package org.example.queue;

public class Patient{

    private String fullName;
    private int priority;

    public Patient(String fullName, int priority) {
        this.fullName = fullName;
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    /*@Override
    public int compareTo(Patient o) {
        return Integer.compare(priority, o.priority) * -1;
    }*/

    @Override
    public String toString() {
        return "Patient{" +
                "fullName='" + fullName + '\'' +
                ", priority=" + priority +
                '}';
    }
}

package org.example.set.equalsandhashcode;

public class VOFR {
    int number;

    public VOFR(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object obj) {
        var o = (VOFR) obj;

        return this.number > o.number;
    }

    public static void main(String[] args) {
        var o1 = new VOFR(1);

    }
}

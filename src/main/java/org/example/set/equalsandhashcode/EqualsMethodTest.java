package org.example.set.equalsandhashcode;

public class EqualsMethodTest {
    public static void main(String[] args) {
        /*var card1 = new Card("2233665588897744", "01/29");
        var card2 = new Card("2233665588897744", "01/29");
        System.out.println(card1.equals(card2));*/

        A a = new A();
        B b = new B();

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());

        /*System.out.println(a.equals(b));
        System.out.println(b.equals(a));*/
    }
}

class A{
    int i;

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof A o)){
            return false;
        }
        return this.i == o.i;
    }
}

class B extends A{
    int j;

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }

        if (!(obj instanceof B o)){
            return false;
        }

        return this.j == o.j && this.i == o.i;
    }
}
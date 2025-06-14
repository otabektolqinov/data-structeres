package org.example.set.equalsandhashcode;

import java.util.HashSet;
import java.util.Set;

public class HashCodeMethodTest {
    public static void main(String[] args) {
        var card1 = new Card("2233665588897744", "01/29", 2);
        var card2 = new Card("2233665588897744", "01/29", 5);

        Set<Card> cardSet = new HashSet<>();
        cardSet.add(card1);
        cardSet.add(card2);

        System.out.println(cardSet);
    }
}

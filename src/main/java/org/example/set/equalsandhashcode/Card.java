package org.example.set.equalsandhashcode;

import java.util.Objects;

public class Card {

    private String cardNumber;
    private String cardExpiry;
    private int field;

    public Card(String cardNumber, String cardExpiry, int field) {
        this.cardNumber = cardNumber;
        this.cardExpiry = cardExpiry;
        this.field = field;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Card o)){
            return false;
        }

        return o.cardExpiry.equals(this.cardExpiry) && o.cardNumber.equals(this.cardNumber);

    }

    @Override
    public int hashCode() {
        return Objects.hash(this.cardExpiry, this.cardNumber);
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardNumber='" + cardNumber + '\'' +
                ", cardExpiry='" + cardExpiry + '\'' +
                ", field=" + field +
                '}';
    }
}


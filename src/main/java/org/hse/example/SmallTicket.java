package org.hse.example;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * Билет из 4-я цифр
 */
public class SmallTicket implements MealTicket {
    private int[] ticket;
    /**
     * @param ticket номер билета в виде целого числа
     */
    public SmallTicket(long ticket) {
        this.ticket = new int[]{0, 0, 0, 0};
        int j = 3;
        while (ticket > 0) {
            this.ticket[j] = (int) ticket % 10;
            ticket = ticket / 10;
            j--;
        }
    }

    @Override
    public boolean isMealTicket() {
        int firstSum = ticket[0] + ticket[1];
        int lastSum = ticket[2] + ticket[3];
        return firstSum == lastSum;
    }

    @Override
    public Long getOrdinal() {
        long multiplicator = 1L;
        long ordinal = 0L;
        for(int j = ticket.length - 1; j >= 0; j--){
            ordinal += ticket[j] * multiplicator;
            multiplicator *= 10;
        }
        return ordinal;
    }

    @Override
    public boolean accept(Predicate<HasOrdinal> visitor) {
        return visitor.test(this);
    }

    @Override
    public String toString() {
        return "SmallTicket{" + Arrays.toString(ticket) + "}";
    }
}

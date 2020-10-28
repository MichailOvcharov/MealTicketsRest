package org.hse.example;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * Класс для моделирования билета
 */
@Component
@Scope("prototype")
public class Ticket implements MealTicket {
    //todo сделать из класса бин со скоупом prototype
    private int[] ticket;

    /**
     * @param ticket номер билета в виде целого числа
     */
    public Ticket(long ticket) {
        if (ticket < 0) {
            throw new IllegalArgumentException("Попытка создать билет с отрицательным номером!");
        }
        if (ticket >= 1000000) {
            throw new IllegalArgumentException("Номер билета состоит более, чем из 6-ти цифр!");
        }

        this.ticket = new int[]{0, 0, 0, 0, 0, 0};
        int j = 5;
        while (ticket > 0) {
            this.ticket[j] = (int) ticket % 10;
            ticket = ticket / 10;
            j--;
        }
    }

    /**
     * @return true, если билет счастливый
     */
    @Override
    public boolean isMealTicket() {
        int firstSum = ticket[0] + ticket[1] + ticket[2];
        int lastSum = ticket[3] + ticket[4] + ticket[5];

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
        return "Ticket{" + Arrays.toString(ticket) + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ticket thatTicket = (Ticket) o;
        return Arrays.equals(ticket, thatTicket.ticket);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(ticket);
    }
}

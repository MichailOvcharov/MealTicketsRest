package org.hse.example;

import java.util.Iterator;

/**
 * Выводит в консоль счастливые билеты, кратные пяти, и их количество
 */
public class MultipleOfFiveMealTicketCounter extends MealTicketCounter {

    public MultipleOfFiveMealTicketCounter(Iterator<MealTicket> ticketIterator) {
        super(ticketIterator);
    }

    /**
     * @param ticket обрабатываемый билет
     * @return возвращает true, если номер обрабатываемого билета кратен пяти, иначе false
     */
    @Override
    protected boolean doFilter(MealTicket ticket) {
        return ticket.accept(hasOrdinal -> hasOrdinal.getOrdinal() % 5 == 0);
    }

}

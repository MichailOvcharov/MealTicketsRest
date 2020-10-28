package org.hse.example;

import java.util.Iterator;

/**
 * Выводит в консоль чётные счастливые билеты и их количество
 */
public class EvenMealTicketCounter extends MealTicketCounter {

    public EvenMealTicketCounter(Iterator<MealTicket> ticketIterator) {
        super(ticketIterator);
    }

    /**
     * @param ticket обрабатываемый билет
     * @return true, если номер билета - чётное число, иначе false
     */
    @Override
    protected boolean doFilter(MealTicket ticket) {
        return ticket.accept(hasOrdinal -> hasOrdinal.getOrdinal() % 2 == 0);
    }
}

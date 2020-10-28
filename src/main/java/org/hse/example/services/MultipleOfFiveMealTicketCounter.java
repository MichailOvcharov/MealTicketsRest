package org.hse.example.services;


import org.hse.example.MealTicket;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Iterator;

/**
 * Сервис для работы со счастливыми билетами, кратыми пяти
 */
@Service("multipleOfFiveMeal")
public class MultipleOfFiveMealTicketCounter extends MealTicketCounter {

//    public MultipleOfFiveMealTicketCounter(Iterator<MealTicket> ticketIterator) {
//        super(ticketIterator);
//    }

    @Override
    protected boolean doFilter(MealTicket ticket) {
        return ticket.accept(hasOrdinal -> hasOrdinal.getOrdinal() % 5 == 0);
    }
}

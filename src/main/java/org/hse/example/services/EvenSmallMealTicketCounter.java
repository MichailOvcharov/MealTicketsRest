package org.hse.example.services;

import org.hse.example.MealTicket;
import org.springframework.stereotype.Service;

@Service("evenSmallMealTicketCounter")
public class EvenSmallMealTicketCounter extends SmallMealTicketCounter {

    @Override
    protected boolean doFilter(MealTicket ticket) {
        return ticket.accept(hasOrdinal -> hasOrdinal.getOrdinal() % 2 == 0);
    }
}

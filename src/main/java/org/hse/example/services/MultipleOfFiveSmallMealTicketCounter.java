package org.hse.example.services;

import org.hse.example.MealTicket;
import org.springframework.stereotype.Service;

@Service("multipleOfFiveSmallMealTicket")
public class MultipleOfFiveSmallMealTicketCounter extends SmallMealTicketCounter {

    @Override
    protected boolean doFilter(MealTicket ticket) {
        return ticket.accept(hasOrdinal -> hasOrdinal.getOrdinal() % 5 == 0);
    }
}

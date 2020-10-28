package org.hse.example.services;

import org.hse.example.MealTicket;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service("evenTicketCounter")
public class EvenMealTicketCounter extends MealTicketCounter {
//    public EvenMealTicketCounter(ApplicationContext applicationContext) {
//        super(applicationContext);
//    }
//    public EvenMealTicketCounter(Iterator<MealTicket> ticketIterator) {
//        super(ticketIterator);
//    }

    /**
     * Метод выполняет дополнительную фильтрацию билетов
     *
     * @param ticket билет
     * @return результат работы фильтра
     */
    @Override
    protected boolean doFilter(MealTicket ticket) {
        return ticket.accept(hasOrdinal -> hasOrdinal.getOrdinal() % 2 == 0);
    }
}

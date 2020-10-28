package org.hse.example;

import org.hse.example.builders.MealTicketBuilder;
import org.hse.example.builders.SmallTicketBuilder;
import org.hse.example.builders.TicketBuilder;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Iterator;

/**
 * Генератор билетов из 4-х цифр. Реализует {@link java.util.Iterator}
 */
@Service("smallTicketsGenerator")
@Primary
@Scope("prototype")
public class SmallTicketGenerator implements Iterator<MealTicket>, ApplicationContextAware {
    private long current = 0;
    private ApplicationContext applicationContext;
    /**
     * @return true, если есть билеты в текущей последовательности
     */
    @Override
    public boolean hasNext() {
        return current < 1E4;
    }

    /**
     * @return следующий билет
     */
    @Override
    public MealTicket next() {
        MealTicketBuilder ticketBilder = applicationContext.getBean("smallTicketBuilder", MealTicketBuilder.class);
        MealTicket ticket = ticketBilder.ticket(current).build();
        current++;
        return ticket;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}

package org.hse.example.services;

import org.hse.example.MealTicket;
import org.hse.example.views.TicketListView;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Supplier;
import java.util.stream.StreamSupport;

@Service("smallMealTicketListView")
public class SmallMealTicketCounter implements Supplier<TicketListView>, ApplicationContextAware  {

    private ApplicationContext applicationContext;

    protected boolean doFilter(MealTicket ticket) {
        return true;
    }

    /**
     * Выводит короткие счастливые билеты в консоль и возвращает их количество
     *
     * @return количество счастливых билетов
     */
    @Override
    public TicketListView get() {
        @SuppressWarnings("unchecked")
        Iterable<MealTicket> tickets =
                () -> (Iterator<MealTicket>) applicationContext.getBean("smallTicketsGenerator");
        Collection<String> ticketList = new ArrayList<>();
        Long count  =
                StreamSupport
                        .stream(tickets.spliterator(), false)
                        .filter(MealTicket::isMealTicket)
                        .filter(this::doFilter)
                        .map(MealTicket::toString)
                        .peek(ticketList::add)
                        .count();
        return TicketListView.builder()
                .tickets(ticketList)
                .count(count)
                .build();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}

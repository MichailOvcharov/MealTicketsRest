package org.hse.example;

import java.util.Iterator;
import java.util.function.Supplier;
import java.util.stream.StreamSupport;

/**
 * Сервис, выполняющий подсчёт счастливых билетов
 */
public class MealTicketCounter implements Supplier<Long> {
    private final Iterator<MealTicket> ticketIterator;


    public MealTicketCounter(final Iterator<MealTicket> ticketIterator) {
        this.ticketIterator = ticketIterator;
    }

    /**
     * Дополнительный фильтр для Шаблонного метода
     *
     * @param ticket обрабатываемый билет
     * @return результат работы фильтра
     */
    protected boolean doFilter(MealTicket ticket) {
        return true;
    }

    /**
     * Выводит счастливые билеты в консоль и возвращает их количество
     *
     * @return количество счастливых билетов
     */
    @Override
    public Long get() {
        Iterable<MealTicket> tickets = () -> ticketIterator;
        return StreamSupport
                    .stream(tickets.spliterator(), false)
                    .filter(MealTicket::isMealTicket)
                    .filter(this::doFilter)
                    .peek(System.out::println)
                    .count();
    }
}

package org.hse.example.builders;

import org.hse.example.MealTicket;

/**
 * Строитель экземпляров, реализующих {@link org.hse.example.MealTicket}
 */
public interface MealTicketBuilder {
    /**
     * @return {@link MealTicket}
     */
    MealTicket build();

    /**
     * Фиксирует порядковый номер билета
     *
     * @param ticket порядковый номер билета
     * @return текущий строитель
     */
    MealTicketBuilder ticket(long ticket);
}

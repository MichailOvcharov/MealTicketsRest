package org.hse.example;

/**
 * Предоставляет методя для работы со счастливыми билетами
 */
public interface MealTicket extends HasOrdinal, Visitable<HasOrdinal> {
    //todo добавить интерфейс с номером билета, интерфейс для посетителя (accept)
    /**
     * @return true, если билет счастливый
     */
    boolean isMealTicket();
}

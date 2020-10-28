package org.hse.example;

import java.util.function.Predicate;

/**
 * Интерфейс для реализации паттерна Посетитель
 */
public interface Visitable<T> {
    /**
     * Стандратный метод шаблона Посетитель
     *
     * @param visitor новая функциональность
     * @return результат вычислений
     */
    default boolean accept(Predicate<T> visitor) {
        return true;
    }
}

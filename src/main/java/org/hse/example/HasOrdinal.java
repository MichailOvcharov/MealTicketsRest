package org.hse.example;

/**
 * Предоставляет метод, возвращающий порядковый номер
 */
public interface HasOrdinal {
    /**
     * Реализация по умолчанию, при необходимости переопределить
     *
     * @return по умолчанию возвращает null
     */
    default Long getOrdinal() {
        return null;
    }
}

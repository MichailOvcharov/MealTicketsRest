package org.hse.example.views;


import lombok.Builder;
import lombok.Data;

import java.util.Collection;

/**
 * Класс представление данных о наборе счастливых билетов
 */
@Data
@Builder
public class TicketListView {
    private Collection<String> tickets;
    private Long count;

}

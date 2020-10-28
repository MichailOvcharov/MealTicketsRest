package org.hse.example.builders;

import org.hse.example.MealTicket;
import org.hse.example.Ticket;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Сервис строитель экземпяров {@link org.hse.example.Ticket}
 */
@Service("ticketBuilder")
@Scope("prototype")
public class TicketBuilder implements MealTicketBuilder {

    private Long ticket;

    /**
     * Признак использования данного экземпляра Строителя
     */
    private boolean used = false;

    @PostConstruct
    public void init() {
        used = false;
    }

    @Override
    public MealTicket build() {
        if (used) {
            throw new IllegalStateException("Данный Строитель использовался ранее!");
        }

        used = true;
        return new Ticket(ticket);

    }

    @Override
    public MealTicketBuilder ticket(long ticket) {
        this.ticket = ticket;
        return this;
    }
}

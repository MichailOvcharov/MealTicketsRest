package org.hse.example.builders;

import org.hse.example.MealTicket;
import org.hse.example.SmallTicket;
import org.hse.example.Ticket;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service("smallTicketBuilder")
@Scope("prototype")
public class SmallTicketBuilder implements MealTicketBuilder{

    private Long ticket;
    public boolean used = false;
    @PostConstruct
    void init() {
        used = false;
    }

    @Override
    public MealTicket build() {
        if(used) {
            throw new IllegalArgumentException("Данный строитель использовался ранее!");
        }
        used = true;
        return new SmallTicket(ticket);
    }

    @Override
    public MealTicketBuilder ticket(long ticket) {
        this.ticket = ticket;
        return this;
    }

}

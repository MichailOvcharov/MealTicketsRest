package org.hse.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Iterator;
import java.util.function.Supplier;

/**
 * Класс-конфигуратор
 */
@Configuration
@ComponentScan("org.hse.example")
public class AppConfig {

    /**
     * @return длина билета
     */
    @Bean("ticketLength")
    public Integer getTicketLength(){
        return 6;
    }

    @Bean("mealTicketCounter")
    @Primary
    @Autowired
    public Supplier<Long> getTicketCounter(@Qualifier("ticketsGenerator")
                                           final Iterator<MealTicket> ticketIterator){
        return new MealTicketCounter(ticketIterator);
    }

    @Bean("evenMealTicketCounter")
    @Primary
    @Autowired
    public Supplier<Long> getEvenTicketCounter(@Qualifier("ticketsGenerator")
                                           final Iterator<MealTicket> ticketIterator){
        return new EvenMealTicketCounter(ticketIterator);
    }

    @Bean("multipleOfFiveMealTicketCounter")
    @Primary
    @Autowired
    public Supplier<Long> getMultipleOfFiveTicketCounter(@Qualifier("ticketsGenerator")
                                           final Iterator<MealTicket> ticketIterator){
        return new MultipleOfFiveMealTicketCounter(ticketIterator);
    }
}

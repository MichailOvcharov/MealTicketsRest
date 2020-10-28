package org.hse.example.controllers;

import org.hse.example.views.MealTicketType;
import org.hse.example.views.TicketListView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Контроллер для работы со счастливыми билетами
 */
@RestController
@RequestMapping("/tickets")
public class MealTicketController {

    private final Map<MealTicketType, Supplier<TicketListView>> suppliers;

    @Autowired
    public MealTicketController(@Qualifier("mealTicketListView") Supplier<TicketListView> supplier,
                                @Qualifier("evenTicketCounter") Supplier<TicketListView> evenTicketSupplier,
                                @Qualifier("multipleOfFiveMeal")  Supplier<TicketListView> multipleOfFiveSupplier) {
        suppliers = new HashMap<>();
        suppliers.put(MealTicketType.ALL , supplier);
        suppliers.put(MealTicketType.EVEN , evenTicketSupplier);
        suppliers.put(MealTicketType.FIVE , multipleOfFiveSupplier);
    }

//    @GetMapping
//    public TicketListView get() {
//        return TicketListView
//                .builder()
//                .tickets(Collections.emptyList())
//                .count(0L)
//                .build();
//    }

    @GetMapping
    public TicketListView getTickets() {
        return getTicketsSupplierByTicketType(MealTicketType.ALL).get();
    }

    @GetMapping("/even")
    public TicketListView getEvenTickets() {
        return getTicketsSupplierByTicketType(MealTicketType.EVEN).get();
    }

    @GetMapping("/five")
    public TicketListView getMultipleOfFiveTickets() {
        return getTicketsSupplierByTicketType(MealTicketType.FIVE).get();
    }

    @GetMapping("/{ticketType}")
    public TicketListView getMealTicketsByType(@PathVariable(name = "ticketType") final MealTicketType ticketType) {
        return getTicketsSupplierByTicketType(ticketType).get();
    }

    private Supplier<TicketListView> getTicketsSupplierByTicketType(final MealTicketType ticketsType) {
        if (suppliers.get(ticketsType) == null) {
            throw new UnsupportedOperationException("Такой тип счастливых билетов не обрабатывается!");
        }
        return suppliers.get(ticketsType);
    }
}

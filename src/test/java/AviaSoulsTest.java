import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {

    // Сортировка по критерию - цены билета
    @Test
    public void testSortTicketsWhenSevenTickets() {

        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("Rome", "Paris", 250_000, 1, 2);
        Ticket ticket2 = new Ticket("Rome", "Paris", 20_000, 4, 6);
        Ticket ticket3 = new Ticket("Rome", "Paris", 30_000, 3, 5);
        Ticket ticket4 = new Ticket("Rome", "Paris", 70_000, 2, 3);
        Ticket ticket5 = new Ticket("Rome", "Paris", 50_000, 2, 4);
        Ticket ticket6 = new Ticket("Rome", "Milan", 670_000, 2, 4);
        Ticket ticket7 = new Ticket("Rome", "Madrid", 890_000, 2, 4);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] actual = manager.search("Rome", "Paris");
        Ticket expected[] = {ticket2, ticket3, ticket5, ticket4, ticket1};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void testSortTicketsWhenZeroTicket() {

        AviaSouls manager = new AviaSouls();


        Ticket[] actual = manager.search("Rome", "Paris");
        Ticket expected[] = {};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void testSortTicketsWhenOneTicket() {

        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("Rome", "Paris", 250_000, 1, 2);

        manager.add(ticket1);

        Ticket[] actual = manager.search("Rome", "Paris");
        Ticket expected[] = {ticket1};

        Assertions.assertArrayEquals(actual, expected);
    }

    // Сортировка по критерию - время полёта
    @Test
    public void testSortTimeWhenSevenTickets() {

        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("Rome", "Paris", 250_000, 1, 2); //1
        Ticket ticket2 = new Ticket("Rome", "Paris", 20_000, 4, 6); //2
        Ticket ticket3 = new Ticket("Rome", "Paris", 30_000, 3, 5); //2
        Ticket ticket4 = new Ticket("Rome", "Paris", 70_000, 2, 6); //4
        Ticket ticket5 = new Ticket("Rome", "Paris", 50_000, 1, 4); //3
        Ticket ticket6 = new Ticket("Rome", "Milan", 670_000, 2, 8); //6
        Ticket ticket7 = new Ticket("Rome", "Madrid", 890_000, 2, 7); //5

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.searchAndSortBy("Rome", "Paris", comparator);
        Ticket expected[] = {ticket1, ticket2, ticket3, ticket5, ticket4};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void testSortTimeWhenZeroTicket() {

        AviaSouls manager = new AviaSouls();

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.searchAndSortBy("Rome", "Paris", comparator);
        Ticket expected[] = {};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void testSortTimeWhenOneTicket() {

        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("Rome", "Madrid", 890_000, 2, 7); //5

        manager.add(ticket1);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.searchAndSortBy("Rome", "Madrid", comparator);
        Ticket expected[] = {ticket1};

        Assertions.assertArrayEquals(actual, expected);
    }

}

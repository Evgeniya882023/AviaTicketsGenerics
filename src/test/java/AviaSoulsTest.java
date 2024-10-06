import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.AviaSouls;
import ru.netology.Ticket;
import ru.netology.TicketTimeComparator;

import java.util.Comparator;

public class AviaSoulsTest {
    @Test
    public void compareToTestForPriceReturn1() {
        Ticket ticket1 = new Ticket("Шереметьево", "Куба", 95000, 7, 23);
        Ticket ticket2 = new Ticket("Шереметьево", "Доминикана", 85000, 7, 21);
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        System.out.println(ticket1.compareTo(ticket2));

        int expected = 1;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void compareToTestForPriceReturnMinus1() {
        Ticket ticket1 = new Ticket("Шереметьево", "Куба", 85000, 7, 23);
        Ticket ticket2 = new Ticket("Шереметьево", "Чикаго", 95000, 7, 21);
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        System.out.println(ticket1.compareTo(ticket2));

        int expected = -1;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void compareToTestForPriceReturn0() {
        Ticket ticket1 = new Ticket("Шереметьево", "Куба", 95000, 7, 23);
        Ticket ticket2 = new Ticket("Шереметьево", "Чикаго", 95000, 7, 21);
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        System.out.println(ticket1.compareTo(ticket2));

        int expected = 0;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void searchTestTicketsSortedByPrice() {
        Ticket ticket1 = new Ticket("Шереметьево", "Владивосток", 45000, 7, 21);
        Ticket ticket2 = new Ticket("Шереметьево", "Владивосток", 95000, 7, 22);
        Ticket ticket3 = new Ticket("Шереметьево", "Владивосток", 25000, 7, 20);
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        Ticket[] expected = {ticket3, ticket1, ticket2};
        Ticket[] actual = aviaSouls.search("Шереметьево", "Владивосток");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testMethodSearchAndSortBy() { //сортирует по логике переданного параметром компаратора.
        Ticket ticket1 = new Ticket("Шереметьево", "Владивосток", 45000, 7, 21);
        Ticket ticket2 = new Ticket("Шереметьево", "Владивосток", 95000, 7, 20);
        Ticket ticket3 = new Ticket("Шереметьево", "Владивосток", 95000, 7, 22);
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket2, ticket1, ticket3};
        Ticket[] actual = aviaSouls.searchAndSortBy("Шереметьево", "Владивосток", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    //Компаратор должен сравнивать два билета так, что первый считался бы меньше, чем второй, если его время полёта меньше чем время полёта второго.
    public void testTicketsByFlight() {
        Ticket ticket1 = new Ticket("Шереметьево", "Владивосток", 45000, 7, 21);
        Ticket ticket2 = new Ticket("Шереметьево", "Владивосток", 95000, 7, 20);
        AviaSouls aviaSouls = new AviaSouls();
        Comparator<Ticket> comparator = new TicketTimeComparator();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        System.out.println(comparator);
        int expected = -1;
        int actual = ticket1.compareTo(ticket2);
        Assertions.assertEquals(actual, expected);
    }
}




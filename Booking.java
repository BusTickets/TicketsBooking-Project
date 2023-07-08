import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
class Booking {
    private Map<String, Passenger> passengers;
    private List<Ticket> tickets;
    private int nextTicketNumber;

    public Booking() {
        passengers = new HashMap<>();
        tickets = new ArrayList<>();
        nextTicketNumber = 1;
    }

    public void bookTicket(String firstName, String lastName, int age, String id, String phoneNumber, String paymentMethod, double amount, int numOfTickets, String destination, String journeyDate) {
        Passenger passenger = new Passenger(firstName, lastName, age, id, phoneNumber);

        Payment payment;
        if (paymentMethod.equalsIgnoreCase("Phone")) {
            payment = new Payment(paymentMethod, amount);
        } else {
            payment = new Payment("Cash", 0.0);
        }

        String pnr = generatePNR();

        Ticket ticket = new Ticket(pnr, numOfTickets, destination, journeyDate);

        passengers.put(pnr, passenger);
        tickets.add(ticket);

        System.out.println("\nTicket booked successfully!");
        System.out.println("PNR: " + ticket.getPnr());
        System.out.println("Passenger Name: " + passenger.getFirstName() + " " + passenger.getLastName());
        System.out.println("Age: " + passenger.getAge());
        System.out.println("ID: " + passenger.getId());
        System.out.println("Phone Number: " + passenger.getPhoneNumber());
        System.out.println("Number of Tickets: " + ticket.getNumOfTickets());
        System.out.println("Destination: " + ticket.getDestination());
        System.out.println("Journey Date: " + ticket.getJourneyDate());
        System.out.println("-----------------------------------------");
    }

    public void printTickets() {
        if (tickets.isEmpty()) {
            System.out.println("No tickets available.");
        } else {
            System.out.println("\nPrinting Tickets:");
            for (Ticket ticket : tickets) {
                String pnr = ticket.getPnr();
                Passenger passenger = passengers.get(pnr);

                System.out.println("\nPNR: " + pnr);
                System.out.println("Passenger Name: " + passenger.getFirstName() + " " + passenger.getLastName());
                System.out.println("Age: " + passenger.getAge());
                System.out.println("ID: " + passenger.getId());
                System.out.println("Phone Number: " + passenger.getPhoneNumber());
                System.out.println("Number of Tickets: " + ticket.getNumOfTickets());
                System.out.println("Destination: " + ticket.getDestination());
                System.out.println("Journey Date: " + ticket.getJourneyDate());
                System.out.println("-----------------------------------------");
            }
        }
    }

    public void cancelTicket(String pnrToCancel) {
        Passenger passenger = passengers.remove(pnrToCancel);
        if (passenger == null) {
            System.out.println("Invalid PNR. No ticket found.");
        } else {
            tickets.removeIf(ticket -> ticket.getPnr().equals(pnrToCancel));
            System.out.println("Ticket with PNR " + pnrToCancel + " cancelled successfully!");
        }
    }

    private String generatePNR() {
        String pnrPrefix = "PNR";
        String paddedTicketNumber = String.format("%04d", nextTicketNumber);
        nextTicketNumber++;
        return pnrPrefix + paddedTicketNumber;
    }
}

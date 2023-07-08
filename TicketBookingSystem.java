import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class TicketBookingSystem{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Booking booking = new Booking();

        System.out.print("Enter your phone number to login (starting with 0): ");
        String phoneNumber = scanner.nextLine();

        while (phoneNumber.length() != 10 || phoneNumber.charAt(0) != '0' || !phoneNumber.matches("[0-9]+")) {
            System.out.println("Invalid phone number. Phone number starts with zero and contains ten digits.");
            System.out.print("Enter your phone number to login (starting with 0): ");
            phoneNumber = scanner.nextLine();
        }

        System.out.println("\nWelcome to the Ticket Booking System!");
        System.out.println("--------------------------------------");

        int choice = 0;

        while (choice != 4) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Book a ticket");
            System.out.println("2. Print tickets");
            System.out.println("3. Cancel a ticket");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("\nEnter your first name: ");
                    String firstName = scanner.nextLine();

                    // Validate first name as alphabetical characters only
                    while (!isValidName(firstName)) {
                        System.out.println("Invalid first name.");
                        System.out.print("Enter your first name: ");
                        firstName = scanner.nextLine();
                    }

                    System.out.print("Enter your last name: ");
                    String lastName = scanner.nextLine();

                    // Validate last name as alphabetical characters only
                    while (!isValidName(lastName)) {
                        System.out.println("Invalid last name.");
                        System.out.print("Enter your last name: ");
                        lastName = scanner.nextLine();
                    }

                    int age = 0;
                    boolean validAge = false;
                    while (!validAge) {
                        try {
                            System.out.print("Enter your age: ");
                            age = scanner.nextInt();
                            scanner.nextLine();
                            validAge = true;
                        } catch (Exception e) {
                            System.out.println("Invalid age.");
                            scanner.nextLine();
                        }
                    }

                    System.out.print("Enter your ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter payment method (Phone/Cash): ");
                    String paymentMethod = scanner.nextLine();

                    // Validate payment method
                    while (!paymentMethod.equalsIgnoreCase("Phone") && !paymentMethod.equalsIgnoreCase("Cash")) {
                        System.out.println("Invalid payment method. Please enter either 'Phone' or 'Cash'.");
                        System.out.print("Enter payment method (Phone/Cash): ");
                        paymentMethod = scanner.nextLine();
                    }

                    double amount = 0.0;
                    boolean validAmount = false;
                    while (!validAmount) {
                        try {
                            System.out.print("Enter the amount: ");
                            amount = scanner.nextDouble();
                            scanner.nextLine();
                            validAmount = true;
                        } catch (Exception e) {
                            System.out.println("Invalid amount. Please enter a numeric value.");
                            scanner.nextLine();
                        }
                    }

                    int numOfTickets = 0;
                    boolean validNumOfTickets = false;
                    while (!validNumOfTickets) {
                        try {
                            System.out.print("Enter number of tickets: ");
                            numOfTickets = scanner.nextInt();
                            scanner.nextLine();
                            validNumOfTickets = true;
                        } catch (Exception e) {
                            System.out.println("Invalid number of tickets. Please enter a numeric value.");
                            scanner.nextLine();
                        }
                    }

                    System.out.print("Enter destination: ");
                    String destination = scanner.nextLine();

                    String journeyDate = "";
                    boolean validJourneyDate = false;
                    while (!validJourneyDate) {
                        try {
                            System.out.print("Enter journey date (dd/MM/yyyy): ");
                            journeyDate = scanner.nextLine();
                            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                            dateFormat.setLenient(false);
                            dateFormat.parse(journeyDate);
                            validJourneyDate = true;
                        } catch (ParseException e) {
                            System.out.println("Invalid date format. Please enter a valid date in the format (dd/MM/yyyy).");
                        }
                    }

                    booking.bookTicket(firstName, lastName, age, id, phoneNumber, paymentMethod, amount, numOfTickets, destination, journeyDate);
                    break;

                case 2:
                    booking.printTickets();
                    break;

                case 3:
                    System.out.print("\nEnter the PNR to cancel the ticket: ");
                    String pnrToCancel = scanner.nextLine();
                    booking.cancelTicket(pnrToCancel);
                    break;

                case 4:
                    System.out.println("\nThank you for using the Ticket Booking System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }

        scanner.close();
    }

    private static boolean isValidName(String name) {
        return name.matches("[a-zA-Z]+");
    }
}



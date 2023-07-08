import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
class Ticket {
    private String pnr;
    private int numOfTickets;
    private String destination;
    private String journeyDate;

    public Ticket(String pnr, int numOfTickets, String destination, String journeyDate) {
        this.pnr = pnr;
        this.numOfTickets = numOfTickets;
        this.destination = destination;
        this.journeyDate = journeyDate;
    }

    public String getPnr() {
        return pnr;
    }

    public int getNumOfTickets() {
        return numOfTickets;
    }

    public String getDestination() {
        return destination;
    }

    public String getJourneyDate() {
        return journeyDate;
    }
}

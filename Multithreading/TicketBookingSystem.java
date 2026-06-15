package JAVA_DAY_15;
class Theater {

    int totalSeats =4;

    public synchronized void bookSeat(int seats) {

        if (totalSeats >= seats) {

            System.out.println(Thread.currentThread().getName()+ " Booking Successful");

            totalSeats = totalSeats - seats;

            System.out.println("Remaining Seats = " + totalSeats);

        } else {

            System.out.println(Thread.currentThread().getName()+ " Booking Failed");
        }
    }
}

class BookingThread extends Thread {

    Theater theater;
    int seatsRequired;

    BookingThread(Theater theater, int seatsRequired) {
        this.theater = theater;
        this.seatsRequired = seatsRequired;
    }

    public void run() {
        theater.bookSeat(seatsRequired);
    }
}

public class MOVIE_TICKET_BOOKING_SYSTEM {

    public static void main(String[] args) {
    	// TODO Auto-generated method stub
    	
        Theater theater = new Theater();

        BookingThread t1 = new BookingThread(theater, 1);
        BookingThread t2 = new BookingThread(theater, 1);
        BookingThread t3 = new BookingThread(theater, 1);
        BookingThread t4 = new BookingThread(theater, 1);
        t1.setName("SUNIL");
        t2.setName("ARJUN");
        t3.setName("KRISHNA");
        t4.setName("BALRAM");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

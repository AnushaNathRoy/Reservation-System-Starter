package flight.reservation.order;

import flight.reservation.Customer;
import flight.reservation.flight.ScheduledFlight;
import flight.reservation.payment.PaymentStrategy;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class FlightOrder extends Order {
    private final List<ScheduledFlight> flights;
    private PaymentStrategy paymentStrategy;
    static List<String> noFlyList = Arrays.asList("Peter", "Johannes");

    public FlightOrder(List<ScheduledFlight> flights) {
        this.flights = flights;
    }

    public static List<String> getNoFlyList() {
        return noFlyList;
    }

    public List<ScheduledFlight> getScheduledFlights() {
        return flights;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }


    private boolean isOrderValid(Customer customer, List<String> passengerNames, List<ScheduledFlight> flights) {
        boolean valid = true;
        valid = valid && !noFlyList.contains(customer.getName());
        valid = valid && passengerNames.stream().noneMatch(passenger -> noFlyList.contains(passenger));
        valid = valid && flights.stream().allMatch(scheduledFlight -> {
            try {
                return scheduledFlight.getAvailableCapacity() >= passengerNames.size();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
                return false;
            }
        });
        return valid;
    }

    public boolean processOrder() throws IllegalStateException {
        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment strategy is not set");
        }
        
        if(paymentStrategy.pay(this.getPrice())) {
           setClosed();
           return true;
        } 

        return false;
    }
}

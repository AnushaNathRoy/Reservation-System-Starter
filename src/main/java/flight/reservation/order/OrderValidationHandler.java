package flight.reservation.order;

import flight.reservation.Customer;
import flight.reservation.Passenger;

import java.util.List;
import flight.reservation.flight.ScheduledFlight;

public class OrderValidationHandler implements OrderHandler {

    private OrderHandler nextHandler;
    private Customer customer;
    private List<Passenger> passengers;
    private List<ScheduledFlight> flights;
    private List<String> noFlyList;


    @Override
    public void setNextHandler(OrderHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public boolean processOrder(FlightOrder order) {
        this.customer = order.getCustomer();
        this.passengers = order.getPassengers();
        this.flights = order.getScheduledFlights();
        this.noFlyList = FlightOrder.getNoFlyList();

        boolean valid = true;
        valid = valid && !noFlyList.contains(customer.getName());
        valid = valid && passengers.stream().noneMatch(passenger -> noFlyList.contains(passenger));
        valid = valid && flights.stream().allMatch(scheduledFlight -> {
            try {
                return scheduledFlight.getAvailableCapacity() >= passengers.size();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
                return false;
            }
        });
        
        if (valid) {
            return nextHandler.processOrder(order);
        } else {
            return false;
        }
    }
}
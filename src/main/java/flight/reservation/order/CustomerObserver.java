package flight.reservation.order;
import flight.reservation.Customer;
public class CustomerObserver implements OrderObserver {
    Customer customer;

    @Override
    public void update(Order order) {
        System.out.println("Order " + order.getId() + " process is closed.");
    }
}
package flight.reservation.order;

public class CustomerObserver implements OrderObserver {
    @Override
    public void update(Order order) {
        System.out.println("Order " + order.getId() + " process is closed.");
    }
}
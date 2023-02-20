package flight.reservation.order;

public class OrderPriceObserver implements OrderObserver {

    @Override
    public void update(Order order) {
        System.out.println("Order price updated: " + order.getPrice());
    }
}
package flight.reservation.order;

public class OrderCompletionHandler implements OrderHandler {

    private OrderHandler nextHandler;

    @Override
    public void setNextHandler(OrderHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public boolean processOrder(FlightOrder order) {
        order.setClosed();
        System.out.println("Order fulfilled.");
        return true;
    }
}

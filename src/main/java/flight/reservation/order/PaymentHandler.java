package flight.reservation.order;

public class PaymentHandler implements OrderHandler {

    private OrderHandler nextHandler;

    @Override
    public void setNextHandler(OrderHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public boolean processOrder(FlightOrder order) {
        if (order.getPaymentStrategy().pay(order.getPrice())) {
            System.out.println("Payment processed successfully.");
            return nextHandler.processOrder(order);
        } else {
            System.out.println("Payment failed.");
            return false;
        }
    }
}
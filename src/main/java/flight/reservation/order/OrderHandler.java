package flight.reservation.order;

public interface OrderHandler {
    void setNextHandler(OrderHandler nextHandler);
    boolean processOrder(FlightOrder order);
}
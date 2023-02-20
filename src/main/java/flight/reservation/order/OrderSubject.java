package flight.reservation.order;

public interface OrderSubject {
    void registerObserver(OrderObserver observer);
    void removeObserver(OrderObserver observer);
    void notifyObservers();
}

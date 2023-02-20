package flight.reservation.order;

import flight.reservation.Customer;
import flight.reservation.Passenger;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {

    private final UUID id;
    private double price;
    private boolean isClosed = false;
    private Customer customer;
    private List<Passenger> passengers;
    private List<OrderObserver> observers = new ArrayList<>();

    public Order() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed() {
        isClosed = true;
        notifyObservers();
    }

    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.update(this);
        }
    }

    public void removeObserver(OrderObserver observer) {
        observers.remove(observer);
    }
}
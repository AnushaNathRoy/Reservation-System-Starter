package flight.reservation.plane;

public interface Plane {
    // variables for passenger capacity, crew capacity, and air hostess required are declared in the interface
    // and implemented in the classes that implement the interface
    String getModel();
    int getPassengerCapacity();
    int getCrewCapacity();
    int getAirHostessRequired();
}
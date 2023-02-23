package flight.reservation.plane;

public interface Plane {
    // variables for passenger capacity, crew capacity, and air hostess required are declared in the interface
    // and implemented in the classes that implement the interface
    public String getModel();
    public int getPassengerCapacity();
    public int getCrewCapacity();
    public int getAirHostessRequired();
}
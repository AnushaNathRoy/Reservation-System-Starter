package flight.reservation.flight;
import flight.reservation.plane.Plane;

public class PlaneToFlightDetails implements FlightDetails {
    private final Plane plane;

    public PlaneToFlightDetails(Plane plane) {
        this.plane = plane;
    }

    public String getFlightModel() {
        return plane.getModel();
    }

    public String getPassengerCount() {
        return String.valueOf(plane.getPassengerCapacity());
    }

    public String getCrewCount() {
        return String.valueOf(plane.getCrewCapacity());
    }

    public String getAirHostessCount() {
        return String.valueOf(plane.getAirHostessRequired());
    }

    public String totalCount() {
        return String.valueOf(plane.getPassengerCapacity() + plane.getCrewCapacity() + plane.getAirHostessRequired());
    }

}
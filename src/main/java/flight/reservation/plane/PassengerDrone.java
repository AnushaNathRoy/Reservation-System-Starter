package flight.reservation.plane;
public class PassengerDrone implements Plane {
    private final String model;
    private final int passengerCapacity = 2;
    private final int crewCapacity = 0;
    private final int airHostessRequired = 0;

    public PassengerDrone(String model) {
        if (model.equals("HypaHype")) {
            this.model = model;
        } else {
            throw new IllegalArgumentException(String.format("Model type '%s' is not recognized", model));
        }
    }

    public String getModel() {
        return model;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public int getAirHostessRequired() {
        return airHostessRequired;
    }

    public int getCrewCapacity() {
        return crewCapacity;
    }


}
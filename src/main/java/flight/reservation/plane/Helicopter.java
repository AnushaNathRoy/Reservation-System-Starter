package flight.reservation.plane;
public class Helicopter implements Plane {
    private final String model;
    private final int passengerCapacity;
    private final int crewCapacity = 1;
    private final int airHostessRequired;

    public Helicopter(String model) {
        this.model = model;
        if (model.equals("H1")) {
            passengerCapacity = 4;
            airHostessRequired = 1;
        } else if (model.equals("H2")) {
            passengerCapacity = 6;
            airHostessRequired = 2;
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

    public int getCrewCapacity() {
        return crewCapacity;
    }

    public int getAirHostessRequired() {
        return airHostessRequired;
    }
}

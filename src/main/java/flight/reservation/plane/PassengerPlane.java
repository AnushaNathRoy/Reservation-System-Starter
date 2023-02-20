package flight.reservation.plane;

public class PassengerPlane implements Plane {
    private String model;
    private final int passengerCapacity;
    private final int crewCapacity;
    private final int airHostessRequired;

    public PassengerPlane(String model) {
        this.model = model;
        switch (model) {
            case "A380":
                passengerCapacity = 500;
                crewCapacity = 42;
                airHostessRequired = 10;
                break;
            case "A350":
                passengerCapacity = 320;
                crewCapacity = 40;
                airHostessRequired = 7;
                break;
            case "Embraer 190":
                passengerCapacity = 25;
                crewCapacity = 5;
                airHostessRequired = 2;
                break;
            case "Antonov AN2":
                passengerCapacity = 15;
                crewCapacity = 3;
                airHostessRequired = 1;
                break;
            default:
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
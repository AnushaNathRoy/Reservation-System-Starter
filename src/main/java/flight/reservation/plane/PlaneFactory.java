package flight.reservation.plane;

public class PlaneFactory implements PlaneFactoryInterface{
    public Plane createPlane(String model) {
        switch (model) {
            case "A380":
                return new PassengerPlane.Builder(model).build();
            case "A350":
                return new PassengerPlane.Builder(model).build();
            case "Embraer 190":
                return new PassengerPlane.Builder(model).build();
            case "Antonov AN2":
                return new PassengerPlane.Builder(model).build();
            case "H1":
                return new Helicopter(model);
            case "H2":
                return new Helicopter(model);
            case "HypaHype":
                return new PassengerDrone(model);
            default:
                throw new IllegalArgumentException(String.format("Model type '%s' is not recognized", model));
        }
    }
}

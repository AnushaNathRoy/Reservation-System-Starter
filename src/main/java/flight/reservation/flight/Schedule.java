package flight.reservation.flight;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Schedule {

    private List<ScheduledFlight> scheduledFlights;
    private List<Command> commandHistory;

    public Schedule() {
        scheduledFlights = new ArrayList<>();
        commandHistory = new ArrayList<>();
    }

    public List<ScheduledFlight> getScheduledFlights() {
        return scheduledFlights;
    }

    public void scheduleFlight(Flight flight, Date date) {
        ScheduledFlight scheduledFlight = new ScheduledFlight(flight.getNumber(), flight.getDeparture(), flight.getArrival(), flight.getAircraft(), date);
        Command command = new ScheduleFlightCommand(this, scheduledFlight);
        executeCommand(command);
    }

    public void removeFlight(Flight flight) {
        List<ScheduledFlight> tbr = new ArrayList<>();
        for (ScheduledFlight scheduledFlight : scheduledFlights) {
            if (scheduledFlight == flight ||
                    (flight.getArrival() == scheduledFlight.getArrival() &&
                            flight.getDeparture() == scheduledFlight.getDeparture() &&
                            flight.getNumber() == scheduledFlight.getNumber())) {
                tbr.add(scheduledFlight);
            }
        }
        Command command = new RemoveFlightCommand(this, tbr);
        executeCommand(command);
    }

    public void removeScheduledFlight(ScheduledFlight flight) {
        Command command = new RemoveScheduledFlightCommand(this, flight);
        executeCommand(command);
    }

    public ScheduledFlight searchScheduledFlight(int flightNumber) {
        return scheduledFlights.stream()
                .filter(f -> f.getNumber() == flightNumber)
                .findFirst()
                .orElse(null);
    }

    public void clear() {
        Command command = new ClearScheduleCommand(this);
        executeCommand(command);
    }

    public void executeCommand(Command command) {
        command.execute();
        commandHistory.add(command);
    }

    public void undoLastCommand() {
        if (commandHistory.size() > 0) {
            Command lastCommand = commandHistory.remove(commandHistory.size() - 1);
            lastCommand.undo();
        }
    }
}

interface Command {
    void execute();
    void undo();
}

class ScheduleFlightCommand implements Command {
    private Schedule schedule;
    private ScheduledFlight scheduledFlight;

    public ScheduleFlightCommand(Schedule schedule, ScheduledFlight scheduledFlight) {
        this.schedule = schedule;
        this.scheduledFlight = scheduledFlight;
    }

    public void execute() {
        schedule.getScheduledFlights().add(scheduledFlight);
    }

    public void undo() {
        schedule.getScheduledFlights().remove(scheduledFlight);
    }
}

class RemoveFlightCommand implements Command {
    private Schedule schedule;
    private List<ScheduledFlight> toBeRemoved;

    public RemoveFlightCommand(Schedule schedule, List<ScheduledFlight> toBeRemoved) {
        this.schedule = schedule;
        this.toBeRemoved = toBeRemoved;
    }

    public void execute() {
        schedule.getScheduledFlights().removeAll(toBeRemoved);
    }

    public void undo() {
        schedule.getScheduledFlights().addAll(toBeRemoved);
    }
}

class RemoveScheduledFlightCommand implements Command {
    private Schedule schedule;
    private ScheduledFlight scheduledFlight;

    public RemoveScheduledFlightCommand(Schedule schedule, ScheduledFlight scheduledFlight) {
        this.schedule = schedule;
            this.scheduledFlight = scheduledFlight;
        }

        public void execute() {
            schedule.getScheduledFlights().remove(scheduledFlight);
        }

        public void undo() {
            schedule.getScheduledFlights().add(scheduledFlight);
        }
    }

class ClearScheduleCommand implements Command {
    private Schedule schedule;
    private List<ScheduledFlight> previousState;

    public ClearScheduleCommand(Schedule schedule) {
        this.schedule = schedule;
        this.previousState = new ArrayList<>(schedule.getScheduledFlights());
    }

    public void execute() {
        schedule.getScheduledFlights().clear();
    }

    public void undo() {
        schedule.getScheduledFlights().addAll(previousState);
    }

}

import java.util.*;

public class Ride implements RideInterface {
    private String rideName;
    private int maxRider;
    private Employee operator;
    private Queue<Visitor> waitingLine;
    private LinkedList<Visitor> rideHistory;
    private int numOfCycles;

    public Ride() {
        waitingLine = new LinkedList<>();
        rideHistory = new LinkedList<>();
        numOfCycles = 0;
    }

    public Ride(String rideName, int maxRider, Employee operator) {
        this();
        this.rideName = rideName;
        this.maxRider = maxRider;
        this.operator = operator;
    }

    // Getters and Setters
    public String getRideName() { return rideName; }
    public void setRideName(String rideName) { this.rideName = rideName; }

    public int getMaxRider() { return maxRider; }
    public void setMaxRider(int maxRider) { this.maxRider = maxRider; }

    public Employee getOperator() { return operator; }
    public void setOperator(Employee operator) { this.operator = operator; }

    public int getNumOfCycles() { return numOfCycles; }

    // Interface methods (to be implemented in later commits)
    @Override
    public void addVisitorToQueue(Visitor visitor) {}

    @Override
    public void removeVisitorFromQueue() {}

    @Override
    public void printQueue() {}

    @Override
    public void addVisitorToHistory(Visitor visitor) {}

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) { return false; }

    @Override
    public int numberOfVisitors() { return 0; }

    @Override
    public void printRideHistory() {}

    @Override
    public void runOneCycle() {}
}
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

    // Getters and Setters...

    // Part 3: Queue methods
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (waitingLine.offer(visitor)) {
            System.out.println("Visitor " + visitor.getName() + " added to queue.");
        } else {
            System.out.println("Failed to add visitor to queue.");
        }
    }

    @Override
    public void removeVisitorFromQueue() {
        Visitor visitor = waitingLine.poll();
        if (visitor != null) {
            System.out.println("Removed " + visitor.getName() + " from queue.");
        } else {
            System.out.println("Queue is empty.");
        }
    }

    @Override
    public void printQueue() {
        if (waitingLine.isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Waiting line:");
        for (Visitor v : waitingLine) {
            System.out.println("- " + v.getName() + " (ID: " + v.getVisitorId() + ")");
        }
    }

    // Part 4A: LinkedList methods
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (rideHistory.add(visitor)) {
            System.out.println("Visitor " + visitor.getName() + " added to ride history.");
        } else {
            System.out.println("Failed to add visitor to history.");
        }
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        boolean found = rideHistory.contains(visitor);
        System.out.println("Visitor " + visitor.getName() + " in history: " + found);
        return found;
    }

    @Override
    public int numberOfVisitors() {
        int count = rideHistory.size();
        System.out.println("Number of visitors in history: " + count);
        return count;
    }

    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("Ride history is empty.");
            return;
        }
        System.out.println("Ride history:");
        Iterator<Visitor> iterator = rideHistory.iterator();
        while (iterator.hasNext()) {
            Visitor v = iterator.next();
            System.out.println("- " + v.getName() + " (ID: " + v.getVisitorId() + ")");
        }
    }

    // Part 4B: Sorting
    public void sortRideHistory(Comparator<Visitor> comparator) {
        rideHistory.sort(comparator);
        System.out.println("Ride history sorted.");
    }

    // Part 5: Run one cycle
    @Override
    public void runOneCycle() {
        if (operator == null) {
            System.out.println("Cannot run ride: no operator assigned.");
            return;
        }
        if (waitingLine.isEmpty()) {
            System.out.println("Cannot run ride: no visitors in queue.");
            return;
        }

        int count = 0;
        while (count < maxRider && !waitingLine.isEmpty()) {
            Visitor visitor = waitingLine.poll();
            addVisitorToHistory(visitor);
            count++;
        }
        numOfCycles++;
        System.out.println("Ride run for one cycle. " + count + " visitors served.");
    }
}
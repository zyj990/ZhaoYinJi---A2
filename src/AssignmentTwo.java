public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo a2 = new AssignmentTwo();
        a2.partThree();
        a2.partFourA();
        a2.partFourB();
        a2.partFive();
        a2.partSix();
        a2.partSeven();
    }

    public void partThree() {
        System.out.println("=== Part 3: Queue Demo ===");
        Ride ride = new Ride("Roller Coaster", 2, new Employee("John", 25, "M", "E001", "Operator"));
        for (int i = 1; i <= 5; i++) {
            ride.addVisitorToQueue(new Visitor("Visitor" + i, 20 + i, "M", "V00" + i, "Adult"));
        }
        ride.printQueue();
        ride.removeVisitorFromQueue();
        ride.printQueue();
    }

    public void partFourA() {
        System.out.println("\n=== Part 4A: Ride History Demo ===");
        Ride ride = new Ride();
        for (int i = 1; i <= 5; i++) {
            ride.addVisitorToHistory(new Visitor("HistoryVisitor" + i, 25 + i, "F", "H00" + i, "Child"));
        }
        ride.checkVisitorFromHistory(new Visitor("HistoryVisitor1", 26, "F", "H001", "Child"));
        ride.numberOfVisitors();
        ride.printRideHistory();
    }

    public void partFourB() {
        System.out.println("\n=== Part 4B: Sorting Demo ===");
        Ride ride = new Ride();
        ride.addVisitorToHistory(new Visitor("Zack", 30, "M", "V010", "Adult"));
        ride.addVisitorToHistory(new Visitor("Alice", 25, "F", "V011", "Adult"));
        ride.addVisitorToHistory(new Visitor("Bob", 22, "M", "V012", "Child"));
        System.out.println("Before sorting:");
        ride.printRideHistory();
        ride.sortRideHistory(new VisitorComparator());
        System.out.println("After sorting:");
        ride.printRideHistory();
    }

    public void partFive() {
        System.out.println("\n=== Part 5: Run One Cycle Demo ===");
        Ride ride = new Ride("Water Ride", 3, new Employee("Jane", 28, "F", "E002", "Operator"));
        for (int i = 1; i <= 10; i++) {
            ride.addVisitorToQueue(new Visitor("CycleVisitor" + i, 15 + i, "M", "C00" + i, "Adult"));
        }
        System.out.println("Before cycle:");
        ride.printQueue();
        ride.runOneCycle();
        System.out.println("After cycle:");
        ride.printQueue();
        ride.printRideHistory();
    }

    public void partSix() {
        System.out.println("\n=== Part 6: Export Ride History ===");
        Ride ride = new Ride();
        for (int i = 1; i <= 5; i++) {
            ride.addVisitorToHistory(new Visitor("ExportVisitor" + i, 20 + i, "M", "EX00" + i, "Adult"));
        }
        ride.exportRideHistory("ride_history.csv");
    }

    public void partSeven() {
        System.out.println("\n=== Part 7: Import Ride History ===");
        Ride ride = new Ride();
        ride.importRideHistory("ride_history.csv");
        ride.numberOfVisitors();
        ride.printRideHistory();
    }
}
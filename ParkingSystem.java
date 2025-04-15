package sample.java;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class ParkingSystem {

    static int totalSlots, availableSlots;
    static ArrayList<String> parkedCars = new ArrayList<>();

    public static void main(String[] args) {

        totalSlots = Integer.parseInt(JOptionPane.showInputDialog("Enter the total number of parking slots:"));
        availableSlots = totalSlots;

        while (true) {
            String choiceString = JOptionPane.showInputDialog(
                    "What would you like to do?\n" +
                            "1. Park a car\n" +
                            "2. Remove a car\n" +
                            "3. View parked cars\n" +
                            "4. Exit"
            );
            int choice = Integer.parseInt(choiceString);

            switch (choice) {
                case 1:
                    parkCar();
                    break;
                case 2:
                    removeCar();
                    break;
                case 3:
                    viewParkedCars();
                    break;
                case 4:
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
            }
        }
    }

    public static void parkCar() {
        if (availableSlots == 0) {
            JOptionPane.showMessageDialog(null, "Sorry, there are no available parking slots.");
            return;
        }

        String licensePlate = JOptionPane.showInputDialog("Enter the license plate number of the car:");
        parkedCars.add(licensePlate);
        availableSlots--;
        JOptionPane.showMessageDialog(null, "Car parked successfully. Available slots: " + availableSlots);
    }

    public static void removeCar() {
        if (availableSlots == totalSlots) {
            JOptionPane.showMessageDialog(null, "There are no parked cars.");
            return;
        }

        String licensePlate = JOptionPane.showInputDialog("Enter the license plate number of the car to be removed:");
        if (parkedCars.contains(licensePlate)) {
            parkedCars.remove(licensePlate);
            availableSlots++;
            JOptionPane.showMessageDialog(null, "Car removed successfully. Available slots: " + availableSlots);
        } else {
            JOptionPane.showMessageDialog(null, "The car is not parked here.");
        }
    }

    public static void viewParkedCars() {
        if (availableSlots == totalSlots) {
            JOptionPane.showMessageDialog(null, "There are no parked cars.");
            return;
        }

        StringBuilder parkedCarsString = new StringBuilder("Parked cars:\n");
        for (String licensePlate : parkedCars) {
            parkedCarsString.append(licensePlate).append("\n");
        }
        JOptionPane.showMessageDialog(null, parkedCarsString.toString());
    }
}
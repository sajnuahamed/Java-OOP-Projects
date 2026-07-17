
import java.util.Scanner;

/**
 * Console-based application for managing food delivery orders. Demonstrates
 * inheritance, abstraction, interfaces, runtime polymorphism, and
 * encapsulation.
 */
public class FoodDeliveryManagement {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            Order[] orders = {new FastFoodOrder(4312, "Sam", 456, 50),
                new FastFoodOrder(111, "David", 800, 70),
                new FineDiningOrder(222, "Riya", 2400, 350),
                new GroceryOrder(1122, "Raj", 870, 20, 50),
                new GroceryOrder(1123, "Tiya", 1403, 20, 60)
            };

            System.out.println("--------> FOOD DELIVERY MANAGEMENT <--------");
            int choice;
            do {

                System.out.println("1. View All Orders");
                System.out.println("2. Update Order Status");
                System.out.println("3. Quit");
                System.out.print("Enter the option# to choose: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> {
                        System.out.println("=========== ORDERS =============");
                        for (Order order : orders) {
                            order.displayDetails();
                            System.out.println("");
                        }
                        System.out.println("-----------------------------------------");
                    }

                    case 2 -> {
                        System.out.print("Enter the order Id: ");
                        int orderId = scanner.nextInt();
                        Order order = findOrderById(orderId, orders);
                        if (order != null) {

                            System.out.println("1. Processing");
                            System.out.println("2. " + Trackable.DISPATCHED);
                            System.out.println("3. " + Trackable.IN_TRANSIT);
                            System.out.println("4. " + Trackable.OUT_FOR_DELIVERY);
                            System.out.println("5. " + Trackable.DELIVERED);

                            System.out.print("Change the status into : ");
                            int statusNo = scanner.nextInt();
                            if (statusNo > 0 && statusNo < 6) {
                                changeTrackingStatus(order, statusNo);
                                System.out.println("Status updated successfully!");
                                System.out.println("--------------------");
                                order.displayDetails();
                                System.out.println("--------------------");
                            } else {
                                System.out.println("Invalid Number!");
                            }
                        } else {
                            System.out.println("Invalid Order ID!");
                        }
                    }
                    case 3 ->
                        System.out.println("Quitting..");
                    default ->
                        System.out.println("Invalid Choice!");

                }

            } while (choice != 3);

        }
    }

    public static Order findOrderById(int orderId, Order[] orders) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                return order;
            }
        }
        return null;
    }

    public static void changeTrackingStatus(Order order, int statusChoiceNo) {
        switch (statusChoiceNo) {
            case 1 ->
                order.trackOrder();
            case 2 ->
                order.setTrackStatus(Trackable.DISPATCHED);
            case 3 ->
                order.setTrackStatus(Trackable.IN_TRANSIT);
            case 4 ->
                order.setTrackStatus(Trackable.OUT_FOR_DELIVERY);
            case 5 ->
                order.setTrackStatus(Trackable.DELIVERED);
        }

    }
}

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static class Order {
        String title;
        String description;
        double payment;

        Order(String title, String description, double payment) {
            this.title = title;
            this.description = description;
            this.payment = payment;
        }

        public String getOrderDetails() {
            return "Name of order: " + title + "\nDescription: " + description + "\nPayment: $" + payment;
        }
    }

    static class User {
        String username;
        String password;

        User(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }

    static ArrayList<User> users = new ArrayList<>();
    static ArrayList<Order> orders = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        System.out.println("Welcome to FreelanceJob!");

        while (running) {
            System.out.println("\n1. Registration");
            System.out.println("2. Login");
            System.out.println("3. Add order");
            System.out.println("4. View orders");
            System.out.println("5. Exit");
            System.out.print("Select the desired item: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (choice) {
                case 1 -> registerUser();
                case 2 -> loginUser();
                case 3 -> addOrder();
                case 4 -> viewOrders();
                case 5 -> {
                    System.out.println("Thank you for using FreelanceJob!");
                    running = false;
                }
                default -> System.out.println("Error. Will try again.");
            }
        }
    }

    static void registerUser() {
        System.out.print("Enter your name: ");
        String username = scanner.nextLine();
        System.out.print("Enter the password: ");
        String password = scanner.nextLine();

        users.add(new User(username, password));
        System.out.println("The user has registered successfully!");
    }

    static void loginUser() {
        System.out.print("Enter your name: ");
        String username = scanner.nextLine();
        System.out.print("Enter the password: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.username.equals(username) && user.password.equals(password)) {
                System.out.println("Login completed! Welcome, " + username + "!");
                return;
            }
        }
        System.out.println("Inappropriate login details. Please try again.");
    }

    static void addOrder() {
        System.out.print("Enter order name: ");
        String title = scanner.nextLine();
        System.out.print("Describe your order: ");
        String description = scanner.nextLine();
        System.out.print("Enter payment amount: ");
        double payment = scanner.nextDouble();
        scanner.nextLine(); // Clear the buffer

        orders.add(new Order(title, description, payment));
        System.out.println("Order added successfully");
    }

    static void viewOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders.");
        } else {
            for (int i = 0; i < orders.size(); i++) {
                System.out.println("\nOrder #" + (i + 1));
                System.out.println(orders.get(i).getOrderDetails());
            }
        }
    }
}

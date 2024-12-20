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
            return "Название работы: " + title + "\nОписание: " + description + "\nОплата: $" + payment;
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
    static ArrayList<Order> jobs = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        System.out.println("Добро пожаловать в FreelanceJob!");

        while (running) {
            System.out.println("\n1. Регистрация");
            System.out.println("2. Вход");
            System.out.println("3. Добавить заказ");
            System.out.println("4. Посмотреть заказы");
            System.out.println("5. Выйти");
            System.out.print("Выберите нужный пункт: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            switch (choice) {
                case 1 -> registerUser();
                case 2 -> loginUser();
                case 3 -> addOrder();
                case 4 -> viewOrders();
                case 5 -> {
                    System.out.println("Спасибо за использование FreelanceJob!");
                    running = false;
                }
                default -> System.out.println("Ошибка. Повторите попытку.");
            }
        }
    }

    static void registerUser() {
        System.out.print("Введите имя: ");
        String username = scanner.nextLine();
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();

        users.add(new User(username, password));
        System.out.println("Пользоователь зарегестрировалься успешно!");
    }

    static void loginUser() {
        System.out.print("Введите имя: ");
        String username = scanner.nextLine();
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();

        for (User user : users) {
            if (user.username.equals(username) && user.password.equals(password)) {
                System.out.println("Вход выполнен! Добро пожаловать, " + username + "!");
                return;
            }
        }
        System.out.println("Не подходящие реквизиты для входа. Повторите попытку.");
    }

    static void addOrder() {
        System.out.print("Введите название заказа: ");
        String title = scanner.nextLine();
        System.out.print("Опишите заказ: ");
        String description = scanner.nextLine();
        System.out.print("Введите сумму оплаты: ");
        double payment = scanner.nextDouble();
        scanner.nextLine(); // Clear the buffer

        jobs.add(new Order(title, description, payment));
        System.out.println("Работа добавлена успешно");
    }

    static void viewOrders() {
        if (jobs.isEmpty()) {
            System.out.println("Нету заказов.");
        } else {
            for (int i = 0; i < jobs.size(); i++) {
                System.out.println("\nOrder #" + (i + 1));
                System.out.println(jobs.get(i).getOrderDetails());
            }
        }
    }
}

package hotelmenusystem;

import java.util.*;

public class MenuDataManager {
    public static class MenuItem {
        public String name;
        public double price;
        public String category;

        public MenuItem(String name, double price, String category) {
            this.name = name;
            this.price = price;
            this.category = category;
        }

        @Override
        public String toString() {
            return name + " - $" + price;
        }
    }

    public static class User {
        public String name;
        public String password;
        public String phone;

        public User(String name, String password, String phone) {
            this.name = name;
            this.password = password;
            this.phone = phone;
        }
    }

    public static List<MenuItem> menuItems = new ArrayList<>();
    public static List<String> orderHistory = new ArrayList<>();
    public static HashMap<String, User> users = new HashMap<>();

    static {
        // Default admin user
        users.put("admin", new User("admin", "admin123", "0000000000"));

        // Adding Nigerian food menu items
        menuItems.add(new MenuItem("Pancakes", 5.99, "Breakfast"));
        menuItems.add(new MenuItem("Omelette", 4.99, "Breakfast"));
        menuItems.add(new MenuItem("Akara", 6.99, "Breakfast"));  // Nigerian dish
        menuItems.add(new MenuItem("Moi Moi", 7.49, "Breakfast"));  // Nigerian dish

        menuItems.add(new MenuItem("Burger", 7.99, "Lunch"));
        menuItems.add(new MenuItem("Pizza", 8.99, "Lunch"));
        menuItems.add(new MenuItem("Jollof Rice", 10.99, "Lunch"));  // Nigerian dish
        menuItems.add(new MenuItem("Fried Rice", 9.99, "Lunch"));
        menuItems.add(new MenuItem("Pounded Yam and Egusi Soup", 12.99, "Lunch"));  // Nigerian dish

        menuItems.add(new MenuItem("Steak", 12.99, "Dinner"));
        menuItems.add(new MenuItem("Salmon", 14.99, "Dinner"));
        menuItems.add(new MenuItem("Pepper Soup", 13.49, "Dinner"));  // Nigerian dish
        menuItems.add(new MenuItem("Suya", 11.99, "Dinner"));  // Nigerian dish
        menuItems.add(new MenuItem("Bitterleaf Soup", 15.99, "Dinner"));  // Nigerian dish
    }

    public static void addItem(MenuItem item) {
        menuItems.add(item);
    }

    public static void updateItem(int index, MenuItem newItem) {
        if (index >= 0 && index < menuItems.size()) {
            menuItems.set(index, newItem);
        }
    }

    public static void deleteItem(int index) {
        if (index >= 0 && index < menuItems.size()) {
            menuItems.remove(index);
        }
    }

    public static List<MenuItem> getMenuItemsByCategory(String category) {
        List<MenuItem> filtered = new ArrayList<>();
        for (MenuItem item : menuItems) {
            if (item.category.equalsIgnoreCase(category)) {
                filtered.add(item);
            }
        }
        return filtered;
    }

    public static void addOrderToHistory(String orderDetails) {
        orderHistory.add(orderDetails);
    }

    public static List<String> getOrderHistory() {
        return orderHistory;
    }

    public static boolean addUser(String name, String password, String phone) {
        if (!users.containsKey(name)) {
            users.put(name, new User(name, password, phone));
            return true;
        }
        return false;
    }

    public static boolean validateUser(String name, String password) {
        return users.containsKey(name) && users.get(name).password.equals(password);
    }
}

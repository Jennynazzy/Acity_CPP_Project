package hotelmenusystem;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MenuFrame extends JFrame {
    private JTextArea receiptArea;
    private JComboBox<String> categoryBox;
    private DefaultListModel<MenuDataManager.MenuItem> model;
    private JList<MenuDataManager.MenuItem> menuList;
    private double total = 0;
    private StringBuilder orderBuilder = new StringBuilder();
    private String currentOrderId = "";

    public MenuFrame(boolean isAdmin) {
        setTitle("Hotel Menu");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Background color
        getContentPane().setBackground(new Color(230, 240, 255));  // Light soft blue

        model = new DefaultListModel<>();
        menuList = new JList<>(model);
        receiptArea = new JTextArea();
        receiptArea.setEditable(false);

        categoryBox = new JComboBox<>(new String[]{"Breakfast", "Lunch", "Dinner"});
        JButton showBtn = new JButton("Show Menu");
        JButton orderBtn = new JButton("Add to Order");
        JButton confirmBtn = new JButton("Confirm Order");
        JButton historyBtn = new JButton("Show Order History");

        showBtn.addActionListener(e -> loadMenu());
        orderBtn.addActionListener(e -> addToOrder());
        confirmBtn.addActionListener(e -> confirmOrder());
        historyBtn.addActionListener(e -> showHistory());

        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(230, 240, 255));
        topPanel.add(categoryBox);
        topPanel.add(showBtn);
        topPanel.add(orderBtn);
        topPanel.add(confirmBtn);
        topPanel.add(historyBtn);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(menuList), BorderLayout.CENTER);
        add(new JScrollPane(receiptArea), BorderLayout.SOUTH);
    }

    private void loadMenu() {
        String category = (String) categoryBox.getSelectedItem();
        List<MenuDataManager.MenuItem> items = MenuDataManager.getMenuItemsByCategory(category);
        model.clear();
        for (MenuDataManager.MenuItem item : items) {
            model.addElement(item);
        }
    }

    private void addToOrder() {
        MenuDataManager.MenuItem item = menuList.getSelectedValue();
        String category = (String) categoryBox.getSelectedItem();
        if (item != null) {
            total += item.price;
            orderBuilder.append(item.name)
                    .append(" - $").append(item.price)
                    .append(" [").append(category).append("]\n");
            receiptArea.setText(orderBuilder.toString() + "\nTotal: $" + total);
        }
    }

    private void confirmOrder() {
        String receipt = receiptArea.getText();
        if (!receipt.isEmpty()) {
            currentOrderId = "Order#" + (MenuDataManager.getOrderHistory().size() + 1);
            String orderDetails = currentOrderId + "\n" + receipt;
            MenuDataManager.addOrderToHistory(orderDetails);
            JOptionPane.showMessageDialog(this, "Order Confirmed!\n" + currentOrderId);
            receiptArea.setText("");
            orderBuilder.setLength(0);
            total = 0;
        }
    }

    private void showHistory() {
        List<String> history = MenuDataManager.getOrderHistory();
        if (history.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No orders yet.");
        } else {
            JTextArea area = new JTextArea();
            for (String entry : history) {
                area.append(entry + "\n\n");  // FIXED line
            }
            area.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(area);
            scrollPane.setPreferredSize(new Dimension(400, 300));
            JOptionPane.showMessageDialog(this, scrollPane, "Order History", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}

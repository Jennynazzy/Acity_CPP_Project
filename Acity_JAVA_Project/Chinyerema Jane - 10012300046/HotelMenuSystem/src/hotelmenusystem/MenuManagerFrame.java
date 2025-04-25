package hotelmenusystem;

import javax.swing.*;
import java.awt.*;

public class MenuManagerFrame extends JFrame {
    private DefaultListModel<MenuDataManager.MenuItem> model;
    private JList<MenuDataManager.MenuItem> itemList;

    public MenuManagerFrame() {
        setTitle("Admin Menu Manager");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a main panel with a nice background
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(240, 240, 255)); // Soft light purple

        model = new DefaultListModel<>();
        itemList = new JList<>(model);
        itemList.setBackground(new Color(255, 255, 255)); // White background for the list
        itemList.setFont(new Font("SansSerif", Font.PLAIN, 16));
        itemList.setSelectionBackground(new Color(173, 216, 230)); // Light blue selection
        itemList.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JScrollPane scrollPane = new JScrollPane(itemList);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Menu Items"));

        refreshList();

        // Create buttons
        JButton addBtn = createButton("Add Item");
        JButton editBtn = createButton("Edit Item");
        JButton deleteBtn = createButton("Delete Item");

        addBtn.addActionListener(e -> addItem());
        editBtn.addActionListener(e -> editItem());
        deleteBtn.addActionListener(e -> deleteItem());

        // Button panel
        JPanel btnPanel = new JPanel();
        btnPanel.setBackground(new Color(240, 240, 255));
        btnPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        btnPanel.add(addBtn);
        btnPanel.add(editBtn);
        btnPanel.add(deleteBtn);

        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(btnPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void refreshList() {
        model.clear();
        for (MenuDataManager.MenuItem item : MenuDataManager.menuItems) {
            model.addElement(item);
        }
    }

    private void addItem() {
        JTextField name = new JTextField();
        JTextField price = new JTextField();
        JTextField category = new JTextField();

        Object[] input = { "Name:", name, "Price:", price, "Category:", category };

        int result = JOptionPane.showConfirmDialog(this, input, "Add Menu Item", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                MenuDataManager.addItem(new MenuDataManager.MenuItem(
                        name.getText(),
                        Double.parseDouble(price.getText()),
                        category.getText()));
                refreshList();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid price format");
            }
        }
    }

    private void editItem() {
        int index = itemList.getSelectedIndex();
        if (index == -1) {
            JOptionPane.showMessageDialog(this, "Please select an item to edit.");
            return;
        }
        MenuDataManager.MenuItem item = model.get(index);

        JTextField name = new JTextField(item.name);
        JTextField price = new JTextField(String.valueOf(item.price));
        JTextField category = new JTextField(item.category);

        Object[] input = { "Name:", name, "Price:", price, "Category:", category };

        int result = JOptionPane.showConfirmDialog(this, input, "Edit Menu Item", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                MenuDataManager.updateItem(index, new MenuDataManager.MenuItem(
                        name.getText(),
                        Double.parseDouble(price.getText()),
                        category.getText()));
                refreshList();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid price format");
            }
        }
    }

    private void deleteItem() {
        int index = itemList.getSelectedIndex();
        if (index != -1) {
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this item?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                MenuDataManager.deleteItem(index);
                refreshList();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select an item to delete.");
        }
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(new Color(123, 104, 238)); // Light Purple
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("SansSerif", Font.BOLD, 14));
        button.setPreferredSize(new Dimension(120, 40));
        return button;
    }
}

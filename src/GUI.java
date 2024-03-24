import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class GUI extends JFrame {
    private JComboBox<String> productTypeComboBox;
    private JTable productTable;
    private JTextArea productDetailsTextArea;
    private JButton addToCartButton;
    private JButton viewCartButton;
    private ArrayList<Product> shoppingCart;

    private JFrame frame;

    private JPanel jPanel;

    public GUI() {
        setTitle("Westminster Shopping GUI");
        setSize(800, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        productTypeComboBox = new JComboBox<>(new String[]{"All", "Electronics", "Clothes"});
        productTable = new JTable(new DefaultTableModel());
        productDetailsTextArea = new JTextArea();
        addToCartButton = new JButton("Add to Shopping Cart");
        viewCartButton = new JButton("Shopping Cart");
        shoppingCart = new ArrayList<>();

        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Select Product Category"));
        topPanel.add(productTypeComboBox);
        topPanel.add(viewCartButton);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(productTable), BorderLayout.CENTER);
        add(productDetailsTextArea, BorderLayout.SOUTH);
        add(addToCartButton, BorderLayout.EAST);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(addToCartButton);
        add(bottomPanel, BorderLayout.SOUTH);

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Product ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("Category");
        tableModel.addColumn("Price");
        tableModel.addColumn("Info");

        productTable.setModel(tableModel);

        productTypeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateProductTable();
            }
        });

        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addToCart();
            }
        });

        viewCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewShoppingCart();
            }
        });

        updateProductTable();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void updateProductTable() {
        DefaultTableModel tableModel = (DefaultTableModel) productTable.getModel();
        tableModel.setRowCount(0);

        String selectedType = (String) productTypeComboBox.getSelectedItem();
        ArrayList<Product> productsToShow = new ArrayList<>();

        if (selectedType.equals("All")) {
            productsToShow.addAll(WestminsterShoppingManager.Product_Array);
        } else if (selectedType.equals("Electronics")) {
            productsToShow.addAll(WestminsterShoppingManager.electronics);
        } else if (selectedType.equals("Clothes")) {
            productsToShow.addAll(WestminsterShoppingManager.clothing);
        }

        for (Product product : productsToShow) {
            Object[] rowData = {product.getProduct_ID(), product.getProduct_Name(),
                    getProductCategory(product), product.getProductPrice(), getProductInfo(product)};
            tableModel.addRow(rowData);
        }

        productDetailsTextArea.setText("");
    }

    private String getProductInfo(Product product) {
        if (product instanceof Electronics) {
            Electronics electronics = (Electronics) product;
            return electronics.getBrand() + "," + electronics.getWarranty() + " months";
        } else if (product instanceof Clothing) {
            Clothing clothing = (Clothing) product;
            return clothing.getClothSize() + "," + clothing.getClothColor();
        }
        return "";
    }

    private String getProductCategory(Product product) {
        if (product instanceof Electronics) {
            return "Electronics";
        } else if (product instanceof Clothing) {
            return "Clothing";
        }
        return "";
    }

    private void addToCart() {
        int selectedRow = productTable.getSelectedRow();
        if (selectedRow != -1) {
            String productId = (String) productTable.getValueAt(selectedRow, 0);
            Product selectedProduct = findProductById(productId);

            if (selectedProduct != null) {
                shoppingCart.add(selectedProduct);
                JOptionPane.showMessageDialog(this, "Product added to the shopping cart.");
            }
        }
    }

    private void viewShoppingCart() {
        DefaultTableModel cartTableModel = new DefaultTableModel();
        cartTableModel.addColumn("Product ID");
        cartTableModel.addColumn("Quantity");
        cartTableModel.addColumn("Price");

        JTable cartTable = new JTable(cartTableModel);
        double totalPrice = 0;

        for (Product product : shoppingCart) {
            Object[] rowData = {product.getProduct_ID(), product.getProduct_Name(), product.getProductPrice()};
            cartTableModel.addRow(rowData);
            totalPrice += product.getProductPrice();
        }

        JPanel cartPanel = new JPanel(new BorderLayout());
        cartPanel.add(new JScrollPane(cartTable), BorderLayout.CENTER);
        cartPanel.add(new JLabel("Total Price: " + totalPrice + "£"), BorderLayout.SOUTH);
        // cartPanel.add(new JLabel("FirstPurchaseDiacount(10%): " + totalPrice+"£"), BorderLayout.EAST);


        JOptionPane.showMessageDialog(this, cartPanel, "Shopping Cart", JOptionPane.PLAIN_MESSAGE);
    }

    private double applyDiscounts(double totalPrice) {
        return totalPrice;
    }

    private Product findProductById(String productId) {
        for (Product product : WestminsterShoppingManager.Product_Array) {
            if (product.getProduct_ID().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI();
            }
        });
    }
}


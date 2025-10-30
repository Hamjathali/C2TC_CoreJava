package com.tnsif.onlineshopping.application;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import com.tnsif.onlineshopping.entities.*;
import com.tnsif.onlineshopping.services.*;

public class OnlineShopping {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();
        AdminService adminService = new AdminService(productService, orderService);
        CustomerService customerService = new CustomerService(productService, orderService);

        while (true) {
            System.out.println("\n1. Admin Menu");
            System.out.println("2. Customer Menu");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    adminMenu(sc, adminService);
                    break;
                case 2:
                    customerMenu(sc, customerService, productService);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // ==================== ADMIN MENU ====================
    private static void adminMenu(Scanner sc, AdminService adminService) {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. View Products");
            System.out.println("4. Create Admin");
            System.out.println("5. View Admins");
            System.out.println("6. Update Order Status");
            System.out.println("7. View Orders");
            System.out.println("8. Return");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int pid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Product Name: ");
                    String pname = sc.nextLine();
                    System.out.print("Enter Product Price: ");
                    double price = sc.nextDouble();
                    System.out.print("Enter Stock Quantity: ");
                    int qty = sc.nextInt();
                    Product product = new Product(pid, pname, price, qty);
                    adminService.addProduct(product);
                    System.out.println("Product added successfully!");
                    break;

                case 2:
                    System.out.print("Enter Product ID to remove: ");
                    int removeId = sc.nextInt();
                    adminService.removeProduct(removeId);
                    System.out.println("Product removed successfully!");
                    break;

                case 3:
                    List<Product> products = adminService.viewProducts();
                    if (products.isEmpty())
                        System.out.println("No products found.");
                    else {
                        System.out.println("Products:");
                        for (Product p : products)
                            System.out.println(p);
                    }
                    break;

                case 4:
                    System.out.print("Enter Admin ID: ");
                    int aid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Username: ");
                    String aname = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String aemail = sc.nextLine();
                    adminService.createAdmin(new Admin(aid, aname, aemail));
                    System.out.println("Admin created successfully!");
                    break;

                case 5:
                    List<Admin> admins = adminService.getAllAdmins();
                    if (admins.isEmpty())
                        System.out.println("No admins found.");
                    else {
                        System.out.println("Admins:");
                        for (Admin a : admins)
                            System.out.println(a);
                    }
                    break;

                case 6:
                    System.out.print("Enter Order ID: ");
                    int oid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new status (Completed/Delivered/Cancelled): ");
                    String status = sc.nextLine();
                    adminService.updateOrderStatus(oid, status);
                    System.out.println("Order status updated!");
                    break;

                case 7:
                    List<Order> orders = adminService.viewAllOrders();
                    if (orders.isEmpty())
                        System.out.println("No orders found.");
                    else {
                        System.out.println("Orders:");
                        for (Order o : orders)
                            System.out.println(o);
                    }
                    break;

                case 8:
                    System.out.println("Exiting Admin...");
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // ==================== CUSTOMER MENU ====================
    private static void customerMenu(Scanner sc, CustomerService customerService, ProductService productService) {
        while (true) {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. Create Customer");
            System.out.println("2. View Customers");
            System.out.println("3. Place Order");
            System.out.println("4. View Orders");
            System.out.println("5. View Products");
            System.out.println("6. Return");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter User ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Username: ");
                    String uname = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter Address: ");
                    String addr = sc.nextLine();
                    customerService.createCustomer(new Customer(uid, uname, email, addr));
                    System.out.println("Customer created successfully!");
                    break;

                case 2:
                    List<Customer> customers = customerService.getAllCustomers();
                    if (customers.isEmpty())
                        System.out.println("No customers found.");
                    else {
                        System.out.println("Customers:");
                        for (Customer c : customers)
                            System.out.println(c);
                    }
                    break;

                case 3:
                    System.out.print("Enter Customer ID: ");
                    int cid = sc.nextInt();
                    Customer cust = customerService.getCustomerById(cid);
                    if (cust == null) {
                        System.out.println("Customer not found!");
                        break;
                    }
                    while (true) {
                        System.out.print("Enter Product ID to add to order (or -1 to complete): ");
                        int prid = sc.nextInt();
                        if (prid == -1)
                            break;
                        Product p = productService.getProductById(prid);
                        if (p == null) {
                            System.out.println("Invalid Product ID!");
                            continue;
                        }
                        System.out.print("Enter quantity: ");
                        int quantity = sc.nextInt();
                        if (quantity > p.getStockQuantity()) {
                            System.out.println("Not enough stock!");
                        } else {
                            cust.getShoppingCart().addItem(p, quantity);
                        }
                    }
                    customerService.placeOrder(cid);
                    break;

                case 4:
                    System.out.print("Enter Customer ID: ");
                    int ocid = sc.nextInt();
                    Customer c = customerService.getCustomerById(ocid);
                    if (c != null && !c.getOrders().isEmpty()) {
                        System.out.println("Orders:");
                        for (Order o : c.getOrders())
                            System.out.println(o);
                    } else {
                        System.out.println("No orders found for this customer.");
                    }
                    break;

                case 5:
                    List<Product> prods = productService.getAllProducts();
                    if (prods.isEmpty())
                        System.out.println("No products available.");
                    else {
                        System.out.println("Products:");
                        for (Product p : prods)
                            System.out.println(p);
                    }
                    break;

                case 6:
                    System.out.println("Exiting Customer Menu...");
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}

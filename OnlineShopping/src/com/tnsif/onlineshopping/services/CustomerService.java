package com.tnsif.onlineshopping.services;

import java.util.ArrayList;
import java.util.List;
import com.tnsif.onlineshopping.entities.Customer;
import com.tnsif.onlineshopping.entities.Order;
import com.tnsif.onlineshopping.entities.Product;
import com.tnsif.onlineshopping.entities.ShoppingCart;

public class CustomerService {
    private List<Customer> customers = new ArrayList<>();
    private ProductService productService;
    private OrderService orderService;

    public CustomerService(ProductService productService, OrderService orderService) {
        this.productService = productService;
        this.orderService = orderService;
    }

    public void createCustomer(Customer customer) {
        customers.add(customer);
    }

    public List<Customer> getAllCustomers() {
        return customers;
    }

    public Customer getCustomerById(int customerId) {
        for (Customer c : customers) {
            if (c.getUserId() == customerId) {
                return c;
            }
        }
        return null;
    }

    public void placeOrder(int customerId) {
        Customer customer = getCustomerById(customerId);
        if (customer != null) {
            ShoppingCart cart = customer.getShoppingCart();
            if (!cart.getItems().isEmpty()) {
                Order order = new Order(customer);
                cart.getItems().forEach((product, quantity) -> {
                    if (product.getStockQuantity() >= quantity) {
                        order.addProduct(product, quantity);
                        product.setStockQuantity(product.getStockQuantity() - quantity);
                    }
                });
                orderService.addOrder(order);
                customer.addOrder(order);
                cart.clearCart();
                System.out.println("Order placed successfully!");
            } else {
                System.out.println("Shopping cart is empty!");
            }
        } else {
            System.out.println("Customer not found!");
        }
    }
}

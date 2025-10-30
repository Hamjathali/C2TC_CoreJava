package com.tnsif.onlineshopping.services;

import java.util.ArrayList;
import java.util.List;
import com.tnsif.onlineshopping.entities.Admin;
import com.tnsif.onlineshopping.entities.Order;
import com.tnsif.onlineshopping.entities.Product;

public class AdminService {
    private List<Admin> admins = new ArrayList<>();
    private ProductService productService;
    private OrderService orderService;

    public AdminService(ProductService productService, OrderService orderService) {
        this.productService = productService;
        this.orderService = orderService;
    }

    public void createAdmin(Admin admin) {
        admins.add(admin);
    }

    public List<Admin> getAllAdmins() {
        return admins;
    }

    public void addProduct(Product product) {
        productService.addProduct(product);
    }

    public void removeProduct(int productId) {
        productService.removeProduct(productId);
    }

    public List<Product> viewProducts() {
        return productService.getAllProducts();
    }

    public void updateOrderStatus(int orderId, String status) {
        orderService.updateOrderStatus(orderId, status);
    }

    public List<Order> viewAllOrders() {
        return orderService.getAllOrders();
    }
}

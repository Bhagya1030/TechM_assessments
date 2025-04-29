package com.aits.E_Commerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aits.E_Commerce.entity.Item;
import com.aits.E_Commerce.entity.Order;
import com.aits.E_Commerce.repository.CustomerRepository;
import com.aits.E_Commerce.repository.ItemRepository;
import com.aits.E_Commerce.repository.OrderRepository;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        // Save Customer if not managed
        if (order.getCustomer() != null) {
            customerRepository.findById(order.getCustomer().getId())
                .ifPresent(order::setCustomer);
        }

        // Save Items if not managed
        if (order.getItemsList() != null) {
            List<Item> managedItems = order.getItemsList().stream()
                .map(item -> itemRepository.findById(item.getId()).orElse(item))
                .toList();
            order.setItemsList(managedItems);
        }

        return orderRepository.save(order);
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order order) {
        order.setId(id);
        return orderRepository.save(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderRepository.deleteById(id);
    }

    @GetMapping("/customer/{customerId}")
    public List<Order> getOrdersByCustomerId(@PathVariable Long customerId) {
        return orderRepository.findOrdersByCustomerId(customerId);
    }
}

package brave.crudproject1.controllers;

import brave.crudproject1.dto.customer.OrderDTO;
import brave.crudproject1.entities.Customer;
import brave.crudproject1.entities.Order;
import brave.crudproject1.repositories.CustomerRepository;
import brave.crudproject1.repositories.OrderRepository;
import brave.crudproject1.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/{customerId}")
    public ResponseEntity<String> createOrder(@RequestBody OrderDTO orderDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body("Order created successfully");
    }
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable Long id) {
        return orderService.updateOrder(id);
    }
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}

package brave.crudproject1.controllers;

import brave.crudproject1.dto.OrderDTO;
import brave.crudproject1.entities.Order;
import brave.crudproject1.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/{customerId}")
    public ResponseEntity<Order> createOrder( @PathVariable Long customerId,@RequestBody OrderDTO orderDTO) {
        Order createdOrder = orderService.createOrder(customerId,orderDTO);
        return ResponseEntity.status(201).body(createdOrder);
    }
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
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

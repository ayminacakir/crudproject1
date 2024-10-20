package brave.crudproject1.services;

import brave.crudproject1.dto.customer.OrderDTO;
import brave.crudproject1.entities.Customer;
import brave.crudproject1.entities.Order;
import brave.crudproject1.repositories.CustomerRepository;
import brave.crudproject1.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public Order createOrder(Long customerId, OrderDTO orderDTO) {
        Order order = new Order();
        order.setOrderDate(LocalDate.now());

        // Müşteriyi bul ve siparişe ata
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        order.setCustomer(customer);

        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    public Order updateOrder(Long id){
        return orderRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Order not found"));
    }
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
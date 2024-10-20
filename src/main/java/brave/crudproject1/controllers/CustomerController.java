package brave.crudproject1.controllers;

import brave.crudproject1.dto.customer.CustomerDTO;
import brave.crudproject1.entities.Customer;
import brave.crudproject1.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }
    @PostMapping
    public ResponseEntity<String> createCustomer(@RequestBody CustomerDTO customerDTO){
        String name =customerDTO.getName();
        String email = customerDTO.getEmail();

        return ResponseEntity.ok("Customer created successfully");
    }

    @PutMapping
    public Customer updateCustomer(@PathVariable Long id) {
        return customerService.updateCustomer(id);
    }
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }
}
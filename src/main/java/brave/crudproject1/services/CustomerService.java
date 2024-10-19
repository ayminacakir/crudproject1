package brave.crudproject1.services;

import brave.crudproject1.entities.Customer;
import brave.crudproject1.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService { // Bu sınıf, müşteri verileri üzerinde CRUD (Create, Read, Update, Delete) işlemlerini gerçekleştirmek için kullanılır:
    @Autowired
    private CustomerRepository customerRepository; /* Bu örnekte CustomerRepository otomatik olarak enjekte edilmemiş, yani @Autowired kullanılarak dependency injection yapılmamış. Bağımlılık enjeksiyonu eklenirse daha iyi olur.*/

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id){
        return customerRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Customer not found"));
            }
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}


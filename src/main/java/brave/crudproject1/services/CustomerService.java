package brave.crudproject1.services;

import brave.crudproject1.dto.CustomerDTO;
import brave.crudproject1.entities.Customer;
import brave.crudproject1.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService { // Bu sınıf, müşteri verileri üzerinde CRUD (Create, Read, Update, Delete) işlemlerini gerçekleştirmek için kullanılır:
    @Autowired
    private CustomerRepository customerRepository; /*@Autowired kullanılarak dependency injection yaptım.*/

    public List<Customer> getAllCustomers()  {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public Customer createCustomer(CustomerDTO customerDTO) {

        if(customerRepository.existsByEmail(customerDTO.getEmail())){
            throw new RuntimeException("Email is already using.");
        }

        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhone(customerDTO.getPhone());

        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, CustomerDTO customerDTO) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        if (!customer.getEmail().equals(customerDTO.getEmail()) && customerRepository.existsByEmail(customerDTO.getEmail())) { //customerdto da  güncellemek istediğim müşteri bilgileri yer alıyor. customer mevcut veri tabanında kayıtlı olan müşteri bilgileri yer alıyor.
            throw new RuntimeException("Email" + customerDTO.getEmail() + "is already in use by another customer.");
        }
    //if kontrolünden sonra set metodlarının kullanılmasının sebebi, güncelleme işleminden önce gerekli doğrulamaları yapmaktır.
        customer.setName(customerDTO.getName()); //Bu satırlarda, customerDTO içindeki güncellenmiş bilgiler mevcut müşteri kaydına atanır.
        customer.setEmail(customerDTO.getEmail());
        customer.setPhone(customerDTO.getPhone());

        return customerRepository.save(customer);//Müşteri Kaydını veritabanında güncelledim.
    }

    public void deleteCustomer(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new RuntimeException("Customer not found");
        }
        customerRepository.deleteById(id);
    }
}



































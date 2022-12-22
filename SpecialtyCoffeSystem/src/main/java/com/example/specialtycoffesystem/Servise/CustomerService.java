package com.example.specialtycoffesystem.Servise;

import com.example.specialtycoffesystem.Model.Customer;
import com.example.specialtycoffesystem.Model.DripCoffee;
import com.example.specialtycoffesystem.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
   private final CustomerRepository customerRepository;

    public List<Customer> getCus() {
        return customerRepository.findAll();
    }

    public void addCus(Customer customer) {
        customerRepository.save(customer);
    }

    public boolean upCus(Integer id, Customer customer) {
        Customer oldCus =customerRepository.findCustomerById(id);
        if(oldCus==null)return false;
        oldCus.setEmail(customer.getEmail());
        oldCus.setPassword(customer.getPassword());
        oldCus.setUser(customer.getUser());
        customerRepository.save(customer);
        return true;

    }

    public boolean delCus(Integer id) {
        Customer customer = customerRepository.findCustomerById(id);
        if(customer==null)return false;
        customerRepository.delete(customer);
        return true;
    }
}

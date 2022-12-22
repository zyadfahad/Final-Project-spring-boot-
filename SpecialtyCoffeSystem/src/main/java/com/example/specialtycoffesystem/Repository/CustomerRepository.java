package com.example.specialtycoffesystem.Repository;

import com.example.specialtycoffesystem.Model.Customer;
import com.example.specialtycoffesystem.Model.Espresso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer findCustomerById(Integer ID);

}

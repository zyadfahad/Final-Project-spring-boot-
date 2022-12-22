package com.example.specialtycoffesystem.Controller;

import com.example.specialtycoffesystem.Model.Customer;
import com.example.specialtycoffesystem.Model.DripCoffee;
import com.example.specialtycoffesystem.Servise.CustomerService;
import com.example.specialtycoffesystem.Servise.DripCoffeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
    @GetMapping("/cus/getall")
    public ResponseEntity getCus(){
        List<Customer> customers = customerService.getCus();
        return ResponseEntity.status(200).body(customers);
    }
    @PostMapping("/cus/add")
    public ResponseEntity addCus(@RequestBody  Customer customer){
        customerService.addCus(customer);
        return ResponseEntity.status(200).body("Customer added");
    }
    @PutMapping("/cus/up/{id}")
    public ResponseEntity upCus(@PathVariable Integer id, @RequestBody Customer customer){
        if(customerService.upCus(id,customer))return   ResponseEntity.status(200).body("Customer updated");
        return ResponseEntity.status(400).body("Wrong  Customer ID");
    }
    @DeleteMapping("/cus/del/{id}")
    public ResponseEntity delCus(@PathVariable Integer id){
        if(customerService.delCus(id))return ResponseEntity.status(200).body("Customer Deleted");
        return ResponseEntity.status(400).body("Wrong Customer ID");
    }
}


package com.example.specialtycoffesystem.Repository;

import com.example.specialtycoffesystem.Model.CoffeeBeen;
import com.example.specialtycoffesystem.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoffeeBeenRepository extends JpaRepository<CoffeeBeen,Integer> {
   CoffeeBeen findCoffeeBeenById(Integer id);
   List<CoffeeBeen> findAllByBrand(String brand);

   List<CoffeeBeen> findAllByProcess(String process);

}

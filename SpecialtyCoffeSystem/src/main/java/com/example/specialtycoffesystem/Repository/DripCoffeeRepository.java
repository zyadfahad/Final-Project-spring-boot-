package com.example.specialtycoffesystem.Repository;

import com.example.specialtycoffesystem.Model.DripCoffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DripCoffeeRepository extends JpaRepository<DripCoffee,Integer> {
    DripCoffee findDripCoffeeById(Integer id);
}

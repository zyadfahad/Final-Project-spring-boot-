package com.example.specialtycoffesystem.Servise;

import com.example.specialtycoffesystem.Model.DripCoffee;
import com.example.specialtycoffesystem.Repository.DripCoffeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DripCoffeeService {
    private final DripCoffeeRepository dripCoffeeRepository;

    public List<DripCoffee> getDripCof() {
       return dripCoffeeRepository.findAll();
    }

    public void addDripCof(DripCoffee dripCoffee) {
        dripCoffeeRepository.save(dripCoffee);
    }

    public boolean upDripCof(Integer id, DripCoffee dripCoffee) {
        DripCoffee oldDripCoffee = dripCoffeeRepository.findDripCoffeeById(id);
        if (oldDripCoffee==null)return false;
        oldDripCoffee.setBrand(dripCoffee.getBrand());
        oldDripCoffee.setPrice(dripCoffee.getPrice());
        oldDripCoffee.setQuantity(dripCoffee.getQuantity());
        oldDripCoffee.setToolType(dripCoffee.getToolType());
         dripCoffeeRepository.save(dripCoffee);
        return true;
    }

    public boolean delDripCof(Integer id) {
        DripCoffee dripCoffee = dripCoffeeRepository.findDripCoffeeById(id);
        if(dripCoffee==null)return false;
        dripCoffeeRepository.delete(dripCoffee);
        return true;
    }
}

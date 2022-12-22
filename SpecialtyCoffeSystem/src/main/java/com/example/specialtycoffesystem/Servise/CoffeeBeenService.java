package com.example.specialtycoffesystem.Servise;

import com.example.specialtycoffesystem.Exception.ApiException;
import com.example.specialtycoffesystem.Model.CoffeeBeen;
import com.example.specialtycoffesystem.Repository.CoffeeBeenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CoffeeBeenService {
    public final CoffeeBeenRepository coffeeBeenRepository;

    public List<CoffeeBeen> getCofBeen() {
        return coffeeBeenRepository.findAll();
    }
    public  void addCofBeen(CoffeeBeen coffeeBeen) {
        coffeeBeenRepository.save(coffeeBeen);
    }

    public boolean upCofBeen(Integer id, CoffeeBeen coffeeBeen) {
        CoffeeBeen oldcofbeen = coffeeBeenRepository.findCoffeeBeenById(id);
        if (oldcofbeen == null) return false;
         oldcofbeen.setBrand(coffeeBeen.getBrand());
         oldcofbeen.setCountry(coffeeBeen.getCountry());
         oldcofbeen.setProcess(coffeeBeen.getProcess());
         oldcofbeen.setPrice(coffeeBeen.getPrice());
         oldcofbeen.setQuantity(coffeeBeen.getQuantity());
         coffeeBeenRepository.save(oldcofbeen);
         return true;
    }

    public boolean delCofBeen(Integer id) {
        CoffeeBeen coffeeBeen = coffeeBeenRepository.findCoffeeBeenById(id);
        if(coffeeBeen==null)return false;
        coffeeBeenRepository.delete(coffeeBeen);
        return true;
    }

    public List<CoffeeBeen> getByBrand(String brand) {
        List<CoffeeBeen> coffeeBeens = coffeeBeenRepository.findAllByBrand(brand);
        if(coffeeBeens==null)throw new ApiException("wrong Brand");
        return coffeeBeens;
    }

    public List<CoffeeBeen> getByProcess(String process) {
        List<CoffeeBeen>coffeeBeens = coffeeBeenRepository.findAllByProcess(process);
        if(coffeeBeens==null)throw new ApiException("Wrong process");
        return coffeeBeens;
    }
}

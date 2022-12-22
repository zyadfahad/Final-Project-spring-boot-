package com.example.specialtycoffesystem.Controller;

import com.example.specialtycoffesystem.Exception.ApiException;
import com.example.specialtycoffesystem.Model.CoffeeBeen;
import com.example.specialtycoffesystem.Servise.CoffeeBeenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;import com.example.specialtycoffesystem.Model.CoffeeBeen;
import com.example.specialtycoffesystem.Servise.CoffeeBeenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CoffeeBeenController {

    private final CoffeeBeenService coffeeBeenService;

    @GetMapping("/coffeebeen/getall")
    public ResponseEntity getCofbeen(){
        List<CoffeeBeen> coffeeBeens = coffeeBeenService.getCofBeen();
        return ResponseEntity.status(200).body(coffeeBeens);
    }
    @PostMapping("/coffeebeen/add")
    public ResponseEntity addCofBeen(@RequestBody CoffeeBeen coffeeBeen){
        coffeeBeenService.addCofBeen(coffeeBeen);
        return ResponseEntity.status(200).body("Coffee Been added");
    }
    @PutMapping("/coffeebeen/up/{id}")
    public ResponseEntity upCofBeen(@PathVariable Integer id,@RequestBody CoffeeBeen coffeeBeen){
        if(coffeeBeenService.upCofBeen(id,coffeeBeen)) return ResponseEntity.status(200).body("Coffee Been Updated");
        return ResponseEntity.status(400).body("Wrong Item ID");

    }
    @DeleteMapping("/coffeebeen/del/{id}")
    public ResponseEntity delCofBeen(@PathVariable Integer id){
        if(coffeeBeenService.delCofBeen(id))return ResponseEntity.status(400).body("Coffee Been deleted");
       return ResponseEntity.status(400).body("Wrong Coffee Been ID");
    }
    @GetMapping("/coffeebeen/bybrand/{brand}")
    public ResponseEntity getCofBeenByBrand(@PathVariable String brand){
        List<CoffeeBeen> coffeeBeens = coffeeBeenService.getByBrand(brand);
        if(coffeeBeens==null)throw new ApiException("wrong Brand");
        return ResponseEntity.status(200).body(coffeeBeens);
    }
    @GetMapping("/coffeebeen/byprocess/{process}")
    public ResponseEntity getCofBeenByProcess(@PathVariable String process){
        List<CoffeeBeen> coffeeBeens= coffeeBeenService.getByProcess(process);
        return ResponseEntity.status(200).body(coffeeBeens);
    }


}

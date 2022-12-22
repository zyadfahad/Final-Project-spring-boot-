package com.example.specialtycoffesystem.Controller;

import com.example.specialtycoffesystem.Model.DripCoffee;
import com.example.specialtycoffesystem.Servise.CoffeeBeenService;
import com.example.specialtycoffesystem.Servise.DripCoffeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class DripCoffeeController {
    private final DripCoffeeService dripCoffeeService;
    @GetMapping("/drip/getall")
    public ResponseEntity getDripCof(){
      List<DripCoffee> dripCoffees = dripCoffeeService.getDripCof();
        return ResponseEntity.status(200).body(dripCoffees);
    }
    @PostMapping("/drip/add")
    public ResponseEntity addDripCof(@RequestBody DripCoffee dripCoffee){
        dripCoffeeService.addDripCof(dripCoffee);
        return ResponseEntity.status(200).body("Drip Coffee added");
    }
    @PutMapping("/drip/up/{id}")
    public ResponseEntity upDripCof(@PathVariable Integer id, @RequestBody DripCoffee dripCoffee){
        if(dripCoffeeService.upDripCof(id,dripCoffee))return   ResponseEntity.status(200).body("Drip Coffee updated");
        return ResponseEntity.status(400).body("Wrong Coffee Drip ID");
    }
    @DeleteMapping("/drip/del/{id}")
    public ResponseEntity delDripCof(@PathVariable Integer id){
        if(dripCoffeeService.delDripCof(id))return ResponseEntity.status(200).body("Drip Coffee Deleted");
        return ResponseEntity.status(400).body("Wrong Drip Coffee ID");

    }
}

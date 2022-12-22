package com.example.specialtycoffesystem.Controller;

import com.example.specialtycoffesystem.Model.Espresso;
import com.example.specialtycoffesystem.Servise.EspressoServise;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class EspressoController {
    private final EspressoServise espressoServise;
    @GetMapping("/esp/getall")
    public ResponseEntity getAllEsp(){
        List<Espresso> espresso = espressoServise.getEsp();
        return ResponseEntity.status(200).body(espresso);
    }
    @PostMapping("/esp/add")
    public ResponseEntity addEsp(@RequestBody Espresso espresso){
        espressoServise.addEsp(espresso);
        return ResponseEntity.status(200).body("Espresso added");

    }
    @PutMapping("/esp/up/{id}")
    public ResponseEntity upEsp(@PathVariable Integer id,@RequestBody Espresso espresso){
        if(espressoServise.upEsp(id,espresso))return ResponseEntity.status(200).body("Espresso Updated");
         return ResponseEntity.status(400).body("Wrong Espresso ID");

    }
    @DeleteMapping("/esp/del/{id}")
    public ResponseEntity delEsp(@PathVariable Integer id){
        if(espressoServise.delEsp(id))return ResponseEntity.status(200).body("Espresso Deleted");
        return ResponseEntity.status(400).body("Wrong Espresso ID");
    }

}

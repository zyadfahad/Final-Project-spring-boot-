package com.example.specialtycoffesystem.Servise;

import com.example.specialtycoffesystem.Model.Espresso;
import com.example.specialtycoffesystem.Repository.EspressoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EspressoServise {
   private final EspressoRepository espressoRepository;
    public List<Espresso> getEsp() {
       return espressoRepository.findAll();
    }

    public void addEsp(Espresso espresso) {
        espressoRepository.save(espresso);
    }

    public boolean upEsp(Integer id, Espresso espresso) {
        Espresso oldEsp = espressoRepository.findEspressoById(id);
        if(oldEsp==null)return false;
        oldEsp.setBrand(espresso.getBrand());
        oldEsp.setPrice(espresso.getPrice());
        oldEsp.setToolType(espresso.getToolType());
        oldEsp.setQuantity(espresso.getQuantity());
        espressoRepository.save(espresso);
        return true;
    }

    public boolean delEsp(Integer id) {
        Espresso espresso = espressoRepository.findEspressoById(id);
        if(espresso==null)return false;
        espressoRepository.delete(espresso);
        return true;
    }
}

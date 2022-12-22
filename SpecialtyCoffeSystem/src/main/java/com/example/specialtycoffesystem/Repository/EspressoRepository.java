package com.example.specialtycoffesystem.Repository;

import com.example.specialtycoffesystem.Model.Espresso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspressoRepository extends JpaRepository<Espresso,Integer> {
   Espresso findEspressoById(Integer id);
}

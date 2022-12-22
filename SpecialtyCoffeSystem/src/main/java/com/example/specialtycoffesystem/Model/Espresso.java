package com.example.specialtycoffesystem.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Espresso {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @NotEmpty(message = "brand is null")
    private String brand;
    @NotEmpty(message = "tool type is null")
    private String toolType;
    @NotNull(message = "price is null")
    private Integer price;
    @NotNull(message = "quantity is null")
    private Integer quantity;
}

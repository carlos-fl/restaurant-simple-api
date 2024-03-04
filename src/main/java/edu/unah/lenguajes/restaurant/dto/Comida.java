package edu.unah.lenguajes.restaurant.dto;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Comida {
  
  private String nombre;
  private float precio;
  private ArrayList<Ingrediente> ingredientes = new ArrayList<>();

}

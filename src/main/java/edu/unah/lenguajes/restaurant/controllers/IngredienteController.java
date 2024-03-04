package edu.unah.lenguajes.restaurant.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.unah.lenguajes.restaurant.dto.Ingrediente;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/restaurante")
public class IngredienteController {
  static ArrayList<Ingrediente> ingredientes = new ArrayList<>();

  @GetMapping("/ingredientes")
  public ArrayList<Ingrediente> showIngredientes() {
      return ingredientes;
  }

  @SuppressWarnings({ "rawtypes", "unlikely-arg-type" })
  @PostMapping("/ingredientes/agregar")
  public ResponseEntity agregarIngrediente(@RequestBody Ingrediente ingrediente) {
    for (Ingrediente ing : ingredientes) {
      if (ing.getClass().equals(ingrediente.getCodigo()))
        return new ResponseEntity<>("Codigo ya existe", HttpStatus.OK);
    }
    ingredientes.add(ingrediente);
    return new ResponseEntity<>("ingrediente guardado", HttpStatus.OK);
  }
  
}

package edu.unah.lenguajes.restaurant.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;

import edu.unah.lenguajes.restaurant.dto.Comida;
import edu.unah.lenguajes.restaurant.dto.Ingrediente;



@RestController
@RequestMapping("/restaurante")
public class ComidaController {

  private ArrayList<Comida> comidas = new ArrayList<>();
  private ArrayList<Ingrediente> ingredientes = IngredienteController.ingredientes;
  

  @GetMapping("/comidas")
  public ArrayList<Comida> showComidas() {
    return comidas;
  }

  @SuppressWarnings("rawtypes")
  @PostMapping("/comidas/agregar")
  public ResponseEntity addComida(@RequestBody Comida nvComida) {
    ArrayList<Ingrediente> ingredientesEnComida = nvComida.getIngredientes();
    if (!ingredientes.containsAll(ingredientesEnComida)) {
      return new ResponseEntity<>("ingredientes " + ingredientesEnComida + " no encontrado en los ingredientes " + ingredientes, HttpStatus.BAD_REQUEST);
    }
    this.comidas.add(nvComida);
    return new ResponseEntity<>("comida guardada", HttpStatus.OK);
  }

}

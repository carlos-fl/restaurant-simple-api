package edu.unah.lenguajes.restaurant.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

import edu.unah.lenguajes.restaurant.dto.Comida;
import edu.unah.lenguajes.restaurant.dto.Ingrediente;



@RestController
@RequestMapping("/restaurante")
public class ComidaController {

  Set<Comida> comidas = new HashSet<>();
  Set<Ingrediente> ingredientes = IngredienteController.ingredientes;
  

  @GetMapping("/comidas")
  public Set<Comida> showComidas() {
    return comidas;
  }

  @SuppressWarnings("rawtypes")
  @PostMapping("/comidas/agregar")
  public ResponseEntity addComida(@RequestBody Comida nvComida) {
    Iterator<Ingrediente> ingredientesEnComida = nvComida.getIngredientes().iterator();
    while (ingredientesEnComida.hasNext()) {
      if (!ingredientes.contains(ingredientesEnComida.next()))
        return new ResponseEntity<>("ingrediente " + ingredientesEnComida.next() + " no encontrado", HttpStatus.BAD_REQUEST);
    }
    this.comidas.add(nvComida);
    return new ResponseEntity<>("comida guardada", HttpStatus.OK);
  }
  

}

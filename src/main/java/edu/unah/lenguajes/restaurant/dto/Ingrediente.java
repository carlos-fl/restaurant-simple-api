package edu.unah.lenguajes.restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Ingrediente {
  private String codigo;
  private String descripcion;
  
  @Override
  public String toString() {
    return "{ " + "codigo: " + this.codigo + ", " + "descripcion: " + this.descripcion + "}";
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) return true;
    if (object == null || getClass() != object.getClass()) return false;
    Ingrediente ing = (Ingrediente) object;
    return (codigo.equals(ing.codigo) && descripcion.equals(ing.descripcion));
  }
}

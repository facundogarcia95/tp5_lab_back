package com.example.tp5.Models;

import lombok.*;
import jakarta.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "categoria_instrumento")
public class CategoriaInstrumento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String denominacion;

    // Getters y Setters

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDenominacion() {
    return this.denominacion;
  }

  public void setDenominacion(String denominacion) {
    this.denominacion = denominacion;
  }

}
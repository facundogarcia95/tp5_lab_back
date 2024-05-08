package com.example.tp5.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.tp5.Models.CategoriaInstrumento;

@Repository
public interface CategoriaInstrumentoRepository extends JpaRepository<CategoriaInstrumento, Long> {
}

package com.example.tp5.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tp5.Models.Instrumento;
import java.util.List;

@Repository
public interface InstrumentoRepository extends JpaRepository<Instrumento, Long> {

    boolean existsByNombre(String instrumento);

    List<Instrumento> findByActivoTrue();

    List<Instrumento> findByActivoFalse();
}

package com.example.tp5.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.tp5.Models.Instrumento;
import com.example.tp5.Repositories.InstrumentoRepository;

@Service
public class InstrumentoService {

    @Autowired
    private InstrumentoRepository instrumentoRepository;

    public List<Instrumento> listarTodos() {
        return instrumentoRepository.findAll();
    }

    public List<Instrumento> listarActivos() {
        return instrumentoRepository.findByActivoTrue();
    }

    public List<Instrumento> listarInactivos() {
        return instrumentoRepository.findByActivoFalse();
    }

    public Instrumento guardarInstrumento(Instrumento instrumento) {
        return instrumentoRepository.save(instrumento);
    }

    public Instrumento obtenerInstrumentoPorId(Long id) {
        return instrumentoRepository.findById(id).orElse(null);
    }

    public Instrumento eliminarInstrumento(Instrumento instrumento) {
        return instrumentoRepository.save(instrumento);
    }
}

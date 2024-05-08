package com.example.tp5.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tp5.Models.CategoriaInstrumento;
import com.example.tp5.Models.Instrumento;
import com.example.tp5.Repositories.CategoriaInstrumentoRepository;
import com.example.tp5.Repositories.InstrumentoRepository;
import com.example.tp5.Services.InstrumentoService;

@RestController
@RequestMapping("/api/instrumentos")
public class InstrumentoController {

    @Autowired
    private InstrumentoService instrumentoService;

    @Autowired
    private InstrumentoRepository instrumentoReposity;

    @Autowired
    private CategoriaInstrumentoRepository categoriaRepository;

    @GetMapping
    public List<Instrumento> listarTodos() {
        return instrumentoService.listarTodos();
    }

    @GetMapping("/activos")
    public List<Instrumento> listarActivos() {
        return instrumentoService.listarActivos();
    }

    @GetMapping("/inactivos")
    public List<Instrumento> listarInactivos() {
        return instrumentoService.listarInactivos();
    }

    @PostMapping
    public Instrumento agregarInstrumento(@RequestBody Instrumento instrumento) {
        return instrumentoService.guardarInstrumento(instrumento);
    }

    @GetMapping("/{id}")
    public Instrumento obtenerInstrumentoPorId(@PathVariable Long id) {
        return instrumentoService.obtenerInstrumentoPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instrumento> actualizarInstrumento(@PathVariable Long id, @RequestBody Instrumento instrumentoDetalles) {
        Instrumento instrumento = instrumentoService.obtenerInstrumentoPorId(id);
        if (instrumento == null) {
            return ResponseEntity.notFound().build(); // Retorna 404 Not Found
        }

        // Validación de la categoría
        Optional<CategoriaInstrumento> categoriaOpt = categoriaRepository.findById(instrumentoDetalles.getCategoria().getId());
        if (!categoriaOpt.isPresent()) {
            return ResponseEntity.noContent().build();
        }

        instrumento.setNombre(instrumentoDetalles.getNombre());
        instrumento.setMarca(instrumentoDetalles.getMarca());
        instrumento.setModelo(instrumentoDetalles.getModelo());
        instrumento.setImagen(instrumentoDetalles.getImagen());
        instrumento.setPrecio(instrumentoDetalles.getPrecio());
        instrumento.setCostoEnvio(instrumentoDetalles.getCostoEnvio());
        instrumento.setCantidadVendida(instrumentoDetalles.getCantidadVendida());
        instrumento.setCategoria(categoriaOpt.get());
        instrumento.setDescripcion(instrumentoDetalles.getDescripcion());
        instrumentoReposity.save(instrumento);

        // Resto de campos a actualizar
        Instrumento actualizado = instrumentoService.guardarInstrumento(instrumento);
        return ResponseEntity.ok(actualizado); // Retorna 200 OK con el instrumento actualizado
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Instrumento> eliminarInstrumento(@PathVariable Long id) {
        Instrumento instrumento = instrumentoService.obtenerInstrumentoPorId(id);
        instrumento.setActivo(0);
        instrumento = instrumentoService.eliminarInstrumento(instrumento);
        return ResponseEntity.ok(instrumento);
    }
}

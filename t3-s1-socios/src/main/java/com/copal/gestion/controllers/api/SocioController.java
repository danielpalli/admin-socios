package com.copal.gestion.controllers.api;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.copal.gestion.domain.dtos.requests.SocioRequest;
import com.copal.gestion.domain.dtos.responses.SocioResponse;
import com.copal.gestion.services.interfaces.ISocioService;

import lombok.AllArgsConstructor;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/socios")
@AllArgsConstructor
public class SocioController {
    private final ISocioService socioService;
    @PostMapping
    public ResponseEntity<SocioResponse> create(@Valid @RequestBody SocioRequest request) {
        return ResponseEntity.ok(this.socioService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SocioResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(this.socioService.getById(id));
    }
    
    @GetMapping
    public ResponseEntity<Iterable<SocioResponse>> getAll() {
        return ResponseEntity.ok(this.socioService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<SocioResponse> update(@Valid @RequestBody SocioRequest request, @PathVariable Long id) {
        return ResponseEntity.ok(this.socioService.update(request, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        return ResponseEntity.ok(this.socioService.delete(id));
    }

    @GetMapping("/name")
    public ResponseEntity<Iterable<SocioResponse>> getByid(@RequestParam String nombreSocio) {
        return ResponseEntity.ok(this.socioService.findByNombreSocios(nombreSocio));
    }

    @GetMapping("/created-at")
    public ResponseEntity<Iterable<SocioResponse>> getByidfechaAlta(@RequestParam String fechaAlta) {
        LocalDateTime dataFormateada = LocalDateTime.parse(fechaAlta);
        return ResponseEntity.ok(this.socioService.findByFechaAlta(dataFormateada));
    }

    @GetMapping("/type-member")
    public ResponseEntity<Iterable<SocioResponse>> getByidytipoSocio(@RequestParam String tipoSocio) {
        return ResponseEntity.ok(this.socioService.findByTipoSocio(tipoSocio));
    }
}

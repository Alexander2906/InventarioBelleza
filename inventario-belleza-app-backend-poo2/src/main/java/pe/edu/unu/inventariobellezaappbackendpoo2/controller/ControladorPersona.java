package pe.edu.unu.inventariobellezaappbackendpoo2.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.unu.inventariobellezaappbackendpoo2.DTO.request.SolicitudPersona;
import pe.edu.unu.inventariobellezaappbackendpoo2.DTO.response.RespuestaPersona;
import pe.edu.unu.inventariobellezaappbackendpoo2.Util.ModelMapperUtil;
import pe.edu.unu.inventariobellezaappbackendpoo2.entity.Persona;
import pe.edu.unu.inventariobellezaappbackendpoo2.service.IServicioPersona;

import java.util.List;

@RestController
@RequestMapping("api/v1/people")
@RequiredArgsConstructor
public class ControladorPersona {

    private final IServicioPersona service;

    @GetMapping("/pagina/{pagina}/{tamano}")
    public ResponseEntity<Page<RespuestaPersona>> pagina(@PathVariable Integer pagina, @PathVariable Integer tamano) {
        Page<RespuestaPersona> paginaPersonas = service.pagina(pagina, tamano);
        return new ResponseEntity<>(paginaPersonas, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RespuestaPersona>> todos() {
        List<Persona> personas = service.todos();
        List<RespuestaPersona> respuesta = personas.stream()
                .map(p -> ModelMapperUtil.convertTo(p, RespuestaPersona.class))
                .toList();
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespuestaPersona> porId(@PathVariable Integer id) {
        Persona persona = service.porId(id);
        return ResponseEntity.ok(ModelMapperUtil.convertTo(persona, RespuestaPersona.class));
    }

    @PostMapping
    public ResponseEntity<RespuestaPersona> guardar(@Valid @RequestBody SolicitudPersona solicitud) {
        Persona persona = ModelMapperUtil.convertTo(solicitud, Persona.class);
        Persona guardada = service.guardar(persona);
        return new ResponseEntity<>(ModelMapperUtil.convertTo(guardada, RespuestaPersona.class), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RespuestaPersona> actualizar(@PathVariable Integer id, @Valid @RequestBody SolicitudPersona solicitud) {
        Persona persona = ModelMapperUtil.convertTo(solicitud, Persona.class);
        persona.setId(id);
        Persona actualizada = service.guardar(persona);
        return ResponseEntity.ok(ModelMapperUtil.convertTo(actualizada, RespuestaPersona.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}


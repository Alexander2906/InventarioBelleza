package pe.edu.unu.inventariobellezaappbackendpoo2.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.unu.inventariobellezaappbackendpoo2.DTO.request.StockMovementRequest;
import pe.edu.unu.inventariobellezaappbackendpoo2.DTO.response.StockMovementResponse;
import pe.edu.unu.inventariobellezaappbackendpoo2.Util.ModelMapperUtil;
import pe.edu.unu.inventariobellezaappbackendpoo2.entity.StockMovement;
import pe.edu.unu.inventariobellezaappbackendpoo2.service.IServicioMovimientoStock;

import java.util.List;

@RestController
@RequestMapping("api/v1/stock-movements")
@RequiredArgsConstructor
public class ControladorMovimientoStock {

    private final IServicioMovimientoStock service;

    @GetMapping("/pagina/{pagina}/{tamano}")
    public ResponseEntity<Page<StockMovementResponse>> pagina(@PathVariable Integer pagina, @PathVariable Integer tamano) {
        Page<StockMovementResponse> paginaMovimientos = service.pagina(pagina, tamano);
        return new ResponseEntity<>(paginaMovimientos, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<StockMovementResponse>> todos() {
        List<StockMovement> movimientos = service.todos();
        List<StockMovementResponse> respuesta = movimientos.stream()
                .map(m -> ModelMapperUtil.convertTo(m, StockMovementResponse.class))
                .toList();
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockMovementResponse> porId(@PathVariable Integer id) {
        StockMovement movimiento = service.porId(id);
        return ResponseEntity.ok(ModelMapperUtil.convertTo(movimiento, StockMovementResponse.class));
    }

    @PostMapping
    public ResponseEntity<StockMovementResponse> guardar(@Valid @RequestBody StockMovementRequest solicitud) {
        StockMovement movimiento = ModelMapperUtil.convertTo(solicitud, StockMovement.class);
        StockMovement guardado = service.guardar(movimiento);
        return new ResponseEntity<>(ModelMapperUtil.convertTo(guardado, StockMovementResponse.class), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StockMovementResponse> actualizar(@PathVariable Integer id, @Valid @RequestBody StockMovementRequest solicitud) {
        StockMovement movimiento = ModelMapperUtil.convertTo(solicitud, StockMovement.class);
        movimiento.setId(id);
        StockMovement actualizado = service.guardar(movimiento);
        return ResponseEntity.ok(ModelMapperUtil.convertTo(actualizado, StockMovementResponse.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}


package pe.edu.unu.inventariobellezaappbackendpoo2.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.unu.inventariobellezaappbackendpoo2.DTO.request.SupplierRequest;
import pe.edu.unu.inventariobellezaappbackendpoo2.DTO.response.SupplierResponse;
import pe.edu.unu.inventariobellezaappbackendpoo2.Util.ModelMapperUtil;
import pe.edu.unu.inventariobellezaappbackendpoo2.entity.Supplier;
import pe.edu.unu.inventariobellezaappbackendpoo2.service.ISupplierService;

import java.util.List;

@RestController
@RequestMapping("api/v1/suppliers")
@RequiredArgsConstructor
public class ControladorProveedor {

    private final ISupplierService service;

    @GetMapping("/pagina/{pagina}/{tamano}")
    public ResponseEntity<Page<SupplierResponse>> pagina(@PathVariable Integer pagina, @PathVariable Integer tamano) {
        Page<SupplierResponse> paginaProveedores = service.page(pagina, tamano);
        return new ResponseEntity<>(paginaProveedores, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SupplierResponse>> todos() {
        List<Supplier> proveedores = service.findAll();
        List<SupplierResponse> respuesta = proveedores.stream()
                .map(p -> ModelMapperUtil.convertTo(p, SupplierResponse.class))
                .toList();
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierResponse> porId(@PathVariable Integer id) {
        Supplier proveedor = service.findById(id);
        return ResponseEntity.ok(ModelMapperUtil.convertTo(proveedor, SupplierResponse.class));
    }

    @PostMapping
    public ResponseEntity<SupplierResponse> guardar(@Valid @RequestBody SupplierRequest solicitud) {
        Supplier proveedor = ModelMapperUtil.convertTo(solicitud, Supplier.class);
        Supplier guardado = service.save(proveedor);
        return new ResponseEntity<>(ModelMapperUtil.convertTo(guardado, SupplierResponse.class), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupplierResponse> actualizar(@PathVariable Integer id, @Valid @RequestBody SupplierRequest solicitud) {
        Supplier proveedor = ModelMapperUtil.convertTo(solicitud, Supplier.class);
        proveedor.setId(id);
        Supplier actualizado = service.save(proveedor);
        return ResponseEntity.ok(ModelMapperUtil.convertTo(actualizado, SupplierResponse.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}


package pe.edu.unu.inventariobellezaappbackendpoo2.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.unu.inventariobellezaappbackendpoo2.DTO.request.ProductRequest;
import pe.edu.unu.inventariobellezaappbackendpoo2.DTO.response.ProductResponse;
import pe.edu.unu.inventariobellezaappbackendpoo2.Util.ModelMapperUtil;
import pe.edu.unu.inventariobellezaappbackendpoo2.entity.Product;
import pe.edu.unu.inventariobellezaappbackendpoo2.service.IServicioProducto;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ControladorProducto {

    private final IServicioProducto service;

    @GetMapping("/pagina/{pagina}/{tamano}")
    public ResponseEntity<Page<ProductResponse>> pagina(@PathVariable Integer pagina, @PathVariable Integer tamano) {
        Page<ProductResponse> paginaProductos = service.pagina(pagina, tamano);
        return new ResponseEntity<>(paginaProductos, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> todos() {
        List<Product> productos = service.todos();
        List<ProductResponse> respuesta = productos.stream()
                .map(p -> ModelMapperUtil.convertTo(p, ProductResponse.class))
                .toList();
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> porId(@PathVariable Integer id) {
        Product producto = service.porId(id);
        return ResponseEntity.ok(ModelMapperUtil.convertTo(producto, ProductResponse.class));
    }

    @PostMapping
    public ResponseEntity<ProductResponse> guardar(@Valid @RequestBody ProductRequest solicitud) {
        Product producto = ModelMapperUtil.convertTo(solicitud, Product.class);
        Product guardado = service.guardar(producto);
        return new ResponseEntity<>(ModelMapperUtil.convertTo(guardado, ProductResponse.class), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> actualizar(@PathVariable Integer id, @Valid @RequestBody ProductRequest solicitud) {
        Product producto = ModelMapperUtil.convertTo(solicitud, Product.class);
        producto.setId(id);
        Product actualizado = service.guardar(producto);
        return ResponseEntity.ok(ModelMapperUtil.convertTo(actualizado, ProductResponse.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}


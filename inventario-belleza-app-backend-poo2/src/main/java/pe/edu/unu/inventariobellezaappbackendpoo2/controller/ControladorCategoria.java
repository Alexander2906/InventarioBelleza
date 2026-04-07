package pe.edu.unu.inventariobellezaappbackendpoo2.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.unu.inventariobellezaappbackendpoo2.DTO.request.CategoryRequest;
import pe.edu.unu.inventariobellezaappbackendpoo2.DTO.response.CategoryResponse;
import pe.edu.unu.inventariobellezaappbackendpoo2.Util.ModelMapperUtil;
import pe.edu.unu.inventariobellezaappbackendpoo2.entity.Category;
import pe.edu.unu.inventariobellezaappbackendpoo2.service.IServicioCategoria;

import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
@RequiredArgsConstructor
public class ControladorCategoria {

    private final IServicioCategoria service;

    @GetMapping("/pagina/{pagina}/{tamano}")
    public ResponseEntity<Page<CategoryResponse>> pagina(@PathVariable Integer pagina, @PathVariable Integer tamano) {
        Page<CategoryResponse> paginaCategorias = service.pagina(pagina, tamano);
        return new ResponseEntity<>(paginaCategorias, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> todos() {
        List<Category> categorias = service.todos();
        List<CategoryResponse> respuesta = categorias.stream()
                .map(c -> ModelMapperUtil.convertTo(c, CategoryResponse.class))
                .toList();
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> porId(@PathVariable Integer id) {
        Category categoria = service.porId(id);
        return ResponseEntity.ok(ModelMapperUtil.convertTo(categoria, CategoryResponse.class));
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> guardar(@Valid @RequestBody CategoryRequest solicitud) {
        Category categoria = ModelMapperUtil.convertTo(solicitud, Category.class);
        Category guardada = service.guardar(categoria);
        return new ResponseEntity<>(ModelMapperUtil.convertTo(guardada, CategoryResponse.class), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> actualizar(@PathVariable Integer id, @Valid @RequestBody CategoryRequest solicitud) {
        Category categoria = ModelMapperUtil.convertTo(solicitud, Category.class);
        categoria.setId(id);
        Category actualizada = service.guardar(categoria);
        return ResponseEntity.ok(ModelMapperUtil.convertTo(actualizada, CategoryResponse.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}


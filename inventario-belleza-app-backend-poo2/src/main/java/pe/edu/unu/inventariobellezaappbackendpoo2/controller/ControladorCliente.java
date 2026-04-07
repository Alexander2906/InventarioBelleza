package pe.edu.unu.inventariobellezaappbackendpoo2.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.unu.inventariobellezaappbackendpoo2.DTO.request.CustomerRequest;
import pe.edu.unu.inventariobellezaappbackendpoo2.DTO.response.CustomerResponse;
import pe.edu.unu.inventariobellezaappbackendpoo2.Util.ModelMapperUtil;
import pe.edu.unu.inventariobellezaappbackendpoo2.entity.Customer;
import pe.edu.unu.inventariobellezaappbackendpoo2.service.IServicioCliente;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class ControladorCliente {

    private final IServicioCliente service;

    @GetMapping("/pagina/{pagina}/{tamano}")
    public ResponseEntity<Page<CustomerResponse>> pagina(@PathVariable Integer pagina, @PathVariable Integer tamano) {
        Page<CustomerResponse> paginaClientes = service.pagina(pagina, tamano);
        return new ResponseEntity<>(paginaClientes, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> todos() {
        List<Customer> clientes = service.todos();
        List<CustomerResponse> respuesta = clientes.stream()
                .map(c -> ModelMapperUtil.convertTo(c, CustomerResponse.class))
                .toList();
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> porId(@PathVariable Integer id) {
        Customer cliente = service.porId(id);
        return ResponseEntity.ok(ModelMapperUtil.convertTo(cliente, CustomerResponse.class));
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> guardar(@Valid @RequestBody CustomerRequest solicitud) {
        Customer cliente = ModelMapperUtil.convertTo(solicitud, Customer.class);
        Customer guardado = service.guardar(cliente);
        return new ResponseEntity<>(ModelMapperUtil.convertTo(guardado, CustomerResponse.class), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse> actualizar(@PathVariable Integer id, @Valid @RequestBody CustomerRequest solicitud) {
        Customer cliente = ModelMapperUtil.convertTo(solicitud, Customer.class);
        cliente.setId(id);
        Customer actualizado = service.guardar(cliente);
        return ResponseEntity.ok(ModelMapperUtil.convertTo(actualizado, CustomerResponse.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}


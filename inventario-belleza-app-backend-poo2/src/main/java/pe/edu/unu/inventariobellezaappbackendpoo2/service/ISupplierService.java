package pe.edu.unu.inventariobellezaappbackendpoo2.service;

import org.springframework.data.domain.Page;
import pe.edu.unu.inventariobellezaappbackendpoo2.DTO.response.SupplierResponse;
import pe.edu.unu.inventariobellezaappbackendpoo2.entity.Supplier;

import java.util.List;

public interface ISupplierService {
    Page<SupplierResponse> page(Integer page, Integer size);
    List<Supplier> findAll();
    Supplier save(Supplier supplier);
    Supplier update(Supplier supplier);
    Supplier findById(Integer id);
    void delete(Integer id);
}


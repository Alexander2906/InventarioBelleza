package pe.edu.unu.inventariobellezaappbackendpoo2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pe.edu.unu.inventariobellezaappbackendpoo2.DTO.response.SupplierResponse;
import pe.edu.unu.inventariobellezaappbackendpoo2.Util.ModelMapperUtil;
import pe.edu.unu.inventariobellezaappbackendpoo2.entity.Supplier;
import pe.edu.unu.inventariobellezaappbackendpoo2.repository.ISupplierRepository;
import pe.edu.unu.inventariobellezaappbackendpoo2.service.ISupplierService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements ISupplierService {

    private final ISupplierRepository repository;

    @Override
    public Page<SupplierResponse> page(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id"));
        Page<Supplier> suppliers = repository.findAll(pageable);
        return suppliers.map(s -> ModelMapperUtil.convertTo(s, SupplierResponse.class));
    }

    @Override
    public List<Supplier> findAll() {
        return repository.findAll();
    }

    @Override
    public Supplier save(Supplier supplier) {
        return repository.save(supplier);
    }

    @Override
    public Supplier update(Supplier supplier) {
        return repository.save(supplier);
    }

    @Override
    public Supplier findById(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}


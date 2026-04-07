package pe.edu.unu.inventariobellezaappbackendpoo2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pe.edu.unu.inventariobellezaappbackendpoo2.DTO.response.CustomerResponse;
import pe.edu.unu.inventariobellezaappbackendpoo2.Util.ModelMapperUtil;
import pe.edu.unu.inventariobellezaappbackendpoo2.entity.Customer;
import pe.edu.unu.inventariobellezaappbackendpoo2.repository.ICustomerRepository;
import pe.edu.unu.inventariobellezaappbackendpoo2.service.IServicioCliente;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicioClienteImpl implements IServicioCliente {

    private final ICustomerRepository repository;

    @Override
    public Page<CustomerResponse> pagina(Integer pagina, Integer tamano) {
        Pageable pageable = PageRequest.of(pagina, tamano, Sort.by("id"));
        Page<Customer> clientes = repository.findAll(pageable);
        return clientes.map(c -> ModelMapperUtil.convertTo(c, CustomerResponse.class));
    }

    @Override
    public List<Customer> todos() {
        return repository.findAll();
    }

    @Override
    public Customer guardar(Customer cliente) {
        return repository.save(cliente);
    }

    @Override
    public Customer actualizar(Customer cliente) {
        return repository.save(cliente);
    }

    @Override
    public Customer porId(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}


package pe.edu.unu.inventariobellezaappbackendpoo2.service;

import org.springframework.data.domain.Page;
import pe.edu.unu.inventariobellezaappbackendpoo2.DTO.response.CustomerResponse;
import pe.edu.unu.inventariobellezaappbackendpoo2.entity.Customer;

import java.util.List;

public interface IServicioCliente {
    Page<CustomerResponse> pagina(Integer pagina, Integer tamano);
    List<Customer> todos();
    Customer guardar(Customer cliente);
    Customer actualizar(Customer cliente);
    Customer porId(Integer id);
    void eliminar(Integer id);
}


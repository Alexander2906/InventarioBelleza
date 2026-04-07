package pe.edu.unu.inventariobellezaappbackendpoo2.service;

import org.springframework.data.domain.Page;
import pe.edu.unu.inventariobellezaappbackendpoo2.DTO.response.ProductResponse;
import pe.edu.unu.inventariobellezaappbackendpoo2.entity.Persona;
import pe.edu.unu.inventariobellezaappbackendpoo2.entity.Product;

import java.util.List;

public interface IServicioProducto {
    Page<ProductResponse> pagina(Integer pagina, Integer tamano);
    List<Product> todos();
    Product guardar(Product producto);
    Product actualizar(Product producto);
    Persona guardar(Persona persona);
    Persona actualizar(Persona persona);
    Product porId(Integer id);
    void eliminar(Integer id);
}


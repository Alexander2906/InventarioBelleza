package pe.edu.unu.inventariobellezaappbackendpoo2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pe.edu.unu.inventariobellezaappbackendpoo2.DTO.response.ProductResponse;
import pe.edu.unu.inventariobellezaappbackendpoo2.Util.ModelMapperUtil;
import pe.edu.unu.inventariobellezaappbackendpoo2.entity.Persona;
import pe.edu.unu.inventariobellezaappbackendpoo2.entity.Product;
import pe.edu.unu.inventariobellezaappbackendpoo2.repository.IProductRepository;
import pe.edu.unu.inventariobellezaappbackendpoo2.service.IServicioProducto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicioProductoImpl implements  IServicioProducto{

    private final IProductRepository repository;

    @Override
    public Page<ProductResponse> pagina(Integer pagina, Integer tamano) {
        Pageable pageable = PageRequest.of(pagina, tamano, Sort.by("nombre"));
        Page<Product> productos = repository.findAll(pageable);
        return productos.map(p -> ModelMapperUtil.convertTo(p, ProductResponse.class));
    }

    @Override
    public List<Product> todos() {
        return repository.findAll();
    }

    @Override
    public Product guardar(Product producto) {
        return repository.save(producto);
    }

    @Override
    public Product actualizar(Product producto) {
        return repository.save(producto);
    }

    @Override
    public Product porId(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Persona guardar(Persona persona) {
        return repository.save(persona);
    }

    @Override
    public Persona actualizar(Persona persona) {
        return repository.save(persona);
    }
}


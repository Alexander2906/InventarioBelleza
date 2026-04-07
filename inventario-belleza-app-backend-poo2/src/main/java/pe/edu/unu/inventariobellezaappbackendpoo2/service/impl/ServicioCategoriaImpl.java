package pe.edu.unu.inventariobellezaappbackendpoo2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pe.edu.unu.inventariobellezaappbackendpoo2.DTO.response.CategoryResponse;
import pe.edu.unu.inventariobellezaappbackendpoo2.Util.ModelMapperUtil;
import pe.edu.unu.inventariobellezaappbackendpoo2.entity.Category;
import pe.edu.unu.inventariobellezaappbackendpoo2.repository.ICategoryRepository;
import pe.edu.unu.inventariobellezaappbackendpoo2.service.IServicioCategoria;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicioCategoriaImpl implements IServicioCategoria {

    private final ICategoryRepository repository;

    @Override
    public Page<CategoryResponse> pagina(Integer pagina, Integer tamano) {
        Pageable pageable = PageRequest.of(pagina, tamano, Sort.by("nombre"));
        Page<Category> categorias = repository.findAll(pageable);
        return categorias.map(c -> ModelMapperUtil.convertTo(c, CategoryResponse.class));
    }

    @Override
    public List<Category> todos() {
        return repository.findAll();
    }

    @Override
    public Category guardar(Category categoria) {
        return repository.save(categoria);
    }

    @Override
    public Category actualizar(Category categoria) {
        return repository.save(categoria);
    }

    @Override
    public Category porId(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}


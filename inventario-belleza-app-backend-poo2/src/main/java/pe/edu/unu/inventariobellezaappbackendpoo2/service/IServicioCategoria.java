package pe.edu.unu.inventariobellezaappbackendpoo2.service;

import org.springframework.data.domain.Page;
import pe.edu.unu.inventariobellezaappbackendpoo2.DTO.response.CategoryResponse;
import pe.edu.unu.inventariobellezaappbackendpoo2.entity.Category;

import java.util.List;

public interface IServicioCategoria {
    Page<CategoryResponse> pagina(Integer pagina, Integer tamano);
    List<Category> todos();
    Category guardar(Category categoria);
    Category actualizar(Category categoria);
    Category porId(Integer id);
    void eliminar(Integer id);
}


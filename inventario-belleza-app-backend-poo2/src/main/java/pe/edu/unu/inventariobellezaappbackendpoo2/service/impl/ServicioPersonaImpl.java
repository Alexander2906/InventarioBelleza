package pe.edu.unu.inventariobellezaappbackendpoo2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pe.edu.unu.inventariobellezaappbackendpoo2.DTO.response.RespuestaPersona;
import pe.edu.unu.inventariobellezaappbackendpoo2.Util.ModelMapperUtil;
import pe.edu.unu.inventariobellezaappbackendpoo2.entity.Persona;
import pe.edu.unu.inventariobellezaappbackendpoo2.entity.Product;
import pe.edu.unu.inventariobellezaappbackendpoo2.repository.IRepositorioPersona;
import pe.edu.unu.inventariobellezaappbackendpoo2.service.IServicioPersona;
import pe.edu.unu.inventariobellezaappbackendpoo2.service.IServicioProducto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicioPersonaImpl implements IServicioPersona {

    private final IRepositorioPersona repository;

    @Override
    public Page<RespuestaPersona> pagina(Integer pagina, Integer tamano) {
        Pageable pageable = PageRequest.of(pagina, tamano, Sort.by("apellido", "nombre", "fechaNacimiento"));
        Page<Persona> personas = repository.findAll(pageable);
        return personas.map(p -> ModelMapperUtil.convertTo(p, RespuestaPersona.class));
    }

    @Override
    public List<Persona> todos() {
        return repository.findAll();
    }

    @Override
    public Persona guardar(Persona persona) {
        return repository.save(persona);
    }

    @Override
    public Persona actualizar(Persona persona) {
        return repository.save(persona);
    }


    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Persona porId(Integer id) {
        return (Persona) repository.findAll(Pageable.ofSize(id));
    }
}


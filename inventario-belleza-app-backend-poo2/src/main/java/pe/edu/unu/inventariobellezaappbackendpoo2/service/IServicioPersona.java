package pe.edu.unu.inventariobellezaappbackendpoo2.service;

import org.springframework.data.domain.Page;
import pe.edu.unu.inventariobellezaappbackendpoo2.DTO.response.RespuestaPersona;
import pe.edu.unu.inventariobellezaappbackendpoo2.entity.Persona;

import java.util.List;

public interface IServicioPersona {
    Page<RespuestaPersona> pagina(Integer pagina, Integer tamano);
    List<Persona> todos();
    Persona guardar(Persona persona);
    Persona actualizar(Persona persona);
    Persona porId(Integer id);
    void eliminar(Integer id);
}


package pe.edu.unu.inventariobellezaappbackendpoo2.service;

import org.springframework.data.domain.Page;
import pe.edu.unu.inventariobellezaappbackendpoo2.DTO.response.StockMovementResponse;
import pe.edu.unu.inventariobellezaappbackendpoo2.entity.StockMovement;

import java.util.List;

public interface IServicioMovimientoStock {
    Page<StockMovementResponse> pagina(Integer pagina, Integer tamano);
    List<StockMovement> todos();
    StockMovement guardar(StockMovement movimiento);
    StockMovement actualizar(StockMovement movimiento);
    StockMovement porId(Integer id);
    void eliminar(Integer id);
}


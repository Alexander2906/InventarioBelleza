package pe.edu.unu.inventariobellezaappbackendpoo2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pe.edu.unu.inventariobellezaappbackendpoo2.DTO.response.StockMovementResponse;
import pe.edu.unu.inventariobellezaappbackendpoo2.Util.ModelMapperUtil;
import pe.edu.unu.inventariobellezaappbackendpoo2.entity.StockMovement;
import pe.edu.unu.inventariobellezaappbackendpoo2.repository.IStockMovementRepository;
import pe.edu.unu.inventariobellezaappbackendpoo2.service.IServicioMovimientoStock;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicioMovimientoStockImpl implements IServicioMovimientoStock {

    private final IStockMovementRepository repository;

    @Override
    public Page<StockMovementResponse> pagina(Integer pagina, Integer tamano) {
        Pageable pageable = PageRequest.of(pagina, tamano, Sort.by("movDate").descending());
        Page<StockMovement> movimientos = repository.findAll(pageable);
        return movimientos.map(m -> ModelMapperUtil.convertTo(m, StockMovementResponse.class));
    }

    @Override
    public List<StockMovement> todos() {
        return repository.findAll();
    }

    @Override
    public StockMovement guardar(StockMovement movimiento) {
        return repository.save(movimiento);
    }

    @Override
    public StockMovement actualizar(StockMovement movimiento) {
        return repository.save(movimiento);
    }

    @Override
    public StockMovement porId(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}


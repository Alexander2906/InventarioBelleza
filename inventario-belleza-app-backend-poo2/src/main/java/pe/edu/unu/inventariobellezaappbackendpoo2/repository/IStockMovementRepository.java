package pe.edu.unu.inventariobellezaappbackendpoo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.unu.inventariobellezaappbackendpoo2.entity.StockMovement;

public interface IStockMovementRepository extends JpaRepository<StockMovement, Integer> {
}


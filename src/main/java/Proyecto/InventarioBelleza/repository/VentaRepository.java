package Proyecto.InventarioBelleza.repository;

import Proyecto.InventarioBelleza.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {

    List<Venta> findByFechaBetween(LocalDateTime star, LocalDateTime end);

    @Query("SELECT SUM(v.total) FROM Venta v")
    BigDecimal getTotalVentas();
}

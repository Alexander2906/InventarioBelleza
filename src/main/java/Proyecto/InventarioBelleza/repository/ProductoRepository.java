package Proyecto.InventarioBelleza.repository;

import Proyecto.InventarioBelleza.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    List<Producto> findByCantidadStockLessThan(int threshold);

    @Query("SELECT p.nombre, SUM(vd.cantidad) as totalVendido FROM Producto p JOIN p.ventaDetalles vd GROUP BY p.id ORDER BY totalVendido DESC")
    List<Object[]> findTopProductosVendidos();
}

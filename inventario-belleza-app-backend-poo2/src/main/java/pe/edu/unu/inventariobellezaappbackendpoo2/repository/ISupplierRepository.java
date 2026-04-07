package pe.edu.unu.inventariobellezaappbackendpoo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.unu.inventariobellezaappbackendpoo2.entity.Supplier;

public interface ISupplierRepository extends JpaRepository<Supplier, Integer> {
}


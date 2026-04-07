package pe.edu.unu.inventariobellezaappbackendpoo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.unu.inventariobellezaappbackendpoo2.entity.Persona;
import pe.edu.unu.inventariobellezaappbackendpoo2.entity.Product;

public interface IProductRepository extends JpaRepository<Product, Integer> {

    Persona save(Persona persona);
}


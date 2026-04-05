package Proyecto.InventarioBelleza.repository;

import Proyecto.InventarioBelleza.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}

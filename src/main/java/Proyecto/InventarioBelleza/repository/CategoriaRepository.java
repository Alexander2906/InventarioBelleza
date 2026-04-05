package Proyecto.InventarioBelleza.repository;

import Proyecto.InventarioBelleza.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository  extends JpaRepository<Categoria, Integer> {
}

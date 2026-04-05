package Proyecto.InventarioBelleza.service;

import Proyecto.InventarioBelleza.entity.Categoria;

import java.util.List;

public interface CategoriaService {

    public List<Categoria> findAll();
    public Categoria save(Categoria categoria);
    public Categoria update(Categoria categoria);
    public Categoria finByid(Integer id);
    public void delete(Integer id);
}

package Proyecto.InventarioBelleza.service;

import Proyecto.InventarioBelleza.entity.Producto;

import java.util.List;

public interface ProductoService {

    public List<Producto> findAll();
    public Producto save(Producto producto);
    public Producto update(Producto producto);
    public Producto findById(Integer id);
    public void delete(Integer id);
    public List<Producto> findBajoStock();
    public List<Object[]> findTopVendidos();


}

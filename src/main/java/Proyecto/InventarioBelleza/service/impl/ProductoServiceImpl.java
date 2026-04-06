package Proyecto.InventarioBelleza.service.impl;

import Proyecto.InventarioBelleza.entity.Producto;
import Proyecto.InventarioBelleza.repository.ProductoRepository;
import Proyecto.InventarioBelleza.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private final ProductoRepository repository;

    @Override
    public List<Producto> findAll() {return repository.findAll();}

    @Override
    public Producto save(Producto producto) {
        return repository.save(producto);
    }

    @Override
    public Producto update(Producto producto) {
        return repository.save(producto);
    }

    @Override
    public Producto findById(Integer id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public void delete(Integer id) { repository.deleteById(id);}

    @Override
    public List<Producto> findBajoStock() {return repository.findByCantidadStockLessThan(10);}

    @Override
    public List<Object[]> findTopVendidos() {return repository.findTopProductosVendidos();}

    public void restarStock(Integer productoId, int cantidad){
        Producto producto = findById(productoId);
        if (producto.getCantidadStock()>= cantidad){
            producto.setCantidadStock(producto.getCantidadStock() -cantidad);
            save(producto);
        } else {
            throw new RuntimeException("Stock Insuficiente");
        }
    }

    public void agregarStock(Integer productoId, int cantidad){
        Producto producto = findById(productoId);
        producto.setCantidadStock(producto.getCantidadStock()+ cantidad);
        save(producto);
    }
}

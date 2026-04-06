package Proyecto.InventarioBelleza.service;

import Proyecto.InventarioBelleza.entity.Producto;

import java.math.BigDecimal;
import java.util.List;

public interface ReporteService {

public List<Producto> bajoStock();
public List<Object[]> topVendidos();
public BigDecimal totalVentas();

}

package Proyecto.InventarioBelleza.service.impl;

import Proyecto.InventarioBelleza.entity.Producto;
import Proyecto.InventarioBelleza.repository.ProductoRepository;
import Proyecto.InventarioBelleza.repository.VentaRepository;
import Proyecto.InventarioBelleza.service.ProductoService;
import Proyecto.InventarioBelleza.service.ReporteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReporteServiceImpl implements ReporteService {

    private final ProductoService productoService;
    private final ProductoRepository productoRepository;
    private final VentaRepository ventaRepository;

    @Override
    public List<Producto> bajoStock() {
        return productoService.findBajoStock();
    }

    @Override
    public List<Object[]> topVendidos() {return productoService.findTopVendidos();}

    @Override
    public BigDecimal totalVentas() {return ventaRepository.getTotalVentas();
    }
}

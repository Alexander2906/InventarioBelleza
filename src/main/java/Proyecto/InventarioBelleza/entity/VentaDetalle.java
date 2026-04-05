package Proyecto.InventarioBelleza.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "VENTA_DETALLES")

public class VentaDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DETALLE_ID",nullable = false)
    private Integer id;

    @Column(name = "PRECIO_UNITARIO" ,nullable = false)
    private BigDecimal precioUnitario;

    @ManyToOne
    @JoinColumn(name = "VENTA_ID",nullable = false, foreignKey = @ForeignKey(name ="VENTA_DETALLE_VENTAS_ID_FK"))
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "PRODUCTO_ID", nullable = false,foreignKey = @ForeignKey(name = "VENTA_DETALLE_PRODUCTO_ID_FK"))
    private Producto producto;


}

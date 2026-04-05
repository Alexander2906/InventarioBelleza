package Proyecto.InventarioBelleza.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "PRODUCTOS")

public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCTO_ID",nullable = false)
    private Integer id;

    @Column(name = "NOMBRE_PRODUCTO",nullable = false)
    private Integer nombre;

    @Column(name = "DESCRIPCION_PRODUCTO",nullable = false, length = 200)
    private String descripcion;


    @DecimalMin(value = "0.01")
    @Column(name = "PRECIO_PRODUCTO",nullable = false)
    private BigDecimal precio;

    @Min(value = 0)
    @Column(name = "CANTIDAD_STOCK", nullable = false)
    private Integer cantidadStock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORIA_ID", nullable = false, foreignKey = @ForeignKey(name ="PRODUCTO_CATEGORIA_FK" ))
    private Categoria categoria;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<VentaDetalle> ventaDetalles;
}

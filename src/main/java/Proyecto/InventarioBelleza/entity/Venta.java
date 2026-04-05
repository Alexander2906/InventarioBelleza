package Proyecto.InventarioBelleza.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name= "VENTAS")

public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_VENTAS",nullable = false)
    private Integer id;

    @Column(name = "FECHA", nullable = false)
    private LocalDate fecha;

    @Column(name = "TOTAL",nullable = false)
    private Double total;

    @Enumerated(EnumType.STRING)
    @Column(name = "ESTADO", nullable = false)
    private Estado estado = Estado.PENDIENTE;

    @ManyToOne
    @JoinColumn(name = "CLIENTE_ID", nullable = false, foreignKey = @ForeignKey(name = "VENTA_CLIENTE_FK"))
    private Cliente cliente;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    private List<VentaDetalle> detalles;

    public enum Estado {
        PENDIENTE, COMPLETADA, CANCELADA
    }

}

package Proyecto.InventarioBelleza.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Null;
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
@Table(name = "CLIENTES")

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENTE", nullable = false)
    private Integer id;

    @Column(name = "NOMBRE_CLIENTE",nullable = false)
    private String nombre;

    @Column(name = "APELLIDO_CLIENTE", nullable = false)
    private String apellido;

    @Column(name = "FECH_NACIMIENTO", nullable = false)
    private LocalDate fech_nacimiento;

    @Column(name = "TELEFONO", nullable = false)
    private String telefono;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Venta> ventas;


}

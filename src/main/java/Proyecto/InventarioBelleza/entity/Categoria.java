package Proyecto.InventarioBelleza.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="CATEGORIAS")

public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORIA_ID",nullable = false)
    private Integer id;

    @Column(name = "NOMBRE_CATEGORIA" , nullable = false,length = 100)
    private String nombre;

    @Column(name = "DESCRIPCION" , nullable = false, length = 200)
    private String descripcion;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Producto> productos;
}

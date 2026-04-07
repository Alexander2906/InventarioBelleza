package pe.edu.unu.inventariobellezaappbackendpoo2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SUPPLIER")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SUPPLIER_ID", nullable = false)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "PERSON_ID", nullable = false)
    @MapsId  // Shared PK if wanted, or separate
    private Persona persona;
}


package pe.edu.unu.inventariobellezaappbackendpoo2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "STOCK_MOVEMENT")
public class StockMovement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVEMENT_ID", nullable = false)
    private Integer id;

    @Column(name = "TYPE", nullable = false, length = 3)
    private String type; // 'IN' or 'OUT'

    @Column(name = "QUANTITY", nullable = false)
    private Integer quantity;

    @Column(name = "MOV_DATE", nullable = false)
    private LocalDate movDate;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "SUPPLIER_ID")
    private Supplier supplier;
}


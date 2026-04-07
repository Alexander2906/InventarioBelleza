package pe.edu.unu.inventariobellezaappbackendpoo2.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private Integer id;
    private String name;
    private String sku;
    private BigDecimal price;
    private Integer stock;
    private Integer categoryId;
    private Integer supplierId;
}


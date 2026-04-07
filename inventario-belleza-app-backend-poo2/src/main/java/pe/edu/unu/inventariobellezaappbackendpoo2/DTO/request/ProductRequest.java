package pe.edu.unu.inventariobellezaappbackendpoo2.DTO.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequest {
    @NotBlank
    private String name;
    private String sku;
    @NotNull
    private BigDecimal price;
    @NotNull
    private Integer stock;
    private Integer categoryId;
    private Integer supplierId;
}


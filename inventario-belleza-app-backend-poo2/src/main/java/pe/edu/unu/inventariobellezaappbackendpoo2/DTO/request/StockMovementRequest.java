package pe.edu.unu.inventariobellezaappbackendpoo2.DTO.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class StockMovementRequest {
    @NotBlank
    private String type;
    @NotNull
    private Integer quantity;
    @NotNull
    private LocalDate movDate;
    @NotNull
    private Integer productId;
    private Integer supplierId;
}


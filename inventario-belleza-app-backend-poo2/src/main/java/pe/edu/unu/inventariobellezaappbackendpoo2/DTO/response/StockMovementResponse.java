package pe.edu.unu.inventariobellezaappbackendpoo2.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StockMovementResponse {
    private Integer id;
    private String type;
    private Integer quantity;
    private LocalDate movDate;
    private Integer productId;
    private Integer supplierId;
}


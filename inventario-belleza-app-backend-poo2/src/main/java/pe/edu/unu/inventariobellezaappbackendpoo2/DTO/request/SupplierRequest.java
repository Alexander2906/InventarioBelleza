package pe.edu.unu.inventariobellezaappbackendpoo2.DTO.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SupplierRequest {
    @NotNull
    private Integer personId;
}


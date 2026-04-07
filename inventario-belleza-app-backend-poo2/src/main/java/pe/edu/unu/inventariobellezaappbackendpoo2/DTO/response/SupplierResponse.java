package pe.edu.unu.inventariobellezaappbackendpoo2.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SupplierResponse {
    private Integer id;
    private RespuestaPersona persona;
}


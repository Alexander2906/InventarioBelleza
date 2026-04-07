package pe.edu.unu.inventariobellezaappbackendpoo2.DTO.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SolicitudPersona {
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotNull
    private LocalDate fechaNacimiento;
    @NotBlank
    private String telefono;
}


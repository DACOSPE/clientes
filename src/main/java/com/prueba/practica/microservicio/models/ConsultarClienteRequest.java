package com.prueba.practica.microservicio.models;



import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Schema(name = "ConsultarClienteRequest")
public class ConsultarClienteRequest {

  

    @NotNull
    @Schema(name = "tipDocumento", description = "Tipo de Documento del Cliente")
    private String tipDocumento;

    @NotNull
    @Schema(name = "numDocumento", description = "Numero de Documento del Cliente")
    private String numDocumento;



}

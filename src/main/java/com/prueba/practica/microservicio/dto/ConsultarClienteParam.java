package com.prueba.practica.microservicio.dto;



import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@Schema(name = "ConsultarClienteParam")

public class ConsultarClienteParam {

    @NotNull
    @Schema(name = "tipDocumento", description = "Tipo de Documento del Cliente")
    private String tipDocumento;

    @NotNull
    @Schema(name = "numDocumento", description = "Numero de Documento del Cliente")
    private String numDocumento; 

    @Schema(name = "codResultado", required = true,description = "Codigo Resultado de la operación." )
    private Integer codResultado;

    @Schema(name = "mgResultado", required = true,description = "Mensaje Resultado de la operación." )
    private String mgResultado;

    @Schema(name = "infCliente", required = true,description = "Informacion del Cliente." )
    private InformacionCliente infCliente;


}

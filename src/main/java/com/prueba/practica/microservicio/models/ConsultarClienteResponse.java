package com.prueba.practica.microservicio.models;



import com.fasterxml.jackson.annotation.JsonInclude;
import com.prueba.practica.microservicio.dto.InformacionCliente;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Schema(name = "ConsultarClienteResponse")
public class ConsultarClienteResponse {


    
    @Schema(name = "codResultado", required = true,description = "Codigo Resultado de la operación." )
    private Integer codResultado;

    @Schema(name = "mgResultado", required = true,description = "Mensaje Resultado de la operación." )
    private String mgResultado;

    @Schema(name = "infCliente", required = true,description = "Mensaje Resultado de la operación." )
    private InformacionCliente infCliente;  
   






}

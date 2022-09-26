package com.prueba.practica.microservicio.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_ABSENT)
@Schema(name = "ErrorModels")

public class ErrorModels {

    @Schema(name = "id_error", description = "Variable id_error de tipo BigDecimal")
    private BigDecimal id_error;
    @Schema(name = "desc_error", description = "Variable desc_error de tipo String")
    private String desc_error;
    @Schema(name = "tipo_error", description = "Variable tipo_error de tipo String")
    private String tipo_error;
    @Schema(name = "msg_error", description = "Variable msg_error de tipo String")
    private String msg_error;
   

}

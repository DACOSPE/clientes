package com.prueba.practica.microservicio.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.prueba.practica.microservicio.dto.ConsultarClienteParam;
import com.prueba.practica.microservicio.models.ConsultarClienteRequest;
import com.prueba.practica.microservicio.models.ConsultarClienteResponse;
import com.prueba.practica.microservicio.models.ErrorModels;
import com.prueba.practica.microservicio.services.ConsultarClienteService;




@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/")


@Tag(name = "consultarCliente", description = "Metodo que consulta informacion adicional para un cliente.")
public class ConsultarClienteController {

   @Autowired
   private ConsultarClienteService service;

    @GetMapping(value = "/consultarCliente", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(description = "Metodo que consulta informacion adicional para un cliente.",
            summary = "Metodo que consulta infromcaion adicional para un cliente.")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(schema = @Schema(implementation = ConsultarClienteResponse.class))),
            @ApiResponse(responseCode = "400", description = "Error en los parámetros proporcionados", content = @Content(schema = @Schema(implementation = ErrorModels.class))),
            @ApiResponse(responseCode = "404", description = "Error no se pudo encontrar el recurso necesario", content = @Content(schema = @Schema(implementation = ErrorModels.class))),
            @ApiResponse(responseCode = "500", description = "Error de servidor", content = @Content(schema = @Schema(implementation = ErrorModels.class)))
    })
    public ResponseEntity<ConsultarClienteResponse>  callConsultatClientes(
        @Parameter(name = "tipoDocumento", description = "Tipo de documento de identidad tomador") @RequestParam(required = true) String tipoDocumento,
        @Parameter(name = "numeroDocumento", description = "Numero documento de identidad tomador") @RequestParam(required = true) String numeroDocumento)  {
        ConsultarClienteRequest request=new ConsultarClienteRequest();
        request.setTipDocumento(tipoDocumento);
        request.setNumDocumento(numeroDocumento);
        ConsultarClienteParam params;

        params = service.prepareParam(request);

        ConsultarClienteResponse response = service.consultarCliente(params);
    return new ResponseEntity<>(response,new HttpHeaders(), HttpStatus.OK);
    }



}

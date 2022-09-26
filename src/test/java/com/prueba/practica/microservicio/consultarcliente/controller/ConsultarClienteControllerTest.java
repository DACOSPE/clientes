package com.prueba.practica.microservicio.consultarcliente.controller;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.prueba.practica.microservicio.consultarcliente.datos.DatosConsultarCliente;
import com.prueba.practica.microservicio.controller.ConsultarClienteController;
import com.prueba.practica.microservicio.dto.ConsultarClienteParam;
import com.prueba.practica.microservicio.models.ConsultarClienteRequest;
import com.prueba.practica.microservicio.models.ConsultarClienteResponse;
import com.prueba.practica.microservicio.services.ConsultarClienteService;

import java.text.ParseException;

@SpringBootTest
class ConsultarClienteControllerTest  {

    @Mock
    @Autowired
    private ConsultarClienteService genericoService;

    @InjectMocks
    private ConsultarClienteController genericoController;

    private AutoCloseable closeable;


    @BeforeEach
    void init()
    {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void closeService() throws Exception{
        closeable.close();
    }

    @Test
    void validaSuccess() throws ParseException {

        init();

        ConsultarClienteRequest request  = DatosConsultarCliente.getRequest();
        ConsultarClienteParam params = DatosConsultarCliente.getParam();
        ConsultarClienteResponse response = DatosConsultarCliente.getResponse();


        Mockito.when(genericoService.prepareParam(request))
                .thenReturn(params);

        Mockito.when(genericoService.consultarCliente(params))
                .thenReturn(response);

        ResponseEntity<ConsultarClienteResponse> controllerResponse = genericoController.callConsultatClientes(request.getTipDocumento(),request.getNumDocumento());

        Assertions.assertNotNull(controllerResponse);
        Assertions.assertEquals(HttpStatus.OK,controllerResponse.getStatusCode());
    }


}

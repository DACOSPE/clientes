package com.prueba.practica.microservicio.services;

import com.prueba.practica.microservicio.dto.ConsultarClienteParam;
import com.prueba.practica.microservicio.models.ConsultarClienteRequest;
import com.prueba.practica.microservicio.models.ConsultarClienteResponse;

public interface ConsultarClienteService {


    public ConsultarClienteResponse consultarCliente(ConsultarClienteParam param);


    public ConsultarClienteParam prepareParam(ConsultarClienteRequest request) ;







}

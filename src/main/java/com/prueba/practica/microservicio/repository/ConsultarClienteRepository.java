package com.prueba.practica.microservicio.repository;



import org.springframework.stereotype.Component;


import com.prueba.practica.microservicio.dto.ConsultarClienteParam;




@Component
public interface  ConsultarClienteRepository {

    
    void consultarCliente(ConsultarClienteParam params);

    
}

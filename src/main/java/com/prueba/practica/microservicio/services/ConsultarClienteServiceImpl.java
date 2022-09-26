package com.prueba.practica.microservicio.services;



import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.practica.microservicio.dto.ConsultarClienteParam;
import com.prueba.practica.microservicio.models.ConsultarClienteRequest;
import com.prueba.practica.microservicio.models.ConsultarClienteResponse;

import com.prueba.practica.microservicio.repository.ConsultarClienteRepository;




@Service
@Slf4j
@RequiredArgsConstructor
public class ConsultarClienteServiceImpl implements ConsultarClienteService{

    @Autowired
   private final ConsultarClienteRepository repository;




    @Override
    public ConsultarClienteResponse consultarCliente(ConsultarClienteParam param) {
        log.info("Inside ConsultarCliente service");
        log.info("param: {}",param);

        if (param.getTipDocumento().equals("P")||param.getTipDocumento().equals("C") )
        {            
                repository.consultarCliente(param);         
            

        }else{
            param.setCodResultado(88);
            param.setMgResultado("Tipo de Documento Invalido");
        }

                   


        log.info("Salida Datos");
        log.info(param.getCodResultado().toString());
       
       
        return new ConsultarClienteResponse(param.getCodResultado(),param.getMgResultado(),param.getInfCliente());

    }

    @Override
    public ConsultarClienteParam prepareParam(ConsultarClienteRequest request)  {

        ConsultarClienteParam param = new ConsultarClienteParam();
       
        //Añade los valores del request
        param.setTipDocumento(request.getTipDocumento());
        param.setNumDocumento(request.getNumDocumento());

        return param;
    }


}

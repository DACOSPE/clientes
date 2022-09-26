package com.prueba.practica.microservicio.repository;





import org.springframework.stereotype.Component;

import com.prueba.practica.microservicio.dto.ConsultarClienteParam;
import com.prueba.practica.microservicio.dto.InformacionCliente;




@Component
public class ConsultarClienteRepositoryImpl implements ConsultarClienteRepository{
    
    
    @Override
    public void consultarCliente(ConsultarClienteParam params) {
 
        if (params.getNumDocumento().equals("23445322") && params.getTipDocumento().equals("C") ){
            InformacionCliente infCli =new InformacionCliente();
            infCli.setPrimerNombre("Normando");
            infCli.setSegundoNombre("David");
            infCli.setPrimerApellido("Torres");
            infCli.setSegundoApellido("Polo");
            infCli.setTeléfono(33399988);
            infCli.setDireccion("CLL 10 # 67 - 89");
            infCli.setCiudadResidencia("Bogota D.C. ");
            
            params.setCodResultado(0);
            params.setInfCliente(infCli);
        }else{
            params.setCodResultado(99);
            params.setMgResultado("No hay Informacion para el Tipo y Numero de documento ingresado.");
        }
        
    }
    
}

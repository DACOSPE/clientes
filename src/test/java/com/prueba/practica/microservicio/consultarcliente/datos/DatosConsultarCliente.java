package com.prueba.practica.microservicio.consultarcliente.datos;


import com.prueba.practica.microservicio.dto.ConsultarClienteParam;
import com.prueba.practica.microservicio.dto.InformacionCliente;
import com.prueba.practica.microservicio.models.ConsultarClienteRequest;
import com.prueba.practica.microservicio.models.ConsultarClienteResponse;

public class DatosConsultarCliente {
	
	
	public static ConsultarClienteParam getParam(){
		ConsultarClienteParam param = new ConsultarClienteParam();
       
            //Carga de pmts de peticion
            param.setTipDocumento("C");
            param.setNumDocumento("23445322");     
			
		

        return param;
	}
	
	public static ConsultarClienteRequest getRequest() {
		
		ConsultarClienteRequest request = new ConsultarClienteRequest();		
    	
        //Carga de pmts de peticion
        request.setTipDocumento("C");
        request.setNumDocumento("23445322");  
       

		return request;
		
	}
	
	public static ConsultarClienteResponse getResponse() {
		ConsultarClienteResponse response = new ConsultarClienteResponse();
		InformacionCliente infCli =new InformacionCliente();
            infCli.setPrimerNombre("Normando");
            infCli.setSegundoNombre("David");
            infCli.setPrimerApellido("Torres");
            infCli.setSegundoApellido("Polo");
            infCli.setTeléfono(33399988);
            infCli.setDireccion("CLL 10 # 67 - 89");
            infCli.setCiudadResidencia("Bogota D.C. ");
            
            response.setCodResultado(0);
            response.setInfCliente(infCli);		
		
		return response;
	}


	

	

	



}

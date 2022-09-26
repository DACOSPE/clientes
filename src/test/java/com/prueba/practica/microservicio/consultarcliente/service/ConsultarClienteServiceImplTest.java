package com.prueba.practica.microservicio.consultarcliente.service;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mockito;


import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.prueba.practica.microservicio.consultarcliente.datos.DatosConsultarCliente;
import com.prueba.practica.microservicio.dto.ConsultarClienteParam;
import com.prueba.practica.microservicio.models.ConsultarClienteRequest;
import com.prueba.practica.microservicio.models.ConsultarClienteResponse;
import com.prueba.practica.microservicio.repository.ConsultarClienteRepository;
import com.prueba.practica.microservicio.services.ConsultarClienteServiceImpl;




@SpringBootTest
class ConsultarClienteServiceImplTest {


    @MockBean
    private ConsultarClienteRepository repository ;


    @InjectMocks
    @Autowired
    private ConsultarClienteServiceImpl service;




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

    public ConsultarClienteRequest request  = DatosConsultarCliente.getRequest();
    public ConsultarClienteParam params = DatosConsultarCliente.getParam();
    public ConsultarClienteResponse response = DatosConsultarCliente.getResponse();




    @Test
    void prcValidaSuccess(){


        init();



        Mockito.doAnswer(i ->{
            params.setCodResultado(response.getCodResultado());            
            params.setMgResultado(response.getMgResultado());
            params.setInfCliente(response.getInfCliente());

            return params;
        }).when(repository).consultarCliente(params);
        
        


        ConsultarClienteResponse response2 = service.consultarCliente(params);

        ConsultarClienteParam params2 = service.prepareParam(request);


        Assertions.assertNotNull(response2);
        Assertions.assertNotNull(params2);



    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5})
    void prcValidaCaseFail(int number){
        init();

        
            Mockito.doAnswer(i ->{
                params.setCodResultado(response.getCodResultado());            
            params.setMgResultado(response.getMgResultado());
            params.setInfCliente(response.getInfCliente());

                return params;
            }).when(repository).consultarCliente(params);

            
            ConsultarClienteResponse response = service.consultarCliente(params);

        
        

    }





}
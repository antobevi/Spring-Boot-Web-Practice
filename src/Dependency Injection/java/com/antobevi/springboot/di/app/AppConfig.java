package com.antobevi.springboot.di.app;

import com.antobevi.springboot.di.app.models.services.IService;
import com.antobevi.springboot.di.app.models.services.MyComplexService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/*
*  Creando una clase de configuracion de Spring nos permitira definir componentes de igual manera que 
* lo hacemos agregando @Component en cada clase que queramos registrar. Para ello, utilizaremos en
* cada metodo la anotacion @Bean y retornaremos el objeto que queremos injectar.
*
* IMPORTANTE: Las configuraciones deben estar SIEMPRE dentro del package principal donde se encuentra
* la clase con el main.
*/

@Configuration
public class AppConfig {
    
    @Bean("MySimpleService") // Para poderlo registrar necesitamos esta anotacion
    public IService simpleServiceRegister() {
        return new MyComplexService();
    }

    @Bean("MyComplexService") // Para poderlo registrar necesitamos esta anotacion
    @Primary
    public IService complexServiceRegister() {
        return new MyComplexService();
    }
    
}

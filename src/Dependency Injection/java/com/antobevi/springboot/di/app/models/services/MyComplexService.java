package com.antobevi.springboot.di.app.models.services;

import org.springframework.stereotype.Component;

// @Service es lo mismo pero es mas descriptivo (la unica diferencia es semantica)
@Component("MyComplexService") // Con esto registramos la clase en el contenedor de Spring
public class MyComplexService implements IService {

    @Override
    public String operation() {
        return "Ejecutando un proceso complejo...";
    }

}

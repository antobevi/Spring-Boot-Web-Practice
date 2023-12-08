package com.antobevi.springboot.di.app.models.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/*
 * La clase Servicio se encarga de trabajar con los datos y operar con ellos, es decir, se encarga
 * de lo que se relaciona con la logica de negocio. En general, un Service es una fachada a los objetos
 * de acceso a datos que realizan, por ejemplo, consultas y operaciones en las tablas de la base de datos,
 * independientemente de si usamos JDC o algun ORM como JPA + Hibernate. El Service podria tener un
 * atributo de un DAU o varios atributos, y estos DAU podrian interactuar bajo una misma transaccion
 * en un metodo, etc.
 */

// Bussiness Service Facade
// Este objeto se instancia una unica vez en nuestra aplicacion (Patrón Singleton)
// para que pueda inyectarse en otros componentes.
// Por otro lado, todos los componentes de Spring que vaya a registrarse en el contenedor debe
// tener un constructor sin argumentos por defecto

// @Service es lo mismo pero es mas descriptivo (la unica diferencia es semantica)
//@Component("MySimpleService")
//@Primary // De esta forma cuando Spring busca cual clase implementar, le indicamos esta por default
public class MySimpleService implements IService {

    @Override
    public String operation() {
        return "Ejecutando un proceso simple...";
    }

}

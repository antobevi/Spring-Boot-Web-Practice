package com.antobevi.springboot.app.SpringProject;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/*
* Creamos esta clase para poder dejar el archivo application.properties para lo que sea
* conexion con la base de datos, y ese tipo de configuraciones, y creamos otro archivo properties
* para lo que este relacionado con los textos de los controllers que pasamos a las vistas.
* Con esta clase podemos indicar esta nueva configuracion e incluso podemos agregar mas properties.
*/
/* TODO: No me deja levantar el servidor si tengo otro archivo de properties, ver como solucionar
@Configuration
@PropertySources({
        @PropertySource("classpath:textsControllers.properties")
})
public class TextsPropertiesConfig {
}
*/
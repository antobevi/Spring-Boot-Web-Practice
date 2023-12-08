package com.antobevi.springboot.di.app.controllers;

import com.antobevi.springboot.di.app.models.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    // Busca algun objeto guardado en el contenedor de Spring que sea del tipo MyService y
    // cuando lo encuentra, lo inyecta, caso contrario, lanza un error.
    @Autowired
    @Qualifier("MyComplexService") // Para inyectar mediante el qualifier aunque haya o no uno por default
    private IService service;
    /* private MyService service = new MyService();
    EL problema de instanciar al servicio en el controlador es que no solo esta muy acoplado a una
    aplicacion en concreto, si no que en aplicaciones medianas o grandes vamos a tener problemas
    de mantenibilidad y escalabilidad de la aplicación.
    La implementacion del servicio y de sus operaciones, o incluso el servicio podrían cambiar y esto
    sería muy tedioso de modificar, ya que esta altamente acoplado.
    Lo mejor es que no llamemos directamente al objeto ni lo instanciemos, si no que el contenedor de
    Spring a través del Load Beans (o componentes) llame al controlador e injecte la instancia de
    servicio.
    Para solucionar esto, existen 2 soluciones: Inyeccion de Dependencias e Interfaces.
    Mediante la interfaz terminamos de desacoplar ya que si cambia el objeto, si todos siguen una misma
    interfaz, nuestra aplicacion va a seguir funcionando, por ello para la inyeccion utilizaremos como
    tipo la interfaz y no el objeto en particular.
    */

    /* Otra forma de inyectar es mediante el constructor:
    @Autowired // Se puede omitir
    public IndexController(IService service) {
        this.service = service;
    }
    */

    @GetMapping({"/", "", "/index"})
    public String getIndex(Model model) {
        model.addAttribute("Object", service.operation());
        return "index";
    }

}

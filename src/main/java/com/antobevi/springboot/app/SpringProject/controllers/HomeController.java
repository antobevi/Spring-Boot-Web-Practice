package com.antobevi.springboot.app.SpringProject.controllers;

import com.antobevi.springboot.app.SpringProject.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
* Un controlador se encarga de manejar las peticiones del usuario,
* como por ejemplo, mostrar una página, mostrar datos solicitados, etc.
*/
@Controller
@RequestMapping("/app") // Ruta base para todos los controladores (http://localhost:8080/app/...)
public class HomeController {

    // Cada vez que pongamos en el navegador http://localhost:8080/app/home ejecuta este metodo:
    // Otra anotacion: @GetMapping(value = "/home")
    // Un metodo puede estar mapeado a mas de una url: value = {"/home", "/", "/index"}
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model) { // pasar datos desde el controlador a la vista con Model
        // tambien podemos usar la clase ModelMap, ModelAndView (metodo addObject y setViewName) y Map<String> (metodo put)
        model.addAttribute("HomeTitle", "Hola Spring Project!");
        return "index"; // plantilla html llamada index que es como la pagina de inicio
    }

    @GetMapping("/profile")
    public String userProfile(ModelMap modelMap) {
        User user = new User("Antonella", "Bevilacqua");
        modelMap.addAttribute("TitleUserProfile",
                "Perfil del usuario: " + user.getName() + " " + user.getSurname());
        modelMap.addAttribute("UserProfile", user);
        return "profile";
    }

}
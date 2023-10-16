package com.antobevi.springboot.app.SpringProject.controllers;

import com.antobevi.springboot.app.SpringProject.models.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.List;

/*
* Un controlador se encarga de manejar las peticiones del usuario,
* como por ejemplo, mostrar una página, mostrar datos solicitados, etc.
*/

@Controller
@RequestMapping("/app/home") // Ruta base para todos los controladores (http://localhost:8080/app/...)
public class HomeController {
    @Value("${text.homecontroller.home.title}")
    private String homeTitle;

    // Cada vez que pongamos en el navegador http://localhost:8080/app/home ejecuta este metodo:
    // Otra anotacion: @GetMapping(value = "/home")
    // Un metodo puede estar mapeado a mas de una url: value = {"/home", "/", "/index"}
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) { // pasar datos desde el controlador a la vista con Model
        // tambien podemos usar la clase ModelMap, ModelAndView (metodo addObject y setViewName) y Map<String> (metodo put)
        model.addAttribute("HomeTitle", homeTitle);

        return "index"; // plantilla html llamada index que es como la pagina de inicio
    }

    @GetMapping("/my-profile")
    public String getUserProfile() {
        return "forward:/app/users/my-profile"; // A diferencia del redirect, no cambia la URL que se muestra
    }

    @GetMapping("/system-users")
    public String getSystemUsers() {
        return "redirect:/app/users/system-users";
    }

    @GetMapping("/search")
    public String search() {
        return "redirect:https://www.google.com.ar"; // Cuando queremos redirigir a una pagina externa
    }

}

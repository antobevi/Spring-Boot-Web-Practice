package com.antobevi.springboot.app.SpringProject.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/app/params")
public class ParamsController {

     @GetMapping("/")
     public String index() {
         return "params/index";
     }

    @GetMapping("/string")
    // La idea es pasar parametros mediante la URL, en este caso, mediante el request GET
    // URL: http://localhost:8080/app/params/string?text=Este es mi primer projecto con SpringBoot
    public String paramSimpleText(@RequestParam(name="text", required=false,
            defaultValue="El usuario no ha indicado ningún texto.") String text, Model model) {
        model.addAttribute("TextToShow", "El texto enviado es: " + text);

        return "params/watch";
    }

    @GetMapping("/string/greeting")
    public String paramGreeting(@RequestParam() String userName, @RequestParam() Integer userAge, Model model) {
        model.addAttribute("TextToShow", "Hola " + userName +" de " + userAge + "!");

        return "params/watch";
    }

    @GetMapping("/string/various-params")
    public String params(HttpServletRequest request, Model model) {
         // De esta forma podemos obtener todos los parametros del request, sean uno o mas
        // Sea saludo o mostrar un texto simple
        String simpleText = request.getParameter("text");
        String userName = request.getParameter("userName");
        // Cuando intentamos parsear numeros, puede pasar que lo que nos envian por parametro no sea
        // justamente numerico por lo que necesitamos manejar la excepcion con try catch
        Integer userAge = null;
        try {
            userAge = Integer.parseInt(request.getParameter("userAge"));
        } catch(NumberFormatException e) {
            userAge = 0;
        }

        model.addAttribute("TextToShow", "Hola " + userName +" de " + userAge + "! " + simpleText);

        return "params/watch";
    }

}

package com.antobevi.springboot.app.SpringProject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app/variables")
public class PathVariablesController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("PathToShow", "Enviando los parametros de la ruta (@PathVariable)");

        return "variables/index";
    }

    @GetMapping("/string/{text}") // {text} maneja de manera dinamica sea lo que sea que le pasemos
    public String variableParam(@PathVariable(name="text") String text, Model model) { // Maneja rutas variables. Se debe mantener el nombre del path
        model.addAttribute("PathToShow", "Recibiendo los parametros de la ruta (@PathVariable)");
        model.addAttribute("TextToShow", "Texto enviado: " + text);
        return "variables/watch";
    }

    @GetMapping("/string/{text}/{number}") //
    public String variableMultipleParams(@PathVariable(name="text") String text,
                                         @PathVariable Integer number, Model model) { // Maneja rutas variables. Se debe mantener el nombre del path
        model.addAttribute("PathToShow", "Recibiendo los parametros de la ruta (@PathVariable)");
        model.addAttribute("TextToShow", "Texto enviado: " + text + " y numero enviado: " + number);
        return "variables/watch";
    }

}

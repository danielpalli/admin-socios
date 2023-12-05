package com.copal.gestion.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.copal.gestion.services.interfaces.IDepartamentoService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/departamentos")
@AllArgsConstructor
public class DepartamentoWebController {
    private final IDepartamentoService departamentoService;
    @GetMapping()
    public String mostrarPaginaInicio(Model model) {
        model.addAttribute("titulo", "Copal - Departamento");
        model.addAttribute("contenido", "departamento/listado-departamento");
        model.addAttribute("departamentos", this.departamentoService.getAll());

        return "index";
    }

    @GetMapping("/crear-departamento")
    public String crearDepartamento(Model model) {
        model.addAttribute("titulo", "Copal - Nuevo Departamento");
        model.addAttribute("contenido", "departamento/agregar-departamento");

        return "index";
    }

}

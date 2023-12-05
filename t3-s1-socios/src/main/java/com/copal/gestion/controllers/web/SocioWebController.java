package com.copal.gestion.controllers.web;

import com.copal.gestion.domain.dtos.requests.SocioRequest;
import com.copal.gestion.services.interfaces.ISocioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/socios")
@AllArgsConstructor
public class SocioWebController {
    private final ISocioService socioService;

    @GetMapping()
    public String mostrarPaginaInicio(Model model) {
        model.addAttribute("titulo", "Copal - Socio");
        model.addAttribute("contenido", "socio/listado-socio");
        model.addAttribute("socios", this.socioService.getAll());

        return "index";
    }

    @GetMapping("/{idSocio}")
    public String verSocio(@PathVariable("idSocio") Long idSocio, Model model) {
        model.addAttribute("titulo", "Copal - Socio");
        model.addAttribute("socio", this.socioService.getById(idSocio));
        model.addAttribute("contenido", "socio/ver-socio");

        return "index";
    }

    @GetMapping("/crear-socio")
    public String crearSocio(Model model) {
        model.addAttribute("titulo", "Copal - Nuevo Socio");
        model.addAttribute("contenido", "socio/agregar-socio");
        model.addAttribute("request", new SocioRequest());

        return "index";
    }

    @GetMapping("/actualizar-socio/{idSocio}")
    public String actualizarSocio(@PathVariable("idSocio") Long idSocio, Model model) {
        model.addAttribute("titulo", "Copal - Actualizar Socio");
        model.addAttribute("contenido", "socio/modificar-socio");
        model.addAttribute("socio", this.socioService.getById(idSocio));

        return "index";
    }

    @PostMapping("/save")
    public String guardar(@Valid @ModelAttribute("request") SocioRequest request, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // TODO: despues reemplazar por un log
            result.getAllErrors().forEach(error -> System.out.println(error.getDefaultMessage()));
            model.addAttribute("titulo", "Copal - Nuevo Socio");
            model.addAttribute("contenido", "socio/agregar-socio");

            return "index";
        }
        this.socioService.create(request);
        return "redirect:/socios";
    }
    @PostMapping("/update/{idSocio}")
    public String actualizar(@Valid @ModelAttribute("request") SocioRequest request,
            @PathVariable("idSocio") Long idSocio, BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            // TODO: despues reemplazar por un log
            result.getAllErrors().forEach(error -> System.out.println(error.getDefaultMessage()));
            model.addAttribute("titulo", "Copal - Actualizar Socio");
            model.addAttribute("contenido", "socio/modificar-socio");
            model.addAttribute("socio", this.socioService.getById(idSocio));

            return "index";
        }
        this.socioService.update(request, idSocio);
        return "redirect:/socios";
    }

    //
    // @InitBinder
    // public void initBinder(WebDataBinder webDataBinder){
    // SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    // webDataBinder.registerCustomEditor(Date.class, new
    // CustomDateEditor(dateFormat, false));
    // }

}

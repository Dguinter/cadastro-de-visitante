package com.evento.controller;

import com.evento.service.SorteioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SorteioController {

    private final SorteioService sorteioService;

    public SorteioController(SorteioService sorteioService) {
        this.sorteioService = sorteioService;
    }

    @GetMapping("/sorteio")
    public String realizarSorteio(Model model) {
        String resultado = sorteioService.realizarSorteio();
        model.addAttribute("resultado", resultado);
        return "sorteio";
    }
}

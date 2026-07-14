package com.evento.controller;

import com.evento.service.BrindeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller Brinde
 * Responsável por gerenciar as rotas relacionadas aos brindes.
 * Utiliza Thymeleaf para renderizar as páginas HTML.
 */
@Controller
@RequestMapping("/brindes")
public class BrindeController {

    private final BrindeService service;

    public BrindeController(BrindeService service) {
        this.service = service;
    }

    /**
     * Lista todos os brindes cadastrados.
     * @param model objeto usado para enviar dados para a view Thymeleaf
     * @return nome do template HTML (lista.html)
     */
    @GetMapping("/lista")
    public String listar(Model model) {
        model.addAttribute("brindes", service.listarTodos());
        return "brindes/lista"; // Thymeleaf renderiza brindes/lista.html
    }
}

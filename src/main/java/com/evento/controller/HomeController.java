package com.evento.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller Home
 * Responsável pela página inicial e menu de navegação.
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index"; // Thymeleaf renderiza index.html
    }
}

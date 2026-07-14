package com.evento.controller;

import com.evento.model.Visitante;
import com.evento.service.VisitanteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controller Visitante
 * Responsável por gerenciar as rotas relacionadas ao cadastro de visitantes.
 * Utiliza Thymeleaf para renderizar as páginas HTML.
 */
@Controller
@RequestMapping("/visitantes")
public class VisitanteController {

    private final VisitanteService service;

    /**
     * Construtor com injeção de dependência do serviço.
     * O Spring Boot injeta automaticamente o VisitanteService.
     */
    public VisitanteController(VisitanteService service) {
        this.service = service;
    }

    /**
     * Exibe o formulário de cadastro de visitantes.
     * @param model objeto usado para enviar dados para a view Thymeleaf
     * @return nome do template HTML (formulario.html)
     */
    @GetMapping
    public String formulario(Model model) {
        model.addAttribute("visitante", new Visitante()); // objeto vazio para o formulário
        model.addAttribute("mensagem", ""); // mensagem inicial vazia
        return "formulario"; // Thymeleaf renderiza formulario.html
    }

    /**
     * Processa o envio do formulário de cadastro.
     * @param visitante objeto preenchido pelo usuário
     * @param model objeto usado para enviar dados para a view Thymeleaf
     * @return retorna novamente o formulário com mensagem de sucesso
     */
    @PostMapping
    public String salvar(@ModelAttribute Visitante visitante, Model model) {
        service.salvar(visitante); // salva no banco

        // Simula impressão de crachá com QR Code
        System.out.println("Crachá gerado para: " + visitante.getNome() + " | QRCode com dados do visitante");

        // Mensagem de confirmação
        model.addAttribute("mensagem", "Cadastro realizado com sucesso!");

        // Limpa os campos para o próximo visitante
        model.addAttribute("visitante", new Visitante());

        return "formulario"; // Thymeleaf renderiza novamente o formulário
    }

    /**
     * Lista todos os visitantes cadastrados.
     * @param model objeto usado para enviar dados para a view Thymeleaf
     * @return nome do template HTML (lista.html)
     */
    @GetMapping("/lista")
    public String listar(Model model) {
        model.addAttribute("visitantes", service.listarTodos()); // busca todos os visitantes
        return "lista"; // Thymeleaf renderiza lista.html
    
    }

}

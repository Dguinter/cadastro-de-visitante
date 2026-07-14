package com.evento.service;

import com.evento.model.Visitante;
import com.evento.repository.VisitanteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Serviço Visitante
 * Camada responsável pela lógica de negócio relacionada ao visitante.
 * Utiliza o VisitanteRepository para realizar operações no banco de dados.
 */
@Service
public class VisitanteService {

    private final VisitanteRepository repository;

    /**
     * Construtor com injeção de dependência do repositório.
     * O Spring Boot automaticamente injeta o VisitanteRepository aqui.
     */
    public VisitanteService(VisitanteRepository repository) {
        this.repository = repository;
    }

    /**
     * Salva um visitante no banco de dados.
     * @param visitante objeto contendo nome, telefone, e-mail e empresa
     * @return visitante salvo com ID gerado automaticamente
     */
    public Visitante salvar(Visitante visitante) {
        return repository.save(visitante);
    }

    /**
     * Lista todos os visitantes cadastrados.
     * @return lista de visitantes
     */
    public List<Visitante> listarTodos() {
        return repository.findAll();
    }

    /**
     * Busca um visitante pelo ID.
     * @param id identificador único do visitante
     * @return Optional contendo o visitante, caso exista
     */
    public Optional<Visitante> buscarPorId(Long id) {
        return repository.findById(id);
    }

    /**
     * Remove um visitante pelo ID.
     * @param id identificador único do visitante
     */
    public void remover(Long id) {
        repository.deleteById(id);
    }
}

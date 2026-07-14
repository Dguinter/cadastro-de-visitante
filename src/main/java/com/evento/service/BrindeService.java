package com.evento.service;

import com.evento.model.Brinde;
import com.evento.repository.BrindeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service Brinde
 * Responsável pela lógica de negócio relacionada aos brindes.
 */
@Service
public class BrindeService {

    private final BrindeRepository repository;

    public BrindeService(BrindeRepository repository) {
        this.repository = repository;
    }

    /**
     * Lista todos os brindes cadastrados.
     * @return lista de brindes
     */
    public List<Brinde> listarTodos() {
        return repository.findAll();
    }

    /**
     * Salva um novo brinde.
     * @param brinde objeto a ser salvo
     */
    public void salvar(Brinde brinde) {
        repository.save(brinde);
    }
}

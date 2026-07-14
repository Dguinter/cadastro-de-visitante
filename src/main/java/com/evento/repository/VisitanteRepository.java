package com.evento.repository;

import com.evento.model.Visitante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório Visitante
 * Responsável por operações de persistência no banco de dados.
 * Extende JpaRepository para fornecer métodos prontos como save, findAll, findById, delete.
 */
@Repository
public interface VisitanteRepository extends JpaRepository<Visitante, Long> {
    // Podemos adicionar consultas personalizadas aqui futuramente
}

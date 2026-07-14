package com.evento.repository;

import com.evento.model.Brinde;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrindeRepository extends JpaRepository<Brinde, Long> {
}

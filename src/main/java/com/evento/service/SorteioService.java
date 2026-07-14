package com.evento.service;

import com.evento.model.Brinde;
import com.evento.model.Visitante;
import com.evento.repository.BrindeRepository;
import com.evento.repository.VisitanteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * Serviço responsável pela lógica de sorteio de brindes.
 */
@Service
public class SorteioService {

    private final VisitanteRepository visitanteRepository;
    private final BrindeRepository brindeRepository;

    public SorteioService(VisitanteRepository visitanteRepository, BrindeRepository brindeRepository) {
        this.visitanteRepository = visitanteRepository;
        this.brindeRepository = brindeRepository;
    }

    /**
     * Executa sorteio quando há 50 ou mais visitantes cadastrados.
     * @return mensagem com resultado do sorteio
     */
    public String realizarSorteio() {
        List<Visitante> visitantes = visitanteRepository.findAll();
        List<Brinde> brindes = brindeRepository.findAll();

        if (visitantes.size() < 50) {
            return "Ainda não atingimos 50 visitantes para iniciar o sorteio.";
        }

        if (brindes.isEmpty()) {
            return "Não há brindes cadastrados para sorteio.";
        }

        Random random = new Random();
        Visitante sorteado = visitantes.get(random.nextInt(visitantes.size()));
        Brinde brinde = brindes.get(random.nextInt(brindes.size()));

        return "🎉 Sorteio realizado! O visitante " + sorteado.getNome() +
               " ganhou o brinde: " + brinde.getNome() + " 🎁";
    }
}

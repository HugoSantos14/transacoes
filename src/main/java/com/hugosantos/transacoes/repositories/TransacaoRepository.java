package com.hugosantos.transacoes.repositories;

import com.hugosantos.transacoes.model.entities.Transacao;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class TransacaoRepository {

    private static final Map<Long, Transacao> transacoes = new HashMap<>();
    private static long contadorId = 1;

    // POST
    public void save(Transacao transacao) {
        if (!transacao.getDataHora().isAfter(OffsetDateTime.now()) && transacao.getValor() >= 0) {
            transacao.setId(contadorId++);
            transacoes.put(transacao.getId(), transacao);
        }
    }

    // DELETE
    public void deleteAll() {
        transacoes.clear();
        contadorId = 1;
    }

    // GET
    public DoubleSummaryStatistics getEstatisticas() {
        return transacoes.isEmpty() ? null : transacoes.values().stream()
                .filter(t -> t.getDataHora().isAfter(OffsetDateTime.now().minusMinutes(1)))
                .map(Transacao::getValor)
                .collect(Collectors.summarizingDouble(Double::doubleValue));
    }
}

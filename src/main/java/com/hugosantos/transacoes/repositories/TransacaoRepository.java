package com.hugosantos.transacoes.repositories;

import com.hugosantos.transacoes.model.entities.Transacao;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TransacaoRepository {

    private static final Map<Long, Transacao> transacoes = new HashMap<>();
    private static long contadorId = 1;

    // POST
    public void adicionarTransacao(Transacao transacao) {
        if (!transacao.getDataHora().isAfter(OffsetDateTime.now()) && transacao.getValor() >= 0) {
            transacao.setId(contadorId++);
            transacoes.put(transacao.getId(), transacao);
        }
    }

    // DELETE
    public void apagarTransacoes() {
        transacoes.clear();
        contadorId = 1;
    }

    // GET
    public Map<String, Object> getEstatisticas() {
        final Map<String, Object> resultado = new LinkedHashMap<>();
        final DoubleSummaryStatistics estatisticas = transacoes.values().stream()
                .map(Transacao::getValor)
                .collect(Collectors.summarizingDouble(Double::doubleValue));

        resultado.put("count", estatisticas.getCount());
        resultado.put("sum", estatisticas.getSum());
        resultado.put("avg", estatisticas.getAverage());
        resultado.put("min", estatisticas.getMin());
        resultado.put("max", estatisticas.getMax());

        return resultado;
    }
}

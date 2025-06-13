package com.hugosantos.transacoes.services;

import com.hugosantos.transacoes.repositories.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    public Map<String, Object> getEstatisticas() {
        final Map<String, Object> resultado = new LinkedHashMap<>();
        final DoubleSummaryStatistics estatisticas = transacaoRepository.getEstatisticas();

        if (estatisticas == null) {
            resultado.put("count", 0);
            resultado.put("sum", 0.0);
            resultado.put("avg", 0.0);
            resultado.put("min", 0.0);
            resultado.put("max", 0.0);
        } else {
            resultado.put("count", estatisticas.getCount());
            resultado.put("sum", estatisticas.getSum());
            resultado.put("avg", estatisticas.getAverage());
            resultado.put("min", estatisticas.getMin());
            resultado.put("max", estatisticas.getMax());
        }

        return resultado;
    }
}

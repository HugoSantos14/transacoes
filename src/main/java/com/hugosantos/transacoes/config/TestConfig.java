package com.hugosantos.transacoes.config;

import com.hugosantos.transacoes.model.entities.Transacao;
import com.hugosantos.transacoes.repositories.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.OffsetDateTime;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Override
    public void run(String... args) throws Exception {
        transacaoRepository.save(new Transacao(123.45, OffsetDateTime.parse("2020-08-07T12:34:56.789-03:00")));
        transacaoRepository.save(new Transacao(347.70, OffsetDateTime.now()));
    }
}

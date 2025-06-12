package com.hugosantos.transacoes.model.entities;

import lombok.*;

import java.time.OffsetDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Transacao {

    @EqualsAndHashCode.Include
    private Long id;

    private Double valor;
    private OffsetDateTime dataHora;

    public Transacao(@NonNull Double valor, @NonNull OffsetDateTime dataHora) {
        this.valor = valor;
        this.dataHora = dataHora;
    }
}

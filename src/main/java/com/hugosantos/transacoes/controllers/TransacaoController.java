package com.hugosantos.transacoes.controllers;

import com.hugosantos.transacoes.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @GetMapping(value = "/estatistica")
    public ResponseEntity<Map<String, Object>> getEstatisticas() {
        return ResponseEntity.ok().body(transacaoService.getEstatisticas());
    }
}

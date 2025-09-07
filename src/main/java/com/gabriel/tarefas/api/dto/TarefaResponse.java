package com.gabriel.tarefas.api.dto;

import java.time.LocalDate;

public class TarefaResponse {
    private Long id;
    private String nome;
    private LocalDate dataEntrega;
    private String responsavel;

    public TarefaResponse(Long id, String nome, LocalDate dataEntrega, String responsavel) {
        this.id = id;
        this.nome = nome;
        this.dataEntrega = dataEntrega;
        this.responsavel = responsavel;
    }
    public Long getId() { return id; }
    public String getNome() { return nome; }
    public LocalDate getDataEntrega() { return dataEntrega; }
    public String getResponsavel() { return responsavel; }
}

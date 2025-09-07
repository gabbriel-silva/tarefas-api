package com.gabriel.tarefas.api.mapper;

import com.gabriel.tarefas.api.dto.TarefaRequest;
import com.gabriel.tarefas.api.dto.TarefaResponse;
import com.gabriel.tarefas.domain.Tarefa;

public class TarefaMapper {
    public static Tarefa toEntity(TarefaRequest r) {
        return new Tarefa(r.getNome(), r.getDataEntrega(), r.getResponsavel());
    }
    public static void copyToEntity(TarefaRequest r, Tarefa t) {
        t.setNome(r.getNome());
        t.setDataEntrega(r.getDataEntrega());
        t.setResponsavel(r.getResponsavel());
    }
    public static TarefaResponse toResponse(Tarefa t) {
        return new TarefaResponse(t.getId(), t.getNome(), t.getDataEntrega(), t.getResponsavel());
    }
}

package com.gabriel.tarefas.repository;

import com.gabriel.tarefas.domain.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}

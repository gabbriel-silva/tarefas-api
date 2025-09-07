package com.gabriel.tarefas.api;

import com.gabriel.tarefas.api.dto.TarefaRequest;
import com.gabriel.tarefas.api.dto.TarefaResponse;
import com.gabriel.tarefas.api.mapper.TarefaMapper;
import com.gabriel.tarefas.domain.Tarefa;
import com.gabriel.tarefas.repository.TarefaRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    private final TarefaRepository repository;

    public TarefaController(TarefaRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<TarefaResponse> criar(@Valid @RequestBody TarefaRequest request) {
        Tarefa salvo = repository.save(TarefaMapper.toEntity(request));
        return ResponseEntity.created(URI.create("/api/tarefas/" + salvo.getId()))
                .body(TarefaMapper.toResponse(salvo));
    }

    @GetMapping
    public List<TarefaResponse> listar() {
        return repository.findAll().stream()
                .map(TarefaMapper::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaResponse> buscar(@PathVariable Long id) {
        return repository.findById(id)
                .map(t -> ResponseEntity.ok(TarefaMapper.toResponse(t)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TarefaResponse> atualizar(@PathVariable Long id, @Valid @RequestBody TarefaRequest request) {
        return repository.findById(id).map(existing -> {
            TarefaMapper.copyToEntity(request, existing);
            Tarefa salvo = repository.save(existing);
            return ResponseEntity.ok(TarefaMapper.toResponse(salvo));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

package com.tarefas.listastarefas.controller;

import com.tarefas.listastarefas.exception.ResourceNotFoundException;
import com.tarefas.listastarefas.model.Tarefa;
import com.tarefas.listastarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class TarefaController {

    @Autowired
    private TarefaRepository tarefaRepository;

    // pegar todas as tarefas

    @GetMapping("/tarefas")
    public List<Tarefa> getAllTarefa(){
        return tarefaRepository.findAll();
    }

    // criar tarefa
    @PostMapping("/tarefas")
    public Tarefa createTarefa(@RequestBody Tarefa tarefa){
        return tarefaRepository.save(tarefa);
    }

    // pegar tarefa por id
    @GetMapping("/tarefas/{id}")
    public ResponseEntity<Tarefa> getTarefaById(@PathVariable int id){
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Não existe uma tarefa com este id: "+id));
        return ResponseEntity.ok(tarefa);
    }

    //editar tarefa
    @PutMapping("/tarefas/{id}")
    public ResponseEntity<Tarefa> updateTarefa(@PathVariable int id, @RequestBody Tarefa tarefaDetails){
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Não existe uma tarefa com este id: "+id));
        tarefa.setTarefa(tarefaDetails.getTarefa());
        Tarefa updatedTarefa = tarefaRepository.save(tarefa);
        return ResponseEntity.ok(updatedTarefa);
    }

    //Deletar tarefa
    @DeleteMapping("/tarefas/{id}")
    public ResponseEntity <Map<String, Boolean>> deleteTarefa(@PathVariable int id){
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Não existe uma tarefa com este id: "+id));
        tarefaRepository.delete(tarefa);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deletado", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

}

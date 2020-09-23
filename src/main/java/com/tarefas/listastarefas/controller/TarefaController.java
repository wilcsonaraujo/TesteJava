package com.tarefas.listastarefas.controller;

import com.tarefas.listastarefas.model.Tarefa;
import com.tarefas.listastarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // criar tarefa rest
    @PostMapping("/tarefas")
    public Tarefa createTarefa(@RequestBody Tarefa tarefa){
        return tarefaRepository.save(tarefa);
    }
}

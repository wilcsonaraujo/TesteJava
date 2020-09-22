package com.tarefas.listastarefas.controller;

import com.tarefas.listastarefas.model.Tarefa;
import com.tarefas.listastarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}

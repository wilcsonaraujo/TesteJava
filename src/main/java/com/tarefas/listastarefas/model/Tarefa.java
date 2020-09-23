package com.tarefas.listastarefas.model;


import org.jetbrains.annotations.Contract;

import javax.persistence.*;

@Entity
@Table(name = "tarefa_tab")
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "tarefa")
    private String tarefa;
    @Column(name = "status")
    private String status;

    Tarefa(){
        this.status = "Pendente";
    }

    public String getTarefa() {
        return tarefa;
    }
    public void setTarefa(String tarefa) {
        this.tarefa = tarefa;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}

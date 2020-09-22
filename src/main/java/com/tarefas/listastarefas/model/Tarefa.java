package com.tarefas.listastarefas.model;


import javax.persistence.*;

@Entity
@Table(name = "TAREFA_TBL")
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "tarefa")
    private String tarefa;
    @Column(name = "status")
    private String status;

    Tarefa(){
        this.status = "Pendente";
    }

    public String getValor() {
        return tarefa;
    }
    public void setValor(String valor) {
        this.tarefa = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}

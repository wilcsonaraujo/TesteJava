package com.tarefas.listastarefas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class ListastarefasApplication {
	public static void main(String[] args) {
		SpringApplication.run(ListastarefasApplication.class, args);
	}

}

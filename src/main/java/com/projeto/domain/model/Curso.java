package com.projeto.domain.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Accessors(chain = true)
@Entity
public class Curso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private Integer cargaHoraria;
    private String tipoCurso;
    private Integer totalPeriodos;
    @ManyToOne
    private Professor coordenador;



    public Curso() {
    }

    public Curso(Long id, String nome, Integer cargaHoraria, String tipoCurso, Integer totalPeriodos, Professor coordenador) {

        this.id = id;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.tipoCurso = tipoCurso;
        this.totalPeriodos = totalPeriodos;
        this.coordenador = coordenador;
    }
}

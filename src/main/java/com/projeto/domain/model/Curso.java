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
    private final MySerializable serializable = new MySerializable();
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

    public Curso(String nome, Integer cargaHoraria, String tipoCurso,
                 Integer totalPeriodos, Professor coordenador) {
        this.setCargaHoraria(cargaHoraria)
                .setCoordenador(coordenador)
                .setId(id)
                .setNome(nome)
                .setTipoCurso(tipoCurso)
                .setTotalPeriodos(totalPeriodos);
    }

    public Serializable getSerializable() {
        return serializable;
    }

    private class MySerializable implements Serializable {
    }
}

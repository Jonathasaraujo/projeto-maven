package com.projeto.controller;

import com.projeto.domain.model.Curso;
import com.projeto.domain.model.Professor;

public class Main {

    public static void main(String[] args) {
        Professor professor = new Professor(1L, "Tonhão");
        Curso curso = new Curso(
                "BSI", 5, "Integral", 8, professor
        );
    }
}

package com.projeto.controller;

import com.projeto.domain.dao.ProfessorDao;
import com.projeto.domain.dao.CursoDao;
import com.projeto.domain.model.Curso;
import com.projeto.domain.model.Professor;

public class Main {

    public static void main(String[] args) {
        Professor professor = new Professor(1L, "Tonhão");
        Curso curso = new Curso( 1L,
                "BSI", 5, "Integral", 8, professor
        );
        ProfessorDao.getInstance().save(professor);
        CursoDao.getInstance().save(curso);
    }
}

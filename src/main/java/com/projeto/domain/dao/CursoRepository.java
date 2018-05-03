package com.projeto.domain.dao;

import com.projeto.domain.model.Curso;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface CursoRepository extends CrudRepository<Long, Curso> {
}

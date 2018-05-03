package com.projeto.domain.dao;

import com.projeto.domain.model.Curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class CursoDao {
    private static CursoDao instance = new CursoDao();

    public static CursoDao getInstance() {
        return instance;
    }

    public void save(Curso curso) {
        EntityManager em = ManageEntity.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if (curso.getId() != null) {
                em.merge(curso);
            } else {
                em.persist(curso);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            ManageEntity.close(em);
        }
    }

    public List<Curso> getAllCursos() {
        EntityManager em = ManageEntity.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Curso> cursos = null;
        try {
            tx.begin();
            TypedQuery<Curso> query = em.createQuery("select c from Curso c", Curso.class);
            cursos = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            ManageEntity.close(em);
        }
        return cursos;
    }

    public Curso getCurso(long id) {
        EntityManager em = ManageEntity.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Curso curso = null;
        try {
            tx.begin();
            curso = em.find(Curso.class, id);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            ManageEntity.close(em);
        }
        return curso;
    }

    public void delete(Curso curso) {
        EntityManager em = ManageEntity.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(Curso.class, curso.getId()));
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            ManageEntity.close(em);
        }
    }

}
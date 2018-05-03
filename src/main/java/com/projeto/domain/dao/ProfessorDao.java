package com.projeto.domain.dao;

import com.projeto.domain.model.Professor;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProfessorDao {
    private static ProfessorDao instance = new ProfessorDao();

    public ProfessorDao() {
    }

    public static ProfessorDao getInstance() {
        return instance;
    }

    public void save(Professor professor) {
        EntityManager em = ManageEntity.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if (professor.getId() != null) {
                em.merge(professor);
            } else {
                em.persist(professor);
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

    public List<Professor> getAllProfessores() {
        EntityManager em = ManageEntity.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Professor> professores = null;
        try {
            tx.begin();
            TypedQuery<Professor> query = em.createQuery("select p from Professor p", Professor.class);
            professores = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            ManageEntity.close(em);
        }
        return professores;
    }

    public Professor getProfessor(long id) {
        EntityManager em = ManageEntity.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Professor professor = null;
        try {
            tx.begin();
            professor = em.find(Professor.class, id);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            ManageEntity.close(em);
        }
        return professor;
    }

    public void delete(Professor professor) {
        EntityManager em = ManageEntity.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(Professor.class, professor.getId()));
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

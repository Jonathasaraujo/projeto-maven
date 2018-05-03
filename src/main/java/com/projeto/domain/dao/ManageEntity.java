package com.projeto.domain.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManageEntity {
    private static EntityManagerFactory entityManagerFactory = null;
    private ManageEntity() {
    }

    public static EntityManager getEntityManager() {
        if (entityManagerFactory == null) entityManagerFactory = Persistence
                .createEntityManagerFactory("exemplo");
        return entityManagerFactory.createEntityManager();
    }

    public static void close(EntityManager em) {
        if (em != null) em.close();
    }

}

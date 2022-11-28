package com.simplon.marocship.dao;

import com.simplon.marocship.Entities.ChauffeurEntity;

public class ChauffeurDao extends AbstractHibernateDao<ChauffeurEntity> {
    private Class<ChauffeurEntity> clazz;

    public ChauffeurDao() {
        setClazz(ChauffeurEntity.class);
    }

    public ChauffeurEntity findByEmail(String email) {
        return jpaService.runInTransaction(entityManager -> {
            return entityManager.createQuery("select c from ChauffeurEntity c where c.email = :email", ChauffeurEntity.class)
                    .setParameter("email", email)
                    .getSingleResult();
        });
    }

    // update password
}

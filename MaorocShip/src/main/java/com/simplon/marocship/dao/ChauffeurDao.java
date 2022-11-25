package com.simplon.marocship.dao;

import com.simplon.marocship.Entities.ChauffeurEntity;

public class ChauffeurDao extends AbstractHibernateDao<ChauffeurEntity> {
    private Class<ChauffeurEntity> clazz;

    public ChauffeurDao() {
        setClazz(ChauffeurEntity.class);
    }

    public ChauffeurEntity findByEmail(String email) {
        return jpaService.runInTransaction(entityManager -> {
            return (ChauffeurEntity) entityManager.createQuery("from " + clazz.getName() + " where email = :email")
                    .setParameter("email", email)
                    .getSingleResult();
        });
    }

    // update password
}

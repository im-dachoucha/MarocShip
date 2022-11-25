package com.simplon.marocship.dao;

import com.simplon.marocship.Entities.RespLivraisonEntity;

public class RespLivraisonDao  extends AbstractHibernateDao<RespLivraisonEntity> {
    private Class<RespLivraisonEntity> clazz;

    public RespLivraisonDao() {
        setClazz(RespLivraisonEntity.class);
    }

    public RespLivraisonEntity findByEmail(String email) {
        return jpaService.runInTransaction(entityManager -> {
            return (RespLivraisonEntity) entityManager.createQuery("from " + clazz.getName() + " where email = :email")
                    .setParameter("email", email)
                    .getSingleResult();
        });
    }

    // update password
}


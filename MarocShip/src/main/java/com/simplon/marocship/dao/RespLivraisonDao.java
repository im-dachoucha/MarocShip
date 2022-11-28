package com.simplon.marocship.dao;

import com.simplon.marocship.Entities.RespLivraisonEntity;
import org.mindrot.jbcrypt.BCrypt;

public class RespLivraisonDao  extends AbstractHibernateDao<RespLivraisonEntity> {
    private Class<RespLivraisonEntity> clazz;

    public RespLivraisonDao() {
        setClazz(RespLivraisonEntity.class);
    }

    public RespLivraisonEntity findByEmail(String email) {
        try{
        return jpaService.runInTransaction(entityManager -> {
            return entityManager.createQuery("select r from RespLivraisonEntity r where r.email = :email", RespLivraisonEntity.class)
                    .setParameter("email", email)
                    .getSingleResult();
        });
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean hashPasswordThenCreat(RespLivraisonEntity respLivraisonEntity) {
        respLivraisonEntity.setPassword(BCrypt.hashpw(respLivraisonEntity.getPassword(), BCrypt.gensalt()));
        return jpaService.runInTransaction(entityManager -> {
            entityManager.persist(respLivraisonEntity);
            return true;
        });
    }

    public boolean hashPasswordThenCreat(RespLivraisonEntity respLivraisonEntity) {
        respLivraisonEntity.setPassword(BCrypt.hashpw(respLivraisonEntity.getPassword(), BCrypt.gensalt()));
        return jpaService.runInTransaction(entityManager -> {
            entityManager.persist(respLivraisonEntity);
            return true;
        });
    }


}


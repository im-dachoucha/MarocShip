package com.simplon.maorocship.dao;

import com.simplon.maorocship.Entities.AdminEntity;

public class AdminDao extends AbstractHibernateDao<AdminEntity> {
    private Class<AdminEntity> clazz;

    public AdminDao() {
        setClazz(AdminEntity.class);
    }

    public AdminEntity findByEmail(String email) {
        return jpaService.runInTransaction(entityManager -> {
            return (AdminEntity) entityManager.createQuery("from " + clazz.getName() + " where email = :email")
                    .setParameter("email", email)
                    .getSingleResult();
        });
    }

    // update password
//    public void updatePassword(String password, String email) {
//        jpaService.runInTransaction(entityManager -> {
//            entityManager.createQuery("update " + clazz.getName() + " set password = :password where email = :email")
//                    .setParameter("password", password)
//                    .setParameter("email", email)
//                    .executeUpdate();
//            return null;
//        });
//    }
}

package com.simplon.marocship.dao;

import com.simplon.marocship.Entities.VehiculeEntity;

public class VehiculeDao extends AbstractHibernateDao<VehiculeEntity> {
    private Class<VehiculeEntity> clazz;

    public VehiculeDao() {
        setClazz(VehiculeEntity.class);
    }

    public VehiculeEntity findByType(String type) {
        return jpaService.runInTransaction(entityManager -> {
            return (VehiculeEntity) entityManager.createQuery("from " + clazz.getName() + " where type = :type")
                    .setParameter("type", type)
                    .getSingleResult();
        });
    }

}

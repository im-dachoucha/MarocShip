package com.simplon.marocship.dao;

import com.simplon.marocship.Entities.LivraisonEntity;

public class LivraisonDao extends AbstractHibernateDao<LivraisonEntity> {
    private Class<LivraisonEntity> clazz;

    public LivraisonDao() {
        setClazz(LivraisonEntity.class);
    }

}

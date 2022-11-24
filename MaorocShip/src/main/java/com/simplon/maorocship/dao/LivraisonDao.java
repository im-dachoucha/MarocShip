package com.simplon.maorocship.dao;

import com.simplon.maorocship.Entities.LivraisonEntity;

public class LivraisonDao extends AbstractHibernateDao<LivraisonEntity> {
    private Class<LivraisonEntity> clazz;

    public LivraisonDao() {
        setClazz(LivraisonEntity.class);
    }

}

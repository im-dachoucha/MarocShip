package com.simplon.marocship.Controllers;

import com.simplon.marocship.Beans.LivraisonBean;
import com.simplon.marocship.Beans.UserBean;
import com.simplon.marocship.Entities.LivraisonEntity;
import com.simplon.marocship.dao.LivraisonDao;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class Livraison {

    @Inject
    private UserBean userBean;
    private LivraisonBean livraisonBean;


    public boolean isRespLivraison() {
        return userBean.getRole().equals("respLivraison");
    }

    public boolean isChauffeur() {
        return userBean.getRole().equals("chauffeur");
    }

    public boolean addLivraison() {
        LivraisonEntity livraisonEntity = new LivraisonEntity();
        livraisonEntity.setBeginning(livraisonBean.getLieuxDepart());
        livraisonEntity.setDestination(livraisonBean.getLieuxArrive());
        livraisonEntity.setWeight(String.valueOf(livraisonBean.getPoids()));
        livraisonEntity.setZone(livraisonBean.getZone());
        livraisonEntity.setDate(livraisonBean.getDate());
        // create livraison using dao
        LivraisonDao livraisonDao = new LivraisonDao();
        return livraisonDao.create(livraisonEntity);
    }
}

package com.simplon.marocship.Controllers;

import com.simplon.marocship.Beans.LivraisonBean;
import com.simplon.marocship.Beans.UserBean;
import com.simplon.marocship.Entities.ChauffeurEntity;
import com.simplon.marocship.Entities.LivraisonEntity;
import com.simplon.marocship.dao.ChauffeurDao;
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
        livraisonEntity.setStatus("en attente");
        // create livraison using dao
        LivraisonDao livraisonDao = new LivraisonDao();
        return livraisonDao.create(livraisonEntity);
    }

    public boolean updateLivraisonChauffeur(){
        LivraisonEntity livraisonEntity = new LivraisonDao().findOne(livraisonBean.getId());
        ChauffeurEntity chauffeurEntity = new ChauffeurDao().findOne(livraisonBean.getChauffeurId());
        LivraisonDao livraisonDao = new LivraisonDao();
        livraisonEntity.setChauffeur(chauffeurEntity);
        try {
            livraisonDao.update(livraisonEntity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

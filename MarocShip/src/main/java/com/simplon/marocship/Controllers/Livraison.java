package com.simplon.marocship.Controllers;

import com.simplon.marocship.Beans.LivraisonBean;
import com.simplon.marocship.Beans.UserBean;
import com.simplon.marocship.Entities.ChauffeurEntity;
import com.simplon.marocship.Entities.LivraisonEntity;
import com.simplon.marocship.dao.ChauffeurDao;
import com.simplon.marocship.dao.LivraisonDao;
import com.simplon.marocship.services.SimpleEmail;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

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
        // Create a new LivraisonEntity object and set its properties
        LivraisonEntity livraisonEntity = new LivraisonEntity();
        livraisonEntity.setBeginning(livraisonBean.getLieuxDepart());
        livraisonEntity.setDestination(livraisonBean.getLieuxArrive());
        livraisonEntity.setWeight(String.valueOf(livraisonBean.getPoids()));
        livraisonEntity.setZone(livraisonBean.getZone());
        livraisonEntity.setDate(livraisonBean.getDate());
        livraisonEntity.setStatus("en attente");
        // create livraison using dao
        LivraisonDao livraisonDao = new LivraisonDao();
        try {
            // if livraison is created successfully send email to all chauffeurs
            if (livraisonDao.create(livraisonEntity)) {
                List<ChauffeurEntity> chauffeurs = new ChauffeurDao().findAll();
                // send email to all chauffeurs
                for (ChauffeurEntity chauffeur : chauffeurs) {
                    // send email
                    SimpleEmail.sendSimpleEmail( chauffeur.getEmail(), "Nouvelle livraison",
                                    "Une nouvelle livraison est disponible <br> " +
                                        "Click ici pour acceptée la Livraison :  " +
                                        "<a>http://localhost:8080/marocship/chauffeur/livraison/</a>"+chauffeur.getId());
                }
                return true;
            }else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateLivraisonChauffeur(){
        LivraisonEntity livraisonEntity = new LivraisonDao().findOne(livraisonBean.getId());
        ChauffeurEntity chauffeurEntity = new ChauffeurDao().findOne(livraisonBean.getChauffeurId());
        LivraisonDao livraisonDao = new LivraisonDao();
        livraisonEntity.setChauffeur(chauffeurEntity);
        livraisonEntity.setStatus("Confirme");
        try {
            livraisonDao.update(livraisonEntity);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


}

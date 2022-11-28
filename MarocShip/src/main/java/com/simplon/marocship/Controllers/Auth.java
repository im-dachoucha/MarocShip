package com.simplon.marocship.Controllers;


import com.simplon.marocship.Beans.UserBean;
import com.simplon.marocship.Entities.AdminEntity;
import com.simplon.marocship.Entities.ChauffeurEntity;
import com.simplon.marocship.Entities.RespLivraisonEntity;
import com.simplon.marocship.dao.AdminDao;
import com.simplon.marocship.dao.ChauffeurDao;
import com.simplon.marocship.dao.RespLivraisonDao;
import com.simplon.marocship.services.Security;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class Auth implements Serializable {

    @Inject
    UserBean userBean;

    // login function to check if the user role in switch case (admin, respLivraison, chauffeur)
    public boolean login() {
        switch (userBean.getRole()) {
            case "admin":
                try {
                    AdminEntity adminEntity = new AdminDao().findByEmail(userBean.getEmail());
                    if (adminEntity != null) {

                        if (Security.checkPassword(userBean.getPassword(), adminEntity.getPassword())) {
                            userBean.setAdminEntity(adminEntity);
                            return true;
                        }
                    }else {
                        userBean.setMsg("Email ou mot de passe incorrect");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            case "respLivraison":
                try {
                    RespLivraisonDao respLivraisonDao = new RespLivraisonDao();
                    RespLivraisonEntity respLivraisonEntity = respLivraisonDao.findByEmail(userBean.getEmail());
                    if (respLivraisonEntity != null) {
                        if (Security.checkPassword(userBean.getPassword(), respLivraisonEntity.getPassword())) {
                            userBean.setRespLivraisonEntity(respLivraisonEntity);
                            return true;
                        }
                    }else {
                        userBean.setMsg("Email ou mot de passe incorrect");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            case "chauffeur":
                try {
                    ChauffeurEntity chauffeurEntity = new ChauffeurDao().findByEmail(userBean.getEmail());
                    if (chauffeurEntity != null) {
                        if (Security.checkPassword(userBean.getPassword(), chauffeurEntity.getPassword())) {
                            userBean.setChauffeurEntity(chauffeurEntity);
                            return true;
                        }
                    }else {
                        userBean.setMsg("Email ou mot de passe incorrect");
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            default:
                return false;
        }
    }

}

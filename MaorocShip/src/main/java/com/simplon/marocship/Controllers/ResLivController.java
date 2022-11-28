package com.simplon.marocship.Controllers;

import com.simplon.marocship.Beans.ResponsableLivraisonBean;
import com.simplon.marocship.Entities.RespLivraisonEntity;
import com.simplon.marocship.dao.RespLivraisonDao;
import com.simplon.marocship.services.Security;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.IOException;

@Named
@RequestScoped
public class ResLivController {

    @Inject
    ResponsableLivraisonBean respLivBean;

    public void login() {
        System.out.println("Email : " + respLivBean.getEmail() + " | Password : " + respLivBean.getPassword());
        RespLivraisonDao respLivraisonDao = new RespLivraisonDao();

        RespLivraisonEntity respLiv = respLivraisonDao.findByEmail(respLivBean.getEmail());
        System.out.println(respLiv.getName());

        if (respLiv != null) {
            if (Security.checkPassword(respLivBean.getPassword(), respLiv.getPassword())) {
                System.out.println("here");
                ExternalContext ec = FacesContext.getCurrentInstance()
                        .getExternalContext();
                try {
                    ec.redirect(ec.getRequestContextPath()
                            + "/dashboard.xhtml");
//                    + "/faces/jsf/index.xhtml");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        respLivBean.setMessage("Wrong Credentials!!");
    }
}

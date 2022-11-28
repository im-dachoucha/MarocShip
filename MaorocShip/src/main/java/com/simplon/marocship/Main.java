package com.simplon.marocship;

import com.simplon.marocship.Entities.RespLivraisonEntity;
import com.simplon.marocship.Entities.VehiculeEntity;
import com.simplon.marocship.dao.RespLivraisonDao;
import com.simplon.marocship.dao.VehiculeDao;
import com.simplon.marocship.services.JpaService;
import com.simplon.marocship.services.Security;

public class Main {

        public static void main(String[] args) {
            RespLivraisonDao respLivraisonDao = new RespLivraisonDao();
            RespLivraisonEntity respLivraison = new RespLivraisonEntity();
            respLivraison.setEmail("resp1@gmail.com");
            respLivraison.setPassword("test");
            respLivraison.setName("response one");
            respLivraisonDao.hashPasswordThenCreat(respLivraison);
//            VehiculeEntity vehiculeEntity = new VehiculeEntity();
//            vehiculeEntity.setType("grand-camion");
//            VehiculeDao vehiculeDao = new VehiculeDao();
//            vehiculeDao.create(vehiculeEntity);
//            JpaService jpaService = new Jpa:

        }
}

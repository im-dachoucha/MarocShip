package com.simplon.marocship;

import com.simplon.marocship.Entities.VehiculeEntity;
import com.simplon.marocship.dao.VehiculeDao;
import com.simplon.marocship.services.JpaService;

public class Main {

        public static void main(String[] args) {
            VehiculeEntity vehiculeEntity = new VehiculeEntity();
            vehiculeEntity.setType("grand-camion");
            VehiculeDao vehiculeDao = new VehiculeDao();
            vehiculeDao.create(vehiculeEntity);
//            JpaService jpaService = new Jpa:

        }
}

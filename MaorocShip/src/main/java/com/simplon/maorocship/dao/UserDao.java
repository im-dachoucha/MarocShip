package com.simplon.maorocship.dao;

import com.simplon.maorocship.Entities.User;

import java.io.Serializable;

public class UserDao extends AbstractHibernateDao<User> {
    private Class<User> clazz;
}

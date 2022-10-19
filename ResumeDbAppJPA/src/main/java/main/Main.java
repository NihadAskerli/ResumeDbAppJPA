package main;

import dao.inter.UserDaoInter;
import entity.User;



public class Main {

    public static void main(String[] args) throws Exception {
UserDaoInter userDao=Contextnew.intstanceUserDao();
   User u= userDao.getById(6);
   
        System.out.println(u.getEmail());
    }

}
package main;
import dao.impl.UserDaoImpl;
import dao.inter.CountryDaoInter;
import dao.inter.EmploymentHistoryDaoInter;
import dao.inter.SkillDaoInter;
import dao.inter.UserDaoInter;
import dao.inter.UserSkillDaoInter;

public class Contextnew {
    public static UserDaoInter intstanceUserDao(){

        return new UserDaoImpl();
    }
}

package main;
import dao.impl.CountryDaoImpl;
import dao.impl.EmploymentHistoryDaoImpl;
import dao.impl.SkillDaoImpl;
import dao.impl.UserDaoImpl;
import dao.impl.UserSkillDaoImpl;
import dao.inter.CountryDaoInter;
import dao.inter.EmploymentHistoryDaoInter;
import dao.inter.SkillDaoInter;
import dao.inter.UserDaoInter;
import dao.inter.UserSkillDaoInter;

public class Contextnew {
    public static UserDaoInter intstanceUserDao(){

        return new UserDaoImpl();
    }
    public static UserSkillDaoInter intstanceUserSkillDao(){

        return new UserSkillDaoImpl();
    }
    public static EmploymentHistoryDaoInter intstanceEmploymentHistoryDao(){

        return new EmploymentHistoryDaoImpl();
    }
    public static CountryDaoInter instanceCountryDao(){
        return new CountryDaoImpl();
    }
    public static  SkillDaoInter instanceSkillDao(){
        return new SkillDaoImpl();
    }
    public static UserSkillDaoInter instanceUserSkillDao(){
        return new UserSkillDaoImpl();
    }
}

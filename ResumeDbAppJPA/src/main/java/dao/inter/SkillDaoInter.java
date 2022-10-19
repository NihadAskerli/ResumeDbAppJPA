/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.inter;

import entity.Country;
import entity.Skill;

import java.util.List;

public interface SkillDaoInter {
    public List<Skill>  getAll();
     
    public Skill getById(int id);
    public boolean updateSkill(Skill u);
    public boolean removeSkill(int id);
    public List<Skill>getByName(String name);
    public boolean insertSkill(Skill skl);
}

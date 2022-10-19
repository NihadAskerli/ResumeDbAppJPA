/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.inter;

import entity.Country;

import java.util.List;

public interface CountryDaoInter {
    public List<Country>  getAll();
    public Country getById(int userid);
    public boolean updateCountry(Country u);
    public boolean removeCountry(int id);
    
}


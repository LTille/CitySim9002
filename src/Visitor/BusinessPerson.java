/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visitor;

import Location.LocationUtil;

/**
 *
 * @author Tillie
 */
public class BusinessPerson implements Person {
     
    @Override
    public String getType() {
        return "Business Person";
    }
    @Override
    public boolean like(String loc) {
        if(loc.equals(LocationUtil.SquirrelHill)||loc.equals(LocationUtil.Downtown))
            return true;
        return false;
    }
    
}

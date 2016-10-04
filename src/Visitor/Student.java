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
public class Student implements Person {

    @Override
    public String getType() {
        return "Student";
    }
    
    @Override
    public boolean like(String loc) {
        if(loc.equals(LocationUtil.CathedralofLearning))
            return false;
        return true;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visitor;

import Location.LocationUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Tillie
 */
public class ProfessorTest {
    /*
    * Test to verify the professor's type
    */
    @Test
    public void typeisProfessor(){
        Assert.assertEquals("Professor", new Professor().getType());
    }
   
    /*
    * Test to verify that professor like all locations
    */
    @Test
    public void preference(){
        String[] locs = LocationUtil.locsFour;
        for(String s:locs)
            Assert.assertTrue(new Professor().like(s));
    }
}

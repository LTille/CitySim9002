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
public class BusinessPersonTest {
    
   /*
    * Test to verify the blogger's type
    */
    @Test
    public void typeisBusinessPerson(){
        Assert.assertEquals("Business Person", new BusinessPerson().getType());
    }
   
    /*
    * Test to verify that business Person like Squirrel Hill and Downtown
    */
    @Test
    public void likePlace(){
        String[] locs = {LocationUtil.SquirrelHill,LocationUtil.Downtown};
        for(String s:locs)
            Assert.assertTrue(new BusinessPerson().like(s));
        
    }
    
    /*
    * Test to verity that business Person dislike all other locations
    */
    @Test
    public void dislikePlace(){
        String[] locs = {LocationUtil.CathedralofLearning,LocationUtil.ThePoint};
        for(String s:locs)
            Assert.assertFalse(new BusinessPerson().like(s));
    }
}

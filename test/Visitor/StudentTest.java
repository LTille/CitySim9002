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
public class StudentTest {
   
    /*
    * Test to verify the student's type
    */
    @Test
    public void typeisStudent(){
        Assert.assertEquals("Student", new Student().getType());
    }
   
    /*
    * Test to verify that sudent like Squirrel Hill, Downtown, The point
    */
    @Test
    public void likePlace(){
        String[] locs = {LocationUtil.Downtown,LocationUtil.SquirrelHill,LocationUtil.ThePoint};            
        for(String s:locs)
            Assert.assertTrue(new Student().like(s));
        
    }
    
    /*
    * Test to verity that student dislike Cathedral of Learning
    */
    @Test
    public void dislikePlace(){
        Assert.assertFalse(new Student().like(LocationUtil.CathedralofLearning));
    }
}

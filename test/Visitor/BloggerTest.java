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
public class BloggerTest {
    
   /*
    * Test to verify the blogger's type
    */
    @Test
    public void typeisStudent(){
        Assert.assertEquals("Blogger", new Blogger().getType());
    }
   
    /*
    * For all four locations, blogger should dislike them, meaning all return false
    */
    @Test
    public void preference(){
        String[] locs = LocationUtil.locsFour;
        for(String s:locs)
            Assert.assertFalse(new Blogger().like(s));
    }
}

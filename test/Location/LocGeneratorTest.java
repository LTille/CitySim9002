/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Location;

import java.util.HashSet;
import java.util.Random;
import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Tillie
 */
public class LocGeneratorTest {
    
    /*
    * Visitor cannot leave the City before he/she visits the first place 
    * Therefore, the random generator in the original method will only generator number 0-3, 
    * and andom number generator mocked here will always return 2 whose corresponding location
    * is "Down", meaning it will not equal to "left" whose index is 4
    */ 
    @Test
    public void firstPlaceNotLeave() {
         Random mockRandom = mock(Random.class);
         when(mockRandom.nextInt(any(Integer.class))).thenReturn(2);
         Assert.assertNotEquals("left", new LocGenerator("9").getPlace(1));
    }
    
    /*
    * Visitor should visitor one of the four places before leaving
    * Create a set that contain the four locations
    * mock any returned number from 0-3 should return true 
    */ 
    @Test
    public void firstPlaceOneofFour(){
        HashSet<String> set = new HashSet();
        String[] locs = LocationUtil.locsFour;
        for(String s:locs) set.add(s);
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(any(Integer.class))).thenReturn(2);
        Assert.assertTrue(set.contains(new LocGenerator("9").getPlace(1)));
    }
    
    /*
    * Once visitor has visited one city, he/she shall be able to 
    * visit any of the four places and leave the city.
    * Any mocked random number from 0-4, their corresponding location 
    * should in the set
    */ 
    @Test
    public void visitOtherPlace(){
        HashSet<String> set = new HashSet();
        String[] locs = LocationUtil.locsFive;
        for(String s:locs) set.add(s);
        Random mockRandom = mock(Random.class);
        when(mockRandom.nextInt(any(Integer.class))).thenReturn(4);
        Assert.assertTrue(set.contains(new LocGenerator("9").getPlace(3)));
    }
}

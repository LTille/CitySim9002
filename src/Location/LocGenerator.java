/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Location;

import java.util.Random;

/**
 *
 * @author Tillie
 */
public class LocGenerator {
    
    String[] locs = LocationUtil.locsFive;//get locations including "leave the city"
    Random rg;
    public LocGenerator(Random rg){
        this.rg=rg;
    }
   
    /*
     *This method is used to generate a random place for visitor to visit
    */
    public String getPlace(int iteration){
         return locs[getIdx(iteration)];
    }
    
     /*
     * Generate a random index based on the places visit has visited 
    */
     public int getIdx(int iteration){
        //if visitor is visiting the first place, we won't render "left city" choice
        //and the rest four places has equal probability of being visited
        if(iteration==1)
            return rg.nextInt(4);
        //if not the first place, all five choices have equal probability of being generated
        else
            return rg.nextInt(5);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visitor;

/**
 *
 * @author Tillie
 */
public class Professor implements Person {

    @Override
    public String getType() {
        return "Professor";
    }
    
    @Override
    public boolean like(String loc) {
        return true;
    }    
}

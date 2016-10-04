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
public class Blogger implements Person {
    
    @Override
    public String getType() {
        return "Blogger";
    }
    /*Blogger dislike all locations*/
    @Override
    public boolean like(String loc) {
        return false;
    }   
}

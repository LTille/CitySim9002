/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visitor;

import java.util.Random;

/**
 *
 * @author Tillie
 */
public class VisitorList {
     
    public static Person[] getVisitorList(int num,PersonFactory pf){
        String[] visitorType={"Student","Professor","Business Person","Blogger"};
        Person[] persons = new Person[num];      
        Random rg = new Random();
        for(int i=0;i<num;i++){
            persons[i]=pf.getVisitor(visitorType[rg.nextInt(4)]);
        }
        return persons;
     }
}

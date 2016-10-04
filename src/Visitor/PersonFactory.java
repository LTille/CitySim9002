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
public class PersonFactory {
     /*
     * This is the method used to create different type of Visitors
     */
     public Person getVisitor(String pt){
        if(pt.equals("Student"))
            return new Student();
        else if(pt.equals("Business Person"))
            return new BusinessPerson();
        else if(pt.equals("Blogger"))
            return new Blogger();
        else if(pt.equals("Professor"))
            return new Professor();
        return null;
     }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import Domain.Validator;
import Location.LocGenerator;
import Visitor.Person;
import Visitor.PersonFactory;
import Visitor.VisitorList;
import java.util.Random;

/**
 *
 * @author AsphaltPanthers
 */
public class CitySim9002 {
    public static String errorMessage = "Please enter one integer argument, seed";
    public static void main(String[] args) {
        //only if the user render a valid argument, will the program be executed
        if (new Validator().validateArguments(args)) {
            //Initialize generator number generator
            Random rg = new Random(Integer.valueOf(args[0]));
            
            LocGenerator lg = new LocGenerator(rg);
            //Get Five random visitors
            PersonFactory pf = new PersonFactory();
            Person[] visitors = VisitorList.getVisitorList(5,pf);
           
            System.out.print("Welcome to CitySim!  Your seed is "+args[0]+".\n");    
            
            for(int i=1;i<=5;i++){//Iterate the five visitors
                
                int iteration=0;//record the number of iteration for place generation
                System.out.println(getPrintInfo(visitors[i-1],i,iteration,""));//infor printed before visiting any place
                iteration++;
                
                while(true){//only if visitor has left the city, will this loop end  
                     String place=lg.getPlace(iteration);//get a random place
                     System.out.println(getPrintInfo(visitors[i-1],i,iteration,place));
                     // if the place equals to left, this visitor finishes his/her trip
                     if(place.equals("left"))
                         break;
                     iteration++;
                }
            }
        }
        else {
            System.out.println(errorMessage);
            System.exit(0);
        }
    }
    
    public static String getPrintInfo(Person visitor,int i,int iter,String place){
        String ans="Visitor "+i;
        if(iter==0){
            ans+=" is a "+visitor.getType()+".";
        }
        else{
            // if the place equals to left, this visitor finishes his/her trip
            if(place.equals("left"))
                ans+=" has left the city.\n***";
            else{
                ans+=" is going to "+place+"!\n";
                //identify whether or not this visitor like this place
                String str=visitor.like(place)==true?"like":"not like";
                ans+= "Visitor "+i+" did "+str+" "+place+".";
            }
        }
        return ans;
    }
}

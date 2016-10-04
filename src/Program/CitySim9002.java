/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import Domain.Validator;
import Location.LocGenerator;
import Visitor.Person;
import Visitor.VisitorList;

/**
 *
 * @author AsphaltPanthers
 */
public class CitySim9002 {
    public static String errorMessage = "Please enter one integer argument, seed";
    public static void main(String[] args) {
        //only if the user render a valid argument, will the program be executed
        if (new Validator().validateArguments(args)) {
            //Initialize place generator
            LocGenerator lg = new LocGenerator(String.valueOf(args[0]));
            //Get Five random visitors
            Person[] visitors = VisitorList.getVisitorList(5);
            System.out.print("Welcome to CitySim!  Your seed is "+args[0]+".\n");
            //Iterate the five visitors
            for(int i=1;i<=5;i++){
                System.out.print("Visitor "+i+" is a "+visitors[i-1].getType()+".\n");
                //record the number of iteration for place generation
                int iteration=1;
                //only if visitor has left the city, will this loop end
                while(true){
                    //get a random place
                     String place=lg.getPlace(iteration);
                     // if the place equals to left, this visitor finishes his/her trip
                     if(place.equals("left")){
                         System.out.print("Visitor "+i+" has left the city.\n*** \n");
                         break;
                     }
                     System.out.print("Visitor "+i+" is going to "+place+"!\n");
                     //identify whether or not this visitor like this place
                     String str=visitors[i-1].like(place)==true?"like":"not like";
                     System.out.print("Visitor "+i+" did "+str+" "+place+".\n"); 
                     iteration++;
                }
            }
        }
        else {
            System.out.println(errorMessage);
            System.exit(0);
        }
    }
}

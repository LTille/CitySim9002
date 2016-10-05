/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import Location.LocGenerator;
import Visitor.Blogger;
import Visitor.Professor;
import Visitor.Student;
import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Tillie
 */
public class CitySim9002Test {
    
    /*
    * Information printed before a visitor starts to visit
    * I test the printed information for a Blogger
    */
    @Test
    public void printTrueInfoFirstEnter(){
        Blogger mockBlogger = mock(Blogger.class);
        when(mockBlogger.getType()).thenReturn("Blogger");
        String ans ="Visitor 1 is a Blogger.\n";
        Assert.assertEquals(ans, CitySim9002.getPrintInfo(mockBlogger, 1, 0, ""));
    }
    
    /*
    * Information printed when a visitor visit a random place
    * I test the result of a student visiting downtown
    */
    @Test
    public void printTrueInfoNoLeave(){
        Student mockStudent = mock(Student.class);
        LocGenerator mockLocGenerator = mock(LocGenerator.class);
        when(mockStudent.getType()).thenReturn("Student");
        when(mockStudent.like(any(String.class))).thenReturn(true);
        when(mockLocGenerator.getPlace(any(Integer.class))).thenReturn("Downtown");
        String ans ="Visitor 2 is going to Downtown!\nVisitor 2 did like Downtown.\n";
        Assert.assertEquals(ans, CitySim9002.getPrintInfo(mockStudent, 2, 2, "Downtown"));
    }
    
    /*
    * Information printed when a visitor leaves the city
    * I test the result of a professor leaving the city
    */
     @Test
    public void printTrueInfoLeave(){
        Professor mockStudent = mock(Professor.class);
        LocGenerator mockLocGenerator = mock(LocGenerator.class);
        when(mockStudent.getType()).thenReturn("Professor");
        when(mockLocGenerator.getPlace(any(Integer.class))).thenReturn("left");
        String ans ="Visitor 3 has left the city.\n*** \n";
        Assert.assertEquals(ans, CitySim9002.getPrintInfo(mockStudent, 3, 4, "left"));
    }
}

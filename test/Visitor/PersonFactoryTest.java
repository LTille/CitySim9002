/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visitor;

import static org.hamcrest.CoreMatchers.instanceOf;
import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Tillie
 */
public class PersonFactoryTest {
    
    /*
    * We only have four types of visitors, only if the visitor type belongs to them,
    * we can get a new visitor. If not, null should be returned
    */
    @Test
    public void testTypeNotAmongFour(){
        Assert.assertNull(new PersonFactory().getVisitor("Assistant"));
    }
    
    /*
    * If a new visitor is created, it should be an instance of Person
    */
    @Test
    public void testTypePerson(){
        Assert.assertThat(new PersonFactory().getVisitor("Blogger"), instanceOf(Person.class));
    }
    
    /*
    * If a new visitor is created, it should be really the visitor 
    * we want to create. If a new student created, it should be really a student
    */
    @Test
    public void testTypePerson2(){
        Student mockStudent = mock(Student.class);
        when(mockStudent.getType()).thenReturn("Student");
        Assert.assertEquals("Student",new PersonFactory().getVisitor("Student").getType());
    }
}

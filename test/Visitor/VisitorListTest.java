/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visitor;

import static org.hamcrest.CoreMatchers.instanceOf;
import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Tillie
 */
public class VisitorListTest {
    
    /*
    * getVisitorList method aims to create an array of Five visitors with type randomly chosen among
    * the four types. Since getVisitor has been tested in PersonFactoryTest, we create
    * a sub method and test getVisitor method only. The returned Person arrray should be of length 5
    */
    @Test
    public void arraySizeEqualsFive(){  
        PersonFactory mockPersonFactory = mock(PersonFactory.class);
        when(mockPersonFactory.getVisitor(any(String.class))).thenReturn(new Student());
        Assert.assertEquals(5, VisitorList.getVisitorList(5).length);
    }
    
    /*
    * Each Person in the array is created through PersonFactory, which in turn calls the individual
    * visitor class, and each visitor class implements Person interface, therefore,
    * each Person in the returned Person arrray should be an instance of the Person class, meaning
    * we created five visitors successfully
    */
    @Test
    public void visitorTypeisPerson(){ 
        PersonFactory mockPersonFactory = mock(PersonFactory.class);
        when(mockPersonFactory.getVisitor(any(String.class))).thenReturn(new Professor());
        Assert.assertThat(VisitorList.getVisitorList(5)[3], instanceOf(Person.class));
    } 
}

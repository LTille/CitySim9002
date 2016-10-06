/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author AsphaltPanthers
 */
public class ValidatorTest {
    /*If the size of the arugment is one, validateNumberOfArguments should return true*/
    @Test
    public void ifOneArgumentIsProvidedReturnTrue() {
        Assert.assertTrue(new Validator().validateNumberOfArguments(new String[] { "1" }));
    }
    
    /*If the size of the arugment is larger than one, validateNumberOfArguments should return false*/
    @Test
    public void ifOneArgumentIsNotProvidedReturnFalse() {
        Assert.assertFalse(new Validator().validateNumberOfArguments(new String[] { "1", "2" }));
    }
    
    /*If the arugment passed in is Integer, validateArgumentType should return true*/
    @Test
    public void ifArgumentIsAnIntegerReturnTrue() {
        Assert.assertTrue(new Validator().validateArgumentType(new String[] { "1" }));
    }
    
    /*If the arugment passed in is String, validateArgumentType should return false*/
    @Test
    public void ifArgumentIsNotAnIntegerReturnFalse() {
        Assert.assertFalse(new Validator().validateArgumentType(new String[] { "test" }));
    }
    
    /*
    * Mock validateNumberOfArguments and validateArgumentType to make sure the argument
    * pass in not only is Integer but also has length of 1.  
    */
    @Test
    public void ifArgumentsLengthAndArgumentTypesIsCorrect(){
        Validator mockValidator = mock(Validator.class);
        when(mockValidator.validateNumberOfArguments(any(String[].class))).thenReturn(true);
        when(mockValidator.validateArgumentType(any(String[].class))).thenReturn(true);
        when(mockValidator.validateArguments(any(String[].class))).thenCallRealMethod();
        Assert.assertTrue(mockValidator.validateArguments(new String[0]));
    }
}

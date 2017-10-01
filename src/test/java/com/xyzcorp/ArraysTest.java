package com.xyzcorp;

import com.xyzcorp.people.American;
import com.xyzcorp.people.Massachussettsan;
import com.xyzcorp.people.Raleighite;
import org.junit.Test;

public class ArraysTest {


    //18. Arrays naturally covariant
    @Test
    public void testArraysAreNaturallyCovariant() throws Exception {
        American[] americans = new Massachussettsan[]{};
        americans[0] = new Massachussettsan();
        americans[1] = new Raleighite();
        American american = americans[0];
    }

    //19. Internal Checking for Arrays
    @Test
    public void testArrayStoreException() throws Exception {
        //internal tracking will stop any foreign elements from being added
        Object[] objectArray = new String[10];
        objectArray[0] = new Long(0L);
    }

    //20. Cannot create a Generic Array
    @Test
    public void testErasureIssuesWithAnArray() throws Exception {
        //List<Integer>[] integerList = new ArrayList<String>[10]; //No can do: generic array creation
        //if it were allowed we can avoid the arrays internal check mechanism
    }
}

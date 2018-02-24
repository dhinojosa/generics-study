package com.xyzcorp;

import com.xyzcorp.people.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ArraysTest {

    //18. Arrays naturally covariant
    @Test
    public void testArraysAreNaturallyCovariant() throws Exception {
        American[] americans = new Massachusettsan[3];
        americans[0] = new Massachusettsan();
        americans[1] = new Raleighite();
        americans[2] = new Wisconsinite();
        American american = americans[0];
        Person person = americans[0];
        Object object = americans[0];

        //The following will not work
        //Massachusettsan massachusettsan = americans[0];
        //Raleighite raleighite = americans[1];
        //Wisconsinite wisconsinite = americans[2];
    }

    /**
     * 19. Internal Checking for Arrays
     * internal tracking will stop any foreign elements from being added
     * at runtime, this test will fail but won't know about it
     * at compile time.
     */
    @Test
    public void testArrayStoreException() throws Exception {
        Object[] objectArray = new String[10];
        objectArray[0] = new Long(0L);
    }

    /**
     * Case 20: You cannot create a generic array.
     * If it were allowed we can avoid the arrays internal check
     * mechanism.
     */
    @Test
    public void testErasureIssuesWithAnArray() {
        //List<Integer>[] integerList = new ArrayList<String>[10];
    }
}

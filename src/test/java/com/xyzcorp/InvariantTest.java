package com.xyzcorp;

import com.xyzcorp.people.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InvariantTest {

    public void processInvariantList(List<American> americans) {
        Object object = americans.get(1);                //producer
        Person person = americans.get(1);                //producer
        NorthAmerican northAmerican = americans.get(1);  //producer
        American american = americans.get(1);            //producer

        americans.add(new American());                   //consumer
        americans.add(new Massachusettsan());            //consumer
        americans.add(new Coloradan());                  //consumer
        americans.add(new Denverite());                  //consumer
        americans.add(null);                             //consumer
    }
























    //9. Invariant Method Calls
    @Test
    public void testInvariantMethod() throws Exception {
        processInvariantList(Arrays.asList(new American(), new Wisconsinite()
                , new Madisonian(), new Milwaukeean(), new SanFranciscan()));
    }


    //10. Invariant Assignments
    @Test
    public void testInvariantAssignment() throws Exception {
        List<American> americans = new ArrayList<American>();
        //americans.add(new Object());                         //won't work
        //americans.add(new NorthAmerican());                  //won't work
        americans.add(new American());                         //consumer
        americans.add(new Massachusettsan());                  //consumer
        americans.add(new Bostonian());                        //consumer
        americans.add(new Milwaukeean());

        Object object = americans.get(1);                      //producer
        Person person = americans.get(1);                      //producer
        NorthAmerican northAmerican = americans.get(1);        //producer
        American american = americans.get(1);                  //producer
        //Massachusettsan massachusettsan = americans.get(1);  //won't work
        //Bostonian bostonian = americans.get(1);              //won't work
        //Madisonian madisonian = americans.get(0);
    }

}

package com.xyzcorp;

import com.xyzcorp.people.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class InvariantTest {



    public void processInvariantList(List<American> americans) {
        Object object = americans.get(1);                //producer
        NorthAmerican northAmerican = americans.get(1);  //producer
        American american = americans.get(1);            //producer

        americans.add(new American());                   //consumer
        americans.add(new NorthCarolinian());            //consumer
        americans.add(new Raleighite());                 //consumer
    }

    //9. Invariant Method Calls
    @Test
    public void testInvariantMethod() throws Exception {
        List<American> americans = new ArrayList<>();
        americans.add(new American());        //Yes!
        americans.add(new SouthCarolinian()); //Yes!
        processInvariantList(americans);
    }


    //10. Invariant Assignments
    @Test
    public void testInvariantAssignment() throws Exception {
        List<American> americans = new ArrayList<American>();
        //americans.add(new Object());                         //won't work
        //americans.add(new NorthAmerican());                  //won't work
        americans.add(new American());                         //consumer
        americans.add(new NorthCarolinian());                  //consumer
        americans.add(new Raleighite());                       //consumer

        Object object = americans.get(1);                      //producer
        Person person = americans.get(1);                      //producer
        NorthAmerican northAmerican = americans.get(1);        //producer
        American american = americans.get(1);                  //producer
        //NorthCarolinian northCarolinian = americans.get(1);  //won't work
        //Raleighite raleighite = americans.get(1);            //won't work
    }

}

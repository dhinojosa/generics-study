package com.xyzcorp;

import com.xyzcorp.people.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("WeakerAccess")
public class ContravariantTest {

    //You know the boundary but you don't know the specifics
    public void processContravariantList(List<? super American>
                                                 americans) {
        americans.add(new American());
        americans.add(new Massachusettsan());
        americans.add(new Bostonian());
        americans.add(new Wisconsinite());
        americans.add(new Madisonian());
        americans.add(new NorthernCalifornian());
        americans.add(new Raleighite());
        americans.add(new Denverite());
        americans.add(new Coloradan());
        //americans.add(new European()); Nein!

        //americans.add(new Person());

        americans.add(null);

        Object o = americans.get(0);
    }

    //16. Contravariant Method
    @Test
    public void testContravariantMethod() {
        processContravariantList(
                Arrays.<Object>asList(new Object(), new Object()));
        processContravariantList(
                Arrays.<Person>asList(new Person(), new Person()));
        processContravariantList(
                Arrays.<NorthAmerican>asList(new NorthAmerican(), new NorthAmerican()));
        processContravariantList(
                Arrays.<American>asList(new American(), new Bostonian()));
        //processContravariantList(
        //        Arrays.<Bostonian>asList(new Bostonian(), new Bostonian()));
    }

    //17. Contravariant Assignment
    @Test
    public void testContravariantAssignment() {
        List<? super American> americans = new ArrayList<Person>();
        Object object = americans.get(0); //special case

//       Person person = americans.get(0);                   //nope
//        NorthAmerican northAmerican = americans.get(0);     //nope
//        American american = americans.get(0);               //nope
//        Massachusettsan Massachusettsan = americans.get(0); //nope
//        Bostonian bostonian = americans.get(0);           //nope

//        americans.add(new Object());
//        americans.add(new Person());
//        americans.add(new NorthAmerican());
        americans.add(new American());
        americans.add(new Massachusettsan());
        americans.add(new Bostonian());
        americans.add(null);
    }
}

package com.xyzcorp;

import com.xyzcorp.people.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CovariantTest {

    public void processCovariantList(List<? extends American> americans) {
        Object object = americans.get(0);
        Person person = americans.get(0);
        NorthAmerican northAmerican = americans.get(0);
        American american = americans.get(0);

        //only a null
        americans.add(null);
    }

    //11. Process Covariant List
    @Test
    public void testCovariantAmericanList() throws Exception {
        List<Massachusettsan> americans = new ArrayList<>();
        processCovariantList(americans);
    }

    //12. Process Covariant Assignment
    @Test
    public void testCovariantAssignment() throws Exception {
        List<? extends American> people = new ArrayList<Bostonian>();
        Object object = people.get(0);
        Person person = people.get(0);
        NorthAmerican northAmerican = people.get(0);
        American american = people.get(0);


        //Massachusettsan massachusettsan= people.get(0);
        //Bostonian ralieghite= people.get(0);

//        people.add(new Object());
//        people.add(new Person());
//        people.add(new NorthAmerican());
//        people.add(new American());
//        people.add(new Massachusettsan());
//        people.add(new Bostonian());
        people.add(null); //special case
    }

    public void processCovariantPersonList(List<? extends Person> people) {
        Object object = people.get(0);
        Person person = people.get(0);

//        people.add(new Person("Justin", "Bieber"));
        people.add(null);
    }

    //13. Process Covariant Assignment
    @Test
    public void testCovariantPersonList() throws Exception {
        List<? extends Person> people = Arrays.<Bostonian>asList(new Bostonian(), new Bostonian());
        processCovariantPersonList(people);
    }

    //14. Process Covariant Assignment
    @Test
    public void testMixMatchedPersonList() throws Exception {
        List<? extends Bostonian> bostonians = Arrays.asList(new Bostonian(), new Bostonian());
        List<? extends American> people = bostonians;
        processCovariantPersonList(people);
    }

    public void processCovariantObjectList(List<? extends Object> people) {
        Object object = people.get(0);
        //Person person = people.get(0);
        //Bostonian bostonian = people.get(0);

        people.add(null);
    }

    //15. Process Covariant Assignment with Object List
    @Test
    public void testProcessCovariantObjectList() throws Exception {
        List<?> objects = Arrays.<Bostonian>asList(new Bostonian(), new Bostonian());
        List<?> objects2 = Arrays.<Object>asList(new Object(), new Object());
        processCovariantObjectList(objects);
        processCovariantObjectList(objects2);
    }


    public Number collectionWithSuper(List<? super Number> numbers, int seed) {
        double total = seed;
        for (int i  = 0; i < numbers.size(); i ++) {
            numbers.add(i + 10);
        }
        return total;
    }

    public Number collectionWithExtends(List<? extends Number> integers, int seed) {
        double total = seed;
        for (int i  = 0; i < integers.size(); i ++) {
            total += integers.get(i).intValue() + 1;
        }
        return total;
    }

    /**
     * The following test was created stemming from questions
     * from the Boston NFJS 2017-09-23
     */
    @Test
    public void testRulesWithFlexability() {
        collectionWithSuper(Arrays.<Object>asList(1,2,3,4,5), 30);
        collectionWithExtends(Arrays.<Integer>asList(1,2,3,4,5), 30);
    }
}

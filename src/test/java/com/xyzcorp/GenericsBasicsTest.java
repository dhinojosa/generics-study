package com.xyzcorp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GenericsBasicsTest {

    //1. Demo: Raw Types
    @SuppressWarnings("unchecked")
    @Test
    public void testRawTypes() throws Exception {
        List list = new ArrayList();
        list.add("Foo");
        list.add(4);
        list.add(10.0);
        Object object = list.get(0); //Object
        if (object instanceof String) {
            String string = (String) object;
        }
    }

    //2. Demo: Needless Casting of Raw Types Before
    @SuppressWarnings("unchecked")
    @Test
    public void testAnotherWithCastingWithRawTypes() throws Exception {
        List words = new ArrayList(); //raw type
        words.add("Hello ");
        words.add("world!");
        String s = ((String) words.get(0)) +
                ((String) words.get(1));
    }

    //3. Demo: No Casting of Raw Types After
    @Test
    public void testEliminationOfCasting() throws Exception {
        List<String> words = new ArrayList<>();
        words.add("Hello ");
        words.add("world!");
        String s = words.get(0) + words.get(1);
    }

    //4. Demo: Needless Boxing and Unboxing Before
    @SuppressWarnings("unchecked")
    @Test
    public void testAutomaticBoxingOfPrimitivesBefore() throws Exception {
        List<Integer> ints = new ArrayList<>();
        ints.add(Integer.valueOf(1));
        int n = ints.get(0).intValue();
    }

    //5. Demo: Needless Boxing and Unboxing After
    @Test
    public void testAutomaticBoxingOfPrimitivesAfter() throws Exception {
        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        int n = ints.get(0);
    }

    //6. Demo: A Container in a container
    @Test
    public void testContainerInAContainer() throws Exception {
        List<List<Integer>> ints = new ArrayList<>();
        ints.add(Arrays.asList(4, 10, 11, 12));
        ints.add(Arrays.asList(5, 9, 3, 42));
        Integer actual = ints.get(0).get(1);
        assertThat(actual).isEqualTo(10);
    }

    //7. Demo: Static
    @Test
    public void testOverrideStaticGenericTypes() throws Exception {
        Number n  = Arrays.<Number>asList(5, 1, 3, 5, 6, 10).get(0);
        assertThat(n).isInstanceOf(Number.class);
    }

    //8. Demo: Erasure
    @Test
    @SuppressWarnings("InstantiatingObjectToGetClassObject")
    public void testErasure() throws Exception {
        System.out.format("Runtime type of ArrayList<String>: %s\n",
                new ArrayList<String>().getClass());
        System.out.format("Runtime type of ArrayList<Long>  : %s\n",
                new ArrayList<Long>().getClass());
    }

    @Test
    public void testStream() throws Exception {
        //Arrays.asList(1,2,3).stream()
    }
}

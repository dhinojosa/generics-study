package com.xyzcorp;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SafeVarArgsTest {

    //I'm lying
    @SafeVarargs
    public final void process(List<String>... args) {
        System.out.println(args.getClass().getName());
        System.out.println(args.getClass().getComponentType());
        Object[] array = args; //Masking the List
        List<Integer> tmpList = Collections.singletonList(42);
        array[0] = tmpList; // Semantically invalid, but compiles without warnings
        String s = args[0].get(0); // Oh no, ClassCastException at runtime!
    }

    //22. Varargs Scenario
    @Test
    public void testVarArgs() {

        process(Arrays.asList("Foo", "Bar", "Baz"), Arrays.asList("Zoom", "Room", "Voom"));
    }
}

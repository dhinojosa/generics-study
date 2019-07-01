package com.xyzcorp;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SafeVarArgsTest {

    /*
     * From:
     * https://docs.oracle.com/javase/7/docs/api/java/lang/SafeVarargs.html
     * Varargs are internally an array, but the compiler cannot guarantee
     * any safety, so it would be up to you to determine whether what
     * you placed into the method is safe.
     *
     */
    @SuppressWarnings("UnnecessaryLocalVariable")
    @SafeVarargs
    private final void process(List<String>... args) {
        System.out.println(args.getClass().getName());
        System.out.println(args.getClass().getComponentType());

        //Masking the List of String, it is after all, a List<String>
        Object[] array = args;
        List<Integer> tmpList = Collections.singletonList(42);

        // Semantically invalid, but compiles without warnings
        array[0] = tmpList;

        // Oh no, ClassCastException at runtime!
        String s = args[0].get(0);
    }

    @Test
    public void testVarArgs() {
        process(Arrays.asList("Foo", "Bar", "Baz"),
                Arrays.asList("Zoom", "Room", "Voom"));
    }
}

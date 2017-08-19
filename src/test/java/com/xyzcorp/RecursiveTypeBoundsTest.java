package com.xyzcorp;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class RecursiveTypeBoundsTest {

    //Clean this up
    public class Foo implements Comparable<Foo> {
        private int i = 0;

        public Foo(int i) {
            this.i = i;
        }

        @Override
        public int compareTo(Foo o) {
            if (o == this) return 0;
            return Integer.compare(i, o.i);
        }
    }


    //26. Recursive Type Bound Fix!
    @Test
    public void testComparableWithNoRecursiveTypeBound() {
        Foo foo = new Foo(4);
        Foo foo2 = new Foo(5);
        assertThat(foo.compareTo(foo2)).isLessThan(0);
    }

    public static <T extends Comparable<T>> Optional<T> myMax(Collection<T> items) {
        T result = null;
        for (T item : items) {
            if (result == null || item.compareTo(result) > 0) result = item;
        }
        if (result == null) return Optional.empty();
        return Optional.of(result);
    }

    //27. Static method
    @Test
    public void testComparableMyMax() {
        Foo foo = new Foo(4);
        Foo foo2 = new Foo(5);
        Foo foo3 = new Foo(1);
        Foo foo4 = new Foo(10);
        assertThat(myMax(Arrays.asList(foo, foo2, foo3, foo4))).contains(foo4);
    }
}

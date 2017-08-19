package com.xyzcorp;

import com.xyzcorp.containers.Box;
import com.xyzcorp.containers.MyCollection;
import com.xyzcorp.containers.Tuple2;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomObjectTest {
    @Test
    public void testBoxCreation() throws Exception {
        Box<Integer> box = new Box<>(4);
        box.map(e -> e + 10);
        assertThat(box.getContent()).isEqualTo(14);
    }

    @Test
    public void testTuple2Creation() throws Exception {
        Tuple2<Integer, String> t2 = new Tuple2<Integer, String>(3, "Foo");
        Integer k = t2.getK();
        String v = t2.getV();
    }

    @Test
    public void testMyCollection() throws Exception {
        MyCollection<String> myCollection = new MyCollection<>("One", "Two", "Three");
    }
}

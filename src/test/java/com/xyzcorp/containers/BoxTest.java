package com.xyzcorp.containers;

import org.junit.Test;

import java.util.function.Function;

import static org.junit.Assert.*;

public class BoxTest {

    @Test
    public void testBox() throws Exception {
        Box<String> bs = new Box<>("Hello");
        Box<Integer> result = bs.map(String::length);
    }


    @Test
    public void testBox2() throws Exception {
        Box<String> bs = new Box<>("Hello");
        Box<CharSequence> result = bs.map(s -> s.subSequence(0, 4));
    }
}
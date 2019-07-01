package com.xyzcorp.boundedtypeparams;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Box <T> {

    private final T t;

    public Box(T t) {
        this.t = t;
    }

    public <U> Box<U> map(Function<T, U> f) {
        return null;
    }
}

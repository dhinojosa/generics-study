package com.xyzcorp.boundedtypeparams;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Box <T extends Number> {

    private final T t;

    public Box(T t) {
        this.t = t;
    }

    public <U extends Appendable> void foo(U u) throws IOException {
        u.append(this.t.toString());
        u.append(this.t.toString());
    }

    public <U extends Appendable> List<U> bar(List<? extends U> u) throws IOException {
        return u.stream().map(x -> {
            try {
                x.append("Foo!");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return x;
        }).collect(Collectors.toList());
    }
}

package com.xyzcorp.containers;

import java.util.Objects;
import java.util.function.Function;

public class Box<E> {
    private E e;

    public Box(E e) {
        this.e = e;
    }

    public E getContent() {
        return e;
    }

    public void setContent(E e) {
        this.e = e;
    }

    public <U> Box<U> map(Function<? super E, ? extends U> function) {

        U apply = function.apply(e);

        return new Box<U>(apply);
    }

    public static <A> Box<A> of(A e2) {
        return new Box<>(e2);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Box{");
        sb.append("e=").append(e);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Box<?> box = (Box<?>) o;
        return Objects.equals(e, box.e);
    }

    @Override
    public int hashCode() {
        return Objects.hash(e) % 49;
    }
}

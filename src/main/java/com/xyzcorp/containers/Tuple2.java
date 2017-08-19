package com.xyzcorp.containers;

import java.util.Objects;

public class Tuple2<K,V> {
    private final K k;
    private final V v;

    public Tuple2(K k, V v) {
        this.k = k;
        this.v = v;
    }

    public static <M, N> Tuple2<Tuple2<M, M>, Tuple2<N, N>> doubleIt (Tuple2<M, N> t2) {
        return new Tuple2<>(new Tuple2<>(t2.k, t2.k), new Tuple2<>(t2.v, t2.v));
    }

    public K getK() {
        return k;
    }

    public V getV() {
        return v;
    }

    @Override
    @SuppressWarnings("StringBufferReplaceableByString")
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Tuple2 {");
        builder.append("k: ");
        builder.append(Objects.toString(k, "<none>"));
        builder.append(",v: ");
        builder.append(Objects.toString(k, "<none>"));
        builder.append("}");
        return builder.toString();
    }
}

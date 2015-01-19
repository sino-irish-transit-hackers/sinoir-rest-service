package com.sinoir.rest;

import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CollectionUtils {
    public static <A, B> Iterable<Map.Entry<A, B>> zip(Iterable<A> a, Iterable<B> b) {
        Iterator<A> ai = a.iterator();
        Iterator<B> bi = b.iterator();

        List<Map.Entry<A, B>> result = new ArrayList<>();
        while (ai.hasNext() && bi.hasNext())
            result.add(Maps.immutableEntry(ai.next(), bi.next()));

        return result;
    }
}

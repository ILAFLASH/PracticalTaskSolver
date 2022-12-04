package com.example.project.other;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.*;
import java.util.stream.Collector;

public class GroupByEquals<T> implements Collector<T, Map<T, Integer>, Map<T, Integer>> {
    private final Predicate<T> predicate;

    public GroupByEquals(Predicate<T> predicate) {
        this.predicate = predicate;
    }

    @Override
    public Supplier<Map<T, Integer>> supplier() {
        return HashMap::new;
    }

    @Override
    public BiConsumer<Map<T, Integer>, T> accumulator() {
        return (map, element) -> {
            if (predicate.test(element)) {
                Integer n = map.getOrDefault(element, 0);
                map.put(element, n + 1);
            }
        };
    }

    @Override
    public BinaryOperator<Map<T, Integer>> combiner() {
        return (map1, map2) -> {
            HashMap<T, Integer> result = new HashMap<>(map1);
            map2.forEach((k, v) -> {
                Integer n = result.getOrDefault(k, 0);
                result.put(k, n + 1);
            });
            return result;
        };
    }

    @Override
    public Function<Map<T, Integer>, Map<T, Integer>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Set.of(Characteristics.IDENTITY_FINISH, Characteristics.UNORDERED);
    }
}
